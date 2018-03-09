package com.dungeonmaster.intents;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;
import com.dungeonmaster.api.IntentRoute;
import com.dungeonmaster.speech.Alexa;

public class TestIntent implements IntentRoute{

	@Override
	public SpeechletResponse buildResponse(SpeechletRequestEnvelope<IntentRequest> request) {
		Reprompt r = new Reprompt();
		r.setOutputSpeech(Alexa.stringToSsmlOutputSpeech(""));
		SimpleCard card = new SimpleCard();
		card.setTitle("Test card");
		card.setContent("Test content");
		
		return SpeechletResponse.newAskResponse(Alexa.stringToSsmlOutputSpeech("Hello world"), r, card);
	}

}
