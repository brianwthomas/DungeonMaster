package com.dungeonmaster.main;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;

import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.dungeonmaster.api.Launch;
import com.dungeonmaster.model.DungeonUser;
import com.dungeonmaster.router.IntentResolver;
import com.dungeonmaster.speech.Alexa;
import com.dungeonmaster.speech.AmazonEffectName;
import com.dungeonmaster.speech.SSMLSpeech;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;


public class DungeonMasterSpeechlet implements SpeechletV2 {
	IntentResolver router = new IntentResolver();
	
	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
        
        return router.route(requestEnvelope);
        
		/*
		if ("test".equals(intentName))
		{
			Reprompt r = new Reprompt();
			r.setOutputSpeech(Alexa.stringToSsmlOutputSpeech(""));
			SimpleCard card = new SimpleCard();
			card.setTitle("Test card");
			card.setContent("Test content");
			
			return SpeechletResponse.newAskResponse(Alexa.stringToSsmlOutputSpeech("Hello world"), r, card);
		}
		else if ("getNameIntent".equals(intentName))
		{
			AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
					.withRegion(Regions.US_WEST_2)
					.build();
			System.out.println(requestEnvelope.getSession().getUser().getUserId());
			DynamoDBMapper mapper = new DynamoDBMapper(client);
			DungeonUser user = mapper.load(DungeonUser.class, requestEnvelope.getSession().getUser().getUserId());
			Reprompt r = new Reprompt();
			r.setOutputSpeech(Alexa.stringToSsmlOutputSpeech(""));
			SimpleCard card = new SimpleCard();
			card.setTitle("Get Name Card");
			card.setContent("Get Name");
			
			System.out.println(user.getId());
			System.out.println(user.getName());
			return SpeechletResponse.newAskResponse(Alexa.stringToSsmlOutputSpeech(String.format("Your user name is %s", user.getName())), r, card);
		}
		else
		{
			Reprompt r = new Reprompt();
			r.setOutputSpeech(Alexa.stringToSsmlOutputSpeech(""));			
			SimpleCard card = new SimpleCard();
			card.setTitle("Get Name Card");
			card.setContent("Get Name");
			return SpeechletResponse.newAskResponse(Alexa.stringToSsmlOutputSpeech("Shit Broke"), r, card);
		}
		*/
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		Launch l = new Launch(requestEnvelope);
		return l.buildResponse();
		
		
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
				.withRegion(Regions.US_WEST_2)
				.build(); 
		DynamoDB dynamoDB = new DynamoDB(client);
		Table table = dynamoDB.getTable("mud-user");
		Item item = new Item()
				.withPrimaryKey("id", "test")
				.withString("user", requestEnvelope.getSession().getUser().getUserId());
		PutItemOutcome outcome = table.putItem(item);
		System.out.println("END SESSION");
		
	}

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {		
		
	}

}
