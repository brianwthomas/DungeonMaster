package com.dungeonmaster.api;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;

public interface IntentRoute {	
	public SpeechletResponse buildResponse(SpeechletRequestEnvelope<IntentRequest> request);
}