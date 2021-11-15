package com.tjcloud.order.api.enums;

/**
 * 消息类型: 1-打卡入场 2-出场
 */
public enum SportsReportMessageType {
	IN("进场", 1), 
	OUT("出场", 2),
	FIELD("场次", 3);

	private final String text;
	private final int status;

	private SportsReportMessageType(String text, int status) {
		this.text = text;
		this.status = status;
	}

	public String getText() {
		return text;
	}
	
	public int getStatus() {
		return status;
	}

	public static String getText(int status) {
		for (SportsReportMessageType e : SportsReportMessageType.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
