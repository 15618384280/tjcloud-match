package com.tjcloud.order.enums;

public enum MessageType {
	UPLINE(1, "上线"),
	DOWNLINE(2, "下线"),
	UPLINE_LIST(3, "在线名单"),
	INFORMATION(4, "普通消息");
	
	private int code;
	private String text;
	
	private MessageType(int code, String text) {
		this.code = code;
		this.text = text;
	}
	
	public static String getText(Integer code) {
		MessageType[] array = values();
		for (MessageType en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}

	public int getCode() {
		return code;
	}

	public String getText() {
		return text;
	}
}
