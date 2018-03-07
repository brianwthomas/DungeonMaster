package com.dungeonmaster.speech;

import com.amazon.speech.ui.SsmlOutputSpeech;

public class Alexa {
	public static SsmlOutputSpeech stringToSsmlOutputSpeech(String speechText) {
		SsmlOutputSpeech outputSpeech = new SsmlOutputSpeech();
		outputSpeech.setSsml("<speak>" + speechText + "</speak>");
		return outputSpeech;
	}
}