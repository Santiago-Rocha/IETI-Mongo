package edu.eci.ieti.tablero.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.ITaskService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @Autowired
    GridFsTemplate gridFsTemplate;

    @RequestMapping(value="/task", method=RequestMethod.GET)
    public ResponseEntity<?> getTasks() {
        return new ResponseEntity<>(taskService.geTasksList(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/task/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> getTaskById(@PathVariable String id) {
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/task/user={userid}", method=RequestMethod.GET)
    public ResponseEntity<?> getTasksByUserId(String userId) {
        return new ResponseEntity<>(taskService.getTasksByUserId(userId),HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/task/assign/{taskId}", method=RequestMethod.PUT)
    public ResponseEntity<?> assignTaskToUser(@PathVariable String taskId, @RequestBody User user) {
        return new ResponseEntity<>(taskService.assignTaskToUser(taskId, user), HttpStatus.OK);
    }

    @RequestMapping(value="/task/{taskId}", method=RequestMethod.DELETE)
    public ResponseEntity<?> removeTask(@PathVariable String taskId) {
        taskService.removeTask(taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value="/task/{taskId}", method=RequestMethod.PUT)
    public ResponseEntity<?> updateTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskService.updateTask(task), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value="/task", method=RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        System.out.println(task);
        return new ResponseEntity<>(taskService.addTask(task), HttpStatus.CREATED);
    }

    @PostMapping("/files")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());
        return file.getOriginalFilename();
    }





  



    
    ;



}