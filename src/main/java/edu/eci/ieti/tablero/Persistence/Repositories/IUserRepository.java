package edu.eci.ieti.tablero.Persistence.Repositories;


import edu.eci.ieti.tablero.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface IUserRepository extends MongoRepository<User, String> {

    User findByUserName(String firstName);
    

}