package edu.eci.ieti.tablero.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.eci.ieti.tablero.Persistence.Repositories.IDataBaseRepository;
import edu.eci.ieti.tablero.Persistence.Repositories.IUserRepository;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.IUserService;


@Component
public class UserServiceImpl implements IUserService {

    @Autowired
    IDataBaseRepository dataBaseRepository;
    
    
    @Autowired
    IUserRepository userRepository;
    

    @Override
    public List<User> getUsersList() {
        return dataBaseRepository.getUsersList();
    }

    @Override
    public User getUserById(String userId) {
        return dataBaseRepository.getUserById(userId);
    }

    @Override
    public User createUser(User user) {
        userRepository.save(user);
        return userRepository.findBy_id(user.get_id().toString());
    }

    @Override
    public User updateUser(User user) {
        return dataBaseRepository.updateUser(user);
    }

    @Override
    public void removeUser(String userId) {
        dataBaseRepository.removeUser(userId);

    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
    
}