package com.dungeonmaster.api;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.dungeonmaster.config.Config;
import com.dungeonmaster.model.DungeonUser;
import com.dungeonmaster.speech.Alexa;

public class Launch {
	private DynamoDBMapper dbMapper = Config.getInstance().getDynamoMapper();	
	private Boolean isNewUser = false;
	private String alexaUserId;
	
	public Launch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {	
		alexaUserId = getAlexaUserId(requestEnvelope);

		// checks for userId in DynamoDB
		DungeonUser user = dbMapper.load(DungeonUser.class, alexaUserId);
		// checks if user exists
		if (user == null) {
			isNewUser = true;
		}
		System.out.println(user);
	}
	
	private String getAlexaUserId(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		
		return requestEnvelope.getSession().getUser().getUserId();
	}
	
	public SpeechletResponse buildResponse() {
		Reprompt r = new Reprompt();
		r.setOutputSpeech(Alexa.stringToSsmlOutputSpeech(""));			
		SimpleCard card = new SimpleCard();
		card.setTitle("Welcome to Dungeon Crawler");
		card.setContent("Get Name");
		return SpeechletResponse.newAskResponse(Alexa.stringToSsmlOutputSpeech("Welcome to Dungeon Master"), r, card);
	}
}
