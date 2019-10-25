package edu.escuelaing.arem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import edu.eci.ieti.tablero.Persistence.Repositories.ITaskRepository;
import edu.eci.ieti.tablero.Persistence.Repositories.IUserRepository;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResponisbleTest{

    @Autowired
    ITaskRepository taskRepository;

    @Autowired
    IUserRepository userRepository;



    @Test
    public void meanTest1() throws IOException {
        userRepository.
        assertEquals(5,5);
    }
    
}