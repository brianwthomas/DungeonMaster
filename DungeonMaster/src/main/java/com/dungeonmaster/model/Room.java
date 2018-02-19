package com.dungeonmaster.model;

import lombok.Getter;

public class Room extends AbstractAlexaBase {
	private String id;
	@Getter private String description;

	
	public Room(String description) {
		this.description = description;
	}
	
	public void setDescription(String description) {
		this.description = description;

		// set Return speech
		
	}
}