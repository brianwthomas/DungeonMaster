package com.dungeonmaster.model;

import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.OutputSpeech;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

import lombok.Getter;

public abstract class AbstractAlexaBase {	
	@Getter protected Reprompt mReprompt = new Reprompt();
	@Getter protected PlainTextOutputSpeech mOutputSpeech = new PlainTextOutputSpeech();
	@Getter protected SimpleCard mCard = new SimpleCard();
	
	/**
	 * Helper method to build the Reprompt object when given OutputSpeech
	 * @param outputSpeech
	 */
	public void setRepromptData(OutputSpeech outputSpeech) {
		this.mReprompt.setOutputSpeech(outputSpeech);
	} // end setRepromptData
	
	/**
	 * Helper method to build the OutputSpeech object when given a string
	 * @param speech the text that is used to for the speech
	 */
	public void setOutputSpeechText(String speech) {
		this.mOutputSpeech.setText(speech);		
	} // end setOutputSpeechText
	
	/**
	 * Helper method to build the Card Data to be returned
	 * @param title the title of the card being returned
	 * @param content the data of the card being returned
	 */
	public void setSimpleCardData(String title, String content) {
		this.mCard.setTitle(title);
		this.mCard.setContent(content);
	} // end setSimpleCardData
	
	/**
	 * Helper method for creating the AskResponse for the object in question
	 * @return the resulting card and speech text.
	 */
	public SpeechletResponse createAskResponse() {
		return SpeechletResponse.newAskResponse(mOutputSpeech, mReprompt, mCard);
	} // end createAskResponse
	
} // end AbstractAlexaBase