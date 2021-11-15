package com.tjcloud.pubsport.enums;

public enum OpinionaireType {
	DC_ENQUIRER("DC_ENQUIRER",  "单位调查表", 0),
	DC_POSTADIUM("DC_POSTADIUM",  "场地调查表", 1);
	
	private String code;
	private String text;
	private Integer level;

	private OpinionaireType(String code, String text, Integer level) {
		this.code = code;
		this.text = text;
		this.level = level;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public Integer getLevel() {
		return this.level;
	}
	public static String getText(String code) {
		OpinionaireType[] array = values();
		for (OpinionaireType en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static Integer getLevel(String code) {
		OpinionaireType[] array = values();
		for (OpinionaireType en : array) {
			if (en.getCode().equals(code)) {
				return en.getLevel();
			}
		}
		return 0;
	}

	public static OpinionaireType get(String code) {
		OpinionaireType[] array = values();
		for (OpinionaireType en : array) {
			if (en.getCode().equals(code)) {
				return en;
			}
		}
		return null;
	}
}
