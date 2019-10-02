package edu.eci.ieti.tablero.Persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.ieti.tablero.Persistence.Repositories.IDataBaseRepository;
import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;

@Component
public class DataBaseRepositoryImp implements IDataBaseRepository{
    static List<User> users = new ArrayList<User>();
    static List<Task> tasks = new ArrayList<Task>();

    @Override
    public List<User> getUsersList() {
        return users;
    }

    @Override
    public User getUserById(String userId) {
        int index = 0;
        while(index < users.size() && !users.get(index).getUserName().equals(userId)) index++;
        return index != users.size() ? users.get(index) : null ;

    }

    @Override
    public User createUser(User user) {
        users.add(user);
        return users.get(users.size()-1);
    }

    @Override
    public User updateUser(User user) {
        int index = 0;
        while(index < users.size() && !users.get(index).getUserName().equals(user.getUserName())) index++;
        users.set(index, user);
        return users.get(users.size()-1);
    }

    @Override
    public void removeUser(String userId) {
        int index = 0;
        while(index < users.size() && !users.get(index).getUserName().equals(userId)) index++;
        users.remove(index);

    }

    @Override
    public List<Task> geTasksList() {
        return tasks;
    }

    @Override
    public Task getTaskById(String id) {
        int index = 0;
        while(index < tasks.size() && !tasks.get(index).getTitle().equals(id)) index++;
        return index != tasks.size() ? tasks.get(index) : null ;
    }

    @Override
    public List<Task> getTasksByUserId(String userId) {
        List<Task> taskByUser =  new ArrayList<Task>();
        for(Task task : tasks){
            if(task.getResponsible().getUserName().equals(userId)) taskByUser.add(task);
        }

        return taskByUser;
    }

    @Override
    public Task assignTaskToUser(String taskId, User user) {
        int index = 0;
        while(index < tasks.size() && !tasks.get(index).getTitle().equals(taskId)) index++;
        tasks.get(index).setResponsible(user);
        return tasks.get(index);
        
    }

    @Override
    public void removeTask(String taskId) {
        int index = 0;
        while(index < tasks.size() && !tasks.get(index).getTitle().equals(taskId)) index++;
        tasks.remove(index);

    }

    @Override
    public Task updateTask(Task task) {
        int index = 0;
        while(index < tasks.size() && !tasks.get(index).getTitle().equals(task.getTitle())) index++;
        tasks.set(index, task);
        return tasks.get(index);

    }

    @Override
    public Task addTask(Task task) {
        tasks.add(task);
        return tasks.get(tasks.size()-1);
    }

    
}