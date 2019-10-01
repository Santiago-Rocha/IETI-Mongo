package edu.eci.ieti.tablero.model;

import java.util.List;

public class Team {
    private String name;
    private String shortName;
    private String description;
    private List<Board> boards;
    private List<User> members;
    
	public String getDescription() {
		return description;
    }

	public String getShortName() {
		return shortName;
    }

    public String getName() {
		return name;
    }
    
    public void setDescription(String description) {
		this.description = description;
	}
    
	public void setShortName(String shortName) {
		this.shortName = shortName;
    }
    
	public void setName(String name) {
		this.name = name;
	}
    
}