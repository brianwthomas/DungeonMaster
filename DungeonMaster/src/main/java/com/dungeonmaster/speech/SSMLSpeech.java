package com.dungeonmaster.speech;

public class SSMLSpeech {
		
	public static String createAmazonEffect(AmazonEffectName name, String speech) {
		return String.format("<amazon:effect name=\"%s\">%s</amazon:effect>", name.toString(), speech);
	}
	
	public static String createAudio(String url) {
		return String.format("<audio src=\"%s\"/>", url);
	}
}