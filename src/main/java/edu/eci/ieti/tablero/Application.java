package edu.eci.ieti.tablero;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import edu.eci.ieti.tablero.config.AppConfiguration;
import edu.eci.ieti.tablero.config.JwtFilter;
import edu.eci.ieti.tablero.model.Task;
import edu.eci.ieti.tablero.model.User;
import edu.eci.ieti.tablero.services.ITaskService;
import edu.eci.ieti.tablero.services.IUserService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import java.net.URL;





@SpringBootApplication
public class Application implements CommandLineRunner  {
	
	@Autowired
	IUserService userService;
	
	@Autowired 
	ITaskService taskService;

	@Autowired
	GridFsTemplate gridFsTemplate;
	
    @Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/api/*" );

		return registrationBean;
	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		/*
		// Laboratorio Mongo
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
        
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lte(new Date(2019,10,25)));
        List<Task> tasksExpired = mongoOperation.find(query, Task.class);
        
        query = new Query(); 
        query.addCriteria(Criteria.where("responsible").exists(true).and("priority").gte(5) );
        List<Task> tasksAssigned = mongoOperation.find(query, Task.class);
        
        for(Task t: tasksExpired) {
        	System.out.println(t.getDescription());
        	System.out.println(t.getResponsible().getName());
        }

        System.out.println(tasksAssigned.size());


		//Laboratorio Archivo
		GridFSFile file = gridFsTemplate.findOne(new Query().addCriteria(Criteria.where("filename").is("testing.png")));
		URL url = new URL("https://i.dailymail.co.uk/i/pix/tm/2007/07/lionking1807_468x325._to_468x312jpeg");
		gridFsTemplate.store(url.openStream(), "lion.jpeg",  "image/jpeg");*/
		
	}


}