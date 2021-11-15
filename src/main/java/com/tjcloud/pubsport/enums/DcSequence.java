package com.tjcloud.pubsport.enums;

public enum DcSequence {
	DC_ENQUIRER_SEQ("dc_enquirer_seq", "单位编码"),
	DC_STADIUM_SEQ("dc_stadium_seq", "场地编码"),
	DC_ENQNUMBER_SEQ("dc_enqnumber_seq", "场地单位编码");
	
	private String key;
	private String text;

	private DcSequence(String key, String text) {
		this.key = key;
		this.text = text;
	}

	public String getKey() {
		return this.key;
	}
	public String getText() {
		return this.text;
	}
	public static String getText(String key) {
		DcSequence[] array = values();
		for (DcSequence en : array) {
			if (en.getKey().equals(key)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static DcSequence get(String key) {
		DcSequence[] array = values();
		for (DcSequence en : array) {
			if (en.getKey().equals(key)) {
				return en;
			}
		}
		return null;
	}
}
