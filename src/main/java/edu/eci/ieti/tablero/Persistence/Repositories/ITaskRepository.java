package edu.eci.ieti.tablero.Persistence.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;

import java.util.List;


public interface ITaskRepository extends MongoRepository<Task, String> {

    Task findByResponsible(User responsible);
    Task findBy_id(String id);
    

}