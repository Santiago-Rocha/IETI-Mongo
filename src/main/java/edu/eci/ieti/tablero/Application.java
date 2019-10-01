package edu.eci.ieti.tablero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.eci.ieti.tablero.controller.TrelloController;
import edu.eci.ieti.tablero.model.Team;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        loadValues();
        SpringApplication.run(Application.class, args);
    }

    public static void loadValues(){
        Team team =  new Team();
        TrelloController.trello.add(team);
    }
}