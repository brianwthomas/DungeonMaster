package com.dungeonmaster.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;

@Data
@DynamoDBTable(tableName="mud-user")
public class DungeonUser {
	
	private String mId;	
	private String mName;	
	private Integer mLevel;
	
	@DynamoDBHashKey(attributeName="id")
	public String getId() {
		return mId;
	}
	
	@DynamoDBAttribute(attributeName="name")
	public String getName() {
		return mName;
	}
	@DynamoDBAttribute(attributeName="level")
	public Integer getLevel() {
		return mLevel;
	}
}