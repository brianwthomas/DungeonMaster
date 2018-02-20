package com.dungeonmaster.main;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.speechlet.SpeechletV2;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.SimpleCard;
import com.dungeonmaster.model.Room;

public class DungeonMasterSpeechlet implements SpeechletV2 {

	@Override
	public SpeechletResponse onIntent(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		IntentRequest request = requestEnvelope.getRequest();
        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;
		if ("MoveUserIntent".equals(intentName))
		{
			Room room = new Room("Move User Intent Invoked", "Card Title");			
			return SpeechletResponse.newAskResponse(room.getOutputSpeech(), room.getReprompt(), room.getCard());
		}
		else
		{
			Room room = new Room("Not valid intent", "Card Title");			
			return SpeechletResponse.newAskResponse(room.getOutputSpeech(), room.getReprompt(), room.getCard());
		}
	}

	@Override
	public SpeechletResponse onLaunch(SpeechletRequestEnvelope<LaunchRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		
		Room room = new Room("Welcome to Dungeon Master........Available commands are, Start, or Quit.", "Card Title");
		
		return SpeechletResponse.newAskResponse(room.getOutputSpeech(), room.getReprompt(), room.getCard());
		
	}

	@Override
	public void onSessionEnded(SpeechletRequestEnvelope<SessionEndedRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSessionStarted(SpeechletRequestEnvelope<SessionStartedRequest> requestEnvelope) {
		// TODO Auto-generated method stub
		
	}

}
