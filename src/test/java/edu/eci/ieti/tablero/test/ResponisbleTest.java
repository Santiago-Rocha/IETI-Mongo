package edu.eci.ieti.tablero.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.ITaskService;
import edu.eci.ieti.tablero.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResponisbleTest{

    @Autowired
    IUserService userService;
    
    @Autowired
    ITaskService taskService;

    @Test
    public void responsibleTest() throws IOException {
        User user =  new User();
        user.setName("Prueba");
        user.setUserName("srd99");
        user.setPassword("123456789");
        user.set_id(new ObjectId("5db368fe0317aa1e74465338"));
        //userService.createUser(user);
       
        Task task =  new Task();
        task.setDueDate(new Date(2024,12,24)); 
        task.setDescription("pruebita");
        task.setResponsible(user);
        task.setTitle("lab");
        //taskService.addTask(task);
        
        Task t = taskService.getByResponsible(user);

        assertEquals(t.getTitle(),task.getTitle());
        assertEquals(t.getDescription(),task.getDescription());
    	
    	
    	
    }
    
    
    public void MockData() {
		User user =  new User();
        user.setName("Santiago");
        user.setUserName("srd98");
        user.setPassword("123456789");
        
        User user2 =  new User();
        user2.setName("Javier");
        user2.setUserName("javargas1098");
        user2.setPassword("123456789");
        
        User user3 =  new User();
        user3.setName("John");
        user3.setUserName("crkjohn");
        user3.setPassword("123456789");
        
        User user4 =  new User();
        user4.setName("Sebastian");
        user4.setUserName("costeño");
        user4.setPassword("123456789");
        
        User user5 =  new User();
        user5.setName("Yohanna");
        user5.setUserName("yowis");
        user5.setPassword("123456789");
        
        User user6 =  new User();
        user6.setName("Diego");
        user6.setUserName("Gordo");
        user6.setPassword("123456789");
        
        User user7 =  new User();
        user7.setName("David");
        user7.setUserName("Parker");
        user7.setPassword("123456789");
        
        User user8 =  new User();
        user8.setName("Italo");
        user8.setUserName("italic");
        user8.setPassword("123456789");
        
        User user9 =  new User();
        user9.setName("Ana");
        user9.setUserName("ani1299");
        user9.setPassword("123456789");
        
        User user10 =  new User();
        user10.setName("Camilo");
        user10.setUserName("caminona");
        user10.setPassword("123456789");
        
        Task task =  new Task();
        task.setDueDate(new Date(2019,02,21));
        task.setDescription("pruebita");
        task.setResponsible(user);
        task.setTitle("lab4");
        
        Task task2 =  new Task();
        task2.setDueDate(new Date(2019,03,21));
        task2.setDescription("pruebita");
        task2.setResponsible(user2);
        task2.setTitle("lab4");
        
        Task task3 =  new Task();
        task3.setDueDate(new Date(2018,02,21));
        task3.setDescription("pruebita");
        task3.setResponsible(user2);
        task3.setTitle("lab4");
        
        Task task4 =  new Task();
        task4.setDueDate(new Date(2020,02,21));
        task4.setDescription("pruebita");
        task4.setResponsible(user3);
        task4.setTitle("lab4");
        
        Task task5 =  new Task();
        task5.setDueDate(new Date(2021,02,21));
        task5.setDescription("pruebita");
        task5.setResponsible(user3);
        task5.setTitle("lab4");
        
        Task task6 =  new Task();
        task6.setDueDate(new Date(2017,02,21));
        task6.setDescription("pruebita");
        task6.setResponsible(user4);
        task6.setTitle("lab4");
        
        Task task7 =  new Task();
        task7.setDueDate(new Date(2019,11,21));
        task7.setDescription("pruebita");
        task7.setResponsible(user4);
        task7.setTitle("lab4");
        
        Task task8 =  new Task();
        task8.setDueDate(new Date(2019,12,21));
        task8.setDescription("pruebita");
        task8.setResponsible(user5);
        task8.setTitle("lab4");
        
        Task task9 =  new Task();
        task9.setDueDate(new Date(2019,12,16));
        task9.setDescription("pruebita");
        task9.setResponsible(user5);
        task9.setTitle("lab4");
        
        Task task10 =  new Task();
        task10.setDueDate(new Date(2019,02,22));
        task10.setDescription("pruebita");
        task10.setResponsible(user6);
        task10.setTitle("lab4");
        
       /*userService.createUser(user);
        userService.createUser(user2);
        userService.createUser(user3);
        userService.createUser(user4);
        userService.createUser(user5);
        userService.createUser(user6);
        userService.createUser(user7);
        userService.createUser(user8);
        userService.createUser(user9);
        userService.createUser(user10);*/
        
        taskService.addTask(task);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        taskService.addTask(task5);
        taskService.addTask(task6);
        taskService.addTask(task7);
        taskService.addTask(task8);
        taskService.addTask(task9);
        taskService.addTask(task10);
        
        
        
	}
    
}