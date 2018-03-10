package com.dungeonmaster.config;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import lombok.Getter;

public class Config {
	private static Config instance = null;
	AmazonDynamoDB dynamoClient = AmazonDynamoDBClientBuilder.standard()
			.withRegion(Regions.US_WEST_2)
			.build();
	@Getter DynamoDBMapper dynamoMapper = new DynamoDBMapper(dynamoClient);
	
	protected Config() {
		 
	}
	
	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();			
		}
		return instance;
	}
	
	
}