package com.springboot.todo.Service.Impl;

import com.springboot.todo.Entity.Status;
import com.springboot.todo.Entity.Task;
import com.springboot.todo.Repo.TaskRepo;
import com.springboot.todo.Service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Override
    public Task createTask(Task task) {
        // Ensure required defaults when creating via frontend
        if (task.getStatus() == null) {
            task.setStatus(Status.TODO);
        }
        if (task.getPriority() == null) {
            // Fallback default in case frontend omits it
            task.setPriority(com.springboot.todo.Entity.Priority.LOW);
        }
        return taskRepo.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    @Override
    public Task updateTask(Long id, Task updated) {
        Task existing = getTaskById(id);
        // Update mutable fields
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        // Only overwrite status/priority if provided to avoid nulling non-null columns
        if (updated.getStatus() != null) {
            existing.setStatus(updated.getStatus());
        }
        if (updated.getPriority() != null) {
            existing.setPriority(updated.getPriority());
        }
        existing.setDueDate(updated.getDueDate());
        return taskRepo.save(existing);
    }

    @Override
    public void deleteTask(Long id) {
        if (!taskRepo.existsById(id)) {
            throw new RuntimeException("Task not found with id: " + id);
        }
        taskRepo.deleteById(id);
    }

    @Override
    public Task updateStatus(Long id, Status status) {
        Task existing = getTaskById(id);
        existing.setStatus(status);
        return taskRepo.save(existing);
    }
}
