package com.dungeonmaster.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="mud-user")
public class DungeonUser {
	
	@DynamoDBHashKey(attributeName="id")
	private String id;	
		
	private String name;	
	private Integer level;
	
		
}