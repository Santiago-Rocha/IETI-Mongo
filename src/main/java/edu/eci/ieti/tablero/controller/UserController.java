package edu.eci.ieti.tablero.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.tablero.model.Team;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.IUserService;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<User> getUsersList() {
        return userService.getUsersList();
    }

    @RequestMapping(value="/user{userid}", method=RequestMethod.GET)
    public User getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    public void removeUser(String userId) {
        userService.removeUser(userId);
    }


    
    



}