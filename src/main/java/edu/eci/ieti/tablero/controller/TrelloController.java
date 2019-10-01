package edu.eci.ieti.tablero.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.tablero.model.Team;

@RestController
public class TrelloController {

    public static List<Team> trello = new ArrayList<Team>();

    @RequestMapping(value="/teams", method=RequestMethod.GET)
    public List<Team> getTeams() {
        return trello;
    }

    @RequestMapping(value="/teams", method=RequestMethod.POST)
    public List<Team> addTeam(Team team) {
        return trello;
    }


}