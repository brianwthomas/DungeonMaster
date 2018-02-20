package com.dungeonmaster.model;

import lombok.Data;

@Data
public class Room extends AbstractAlexaBase {
	private String mId;
	private String mDescription;
	private String mType;
	private String mRepromptType;
	
	public Room(String description, String type) {
		mDescription = description;
		mType = type;		
		
		super.mCard.setTitle(mType);
		super.mCard.setContent(description);
		super.mReprompt.setOutputSpeech(super.getOutputSpeech());
		super.mOutputSpeech.setText(description);
	}
			
}