package com.dungeonmaster.speech;

public enum AmazonEffectName {
	WHISPERED("whispered"),	
	;
	
	private String value;
	
	AmazonEffectName(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
