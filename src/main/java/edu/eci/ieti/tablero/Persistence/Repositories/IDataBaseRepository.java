package edu.eci.ieti.tablero.Persistence.Repositories;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;

@Service
public interface IDataBaseRepository {

    List<User> getUsersList();
    
    User getUserById(String userId);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);

    List<Task> geTasksList();
    
    Task getTaskById(String id);
    
    List<Task> getTasksByUserId(String userId);
    
    Task assignTaskToUser(String taskId, User user);
    
    void removeTask(String taskId);
    
    Task updateTask(Task task);

    Task addTask(Task task);
}