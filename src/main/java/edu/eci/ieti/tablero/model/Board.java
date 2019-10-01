package edu.eci.ieti.tablero.model;

import java.util.List;

public class Board {
    private String title;
    private String description;
    List<Task> cards;
    List<User> users;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getListCard(){
        return cards;
    }

    public List<User> getUser(){
        return users;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCards(List<Task> cards){
        this.cards = cards;
    }

    public void setUsers(List<User> users){
        this.users = users;
    }
}


