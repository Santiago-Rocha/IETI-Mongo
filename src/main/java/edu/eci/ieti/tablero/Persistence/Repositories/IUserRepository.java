package edu.eci.ieti.tablero.Persistence.Repositories;


import edu.eci.ieti.tablero.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface IUserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);
    User findBy_id(String id);
    

}