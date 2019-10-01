package edu.eci.ieti.tablero.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.tablero.Persistence.Repositories.IDataBaseRepository;
import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.ITaskService;

@Component
public class TaskServiceImp implements ITaskService {

    @Autowired
    IDataBaseRepository dataBaseRepository;

    @Override
    public List<Task> geTasksList() {
        return dataBaseRepository.geTasksList();
    }

    @Override
    public Task getTaskById(String id) {
        return dataBaseRepository.getTaskById(id);
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        return dataBaseRepository.getTasksByUserId(userId);
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        return dataBaseRepository.assignTaskToUser(taskId, user);
    }

    @Override
    public void removeTask(String taskId) {
        dataBaseRepository.removeTask(taskId);

    }

    @Override
    public Task updateTask(Task task) {
        return dataBaseRepository.updateTask(task);
    }

}