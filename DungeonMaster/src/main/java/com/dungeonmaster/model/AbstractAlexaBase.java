package com.dungeonmaster.model;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

import lombok.Data;

@Data
public abstract class AbstractAlexaBase {	
	protected Reprompt mReprompt = new Reprompt();
	protected PlainTextOutputSpeech mOutputSpeech = new PlainTextOutputSpeech();
	protected SimpleCard mCard = new SimpleCard();
	
	
} // end AbstractAlexaBase
