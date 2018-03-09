package com.dungeonmaster.router;

import java.util.HashMap;
import java.util.Map;

import com.amazon.speech.json.SpeechletRequestEnvelope;
import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.dungeonmaster.api.IntentName;
import com.dungeonmaster.api.IntentRoute;
import com.dungeonmaster.intents.*;


public class IntentRouter {
	
	private Map<String, IntentRoute> routeTableMap = new HashMap<String, IntentRoute>(); 
	
	public IntentRouter() {
		buildRouteTable();
	}
	
	private void buildRouteTable() {
		routeTableMap.put(IntentName.TEST, new TestIntent());
		routeTableMap.put(IntentName.FAIL,  new FailIntent());
	}
	
	public SpeechletResponse route(SpeechletRequestEnvelope<IntentRequest> requestEnvelope) {
		
		IntentRequest request = requestEnvelope.getRequest();	
		
        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : IntentName.FAIL;
        SpeechletResponse r = (routeTableMap.get(intentName) != null) ?
        		routeTableMap.get(intentName).buildResponse(requestEnvelope) : 
        			routeTableMap.get(IntentName.FAIL).buildResponse(requestEnvelope);
        return r;		
	}
}