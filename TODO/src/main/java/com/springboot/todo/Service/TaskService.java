package com.springboot.todo.Service;

import com.springboot.todo.Entity.Status;
import com.springboot.todo.Entity.Task;

import java.util.List;

public interface TaskService {

    Task createTask(Task task);
    List<Task> getAllTask();
    Task getTaskById(Long id);
    Task updateTask(Long id, Task updated);
    void deleteTask(Long id);
    Task updateStatus(Long id, Status status);
}
