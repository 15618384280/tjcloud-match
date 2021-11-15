package com.tjcloud.order.enums;

public enum DoorType {
	IN("01", "进门"),
	OUT("02", "出门");
	
	private String code;
	private String text;
	
	private DoorType(String code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public static String getText(String code) {
		DoorType[] array = values();
		for (DoorType en : array) {
			if (en.getCode().equals(code)) {
				return en.getText();
			}
		}
		return "";
	}

	public String getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
}
