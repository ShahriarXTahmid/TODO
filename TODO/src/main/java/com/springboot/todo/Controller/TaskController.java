package com.springboot.todo.Controller;

import com.springboot.todo.Entity.Status;
import com.springboot.todo.Entity.Task;
import com.springboot.todo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TaskController {

    private final TaskService taskService;

    // POST http://localhost:8080/api/tasks
    // Create a new task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task created = taskService.createTask(task);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("/api/tasks/" + created.getId()));
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    // GET http://localhost:8080/api/tasks
    // Get all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    // GET http://localhost:8080/api/tasks/{id}
    // Get a task by id
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTaskById(id));
    }

    // PUT http://localhost:8080/api/tasks/{id}
    // Update entire task by id
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updated) {
        return ResponseEntity.ok(taskService.updateTask(id, updated));
    }

    // PATCH http://localhost:8080/api/tasks/{id}/status?status=IN_PROGRESS
    // Update only status
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestParam Status status) {
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    // DELETE http://localhost:8080/api/tasks/{id}
    // Delete task by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    // Convert service not-found exceptions to 404 Not Found
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
