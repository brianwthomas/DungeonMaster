package com.dungeonmaster.model;

import lombok.Setter;
import lombok.Getter;

public class Room implements AskHelper {
	@Getter @Setter private String id;
	@Getter @Setter private String type;
	@Getter @Setter private String description;
	@Getter @Setter private String s3Url;
	
	
}