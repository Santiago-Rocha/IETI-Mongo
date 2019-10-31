package edu.eci.ieti.tablero.services;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.eci.ieti.tablero.model.User;

@Service
public interface IUserService {
    List<User> getUsersList();
    
    User getUserById(String userId);

    User getUserByUserName(String userName);
    
    User createUser(User user);
    
    User updateUser(User user);
    
    void removeUser(String userId);
}