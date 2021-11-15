package com.tjcloud.pubsport.enums;

//行业类别
public enum IndustryCategory {
	SPORTS("体育", "1"),
	EDUCATION("教育", "2"),
	OTHER("其他", "3");
	
	private String text;
	private String code;

	private IndustryCategory(String text, String code) {
		this.text = text;
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	
	public static String getText(String code) {
		IndustryCategory[] array = values();
		for (IndustryCategory en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static String getCode(String text) {
		IndustryCategory[] array = values();
		for (IndustryCategory en : array) {
			if (en.getText().equals(text)) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static IndustryCategory get(String code) {
		IndustryCategory[] array = values();
		for (IndustryCategory en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
