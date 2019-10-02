package edu.eci.ieti.tablero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;

@Service
public interface ITaskService {
    List<Task> geTasksList();
    
    Task getTaskById(String id);
    
    List<Task> getTasksByUserId(String userId);

    Task addTask(Task task);
    
    Task assignTaskToUser(String taskId, User user);
    
    void removeTask(String taskId);
    
    Task updateTask(Task task);
}