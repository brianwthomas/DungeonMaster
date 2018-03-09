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


public class IntentResolver {
	
	private Map<String, IntentRoute> routeTableMap = new HashMap<String, IntentRoute>(); 
	
	public IntentResolver() {
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
		if (routeTableMap.containsKey(intentName))
			return routeTableMap.get(intentName).buildResponse(requestEnvelope);
		else
			return routeTableMap.get(IntentName.FAIL).buildResponse(requestEnvelope); 				
	}
}