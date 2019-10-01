package edu.eci.ieti.tablero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.ITaskService;

@RestController
public class TaskController {

    @Autowired
    ITaskService taskService;

    @RequestMapping(value="/task", method=RequestMethod.GET)
    public List<Task> getTasks() {
        return taskService.geTasksList();
    }

    @RequestMapping(value="/task/{id}", method=RequestMethod.GET)
    public Task getTaskById(@PathVariable String id) {
        return taskService.getTaskById(id);
    }

    @RequestMapping(value="/task/user={userid}", method=RequestMethod.GET)
    public List<Task> getTasksByUserId(String userId) {
        return taskService.getTasksByUserId(userId);
    }

    @RequestMapping(value="/task/{taskId}", method=RequestMethod.POST)
    public Task assignTaskToUser(@PathVariable String taskId, @RequestBody User user) {
        return taskService.assignTaskToUser(taskId, user);
    }

    @RequestMapping(value="/task/{taskId}", method=RequestMethod.DELETE)
    public void removeTask(String taskId) {
        taskService.removeTask(taskId);
    }

    @RequestMapping(value="/task/{taskId}", method=RequestMethod.DELETE)
    public Task updateTask(Task task) {
        return taskService.updateTask(task);
    }





  



    
    ;



}