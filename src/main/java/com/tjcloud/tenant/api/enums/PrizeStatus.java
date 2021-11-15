package com.tjcloud.tenant.api.enums;

public enum PrizeStatus {
	// 0-待领取 1-已领取 2-已过期
	PENDING("待领取", 0),
	RECEIVED("已领取", 1),
	EXPIRED("已过期", 2);
	
	private final String text;
	private final int status;
	
	private PrizeStatus(String text, int status) {
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
		for (PrizeStatus e : PrizeStatus.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
