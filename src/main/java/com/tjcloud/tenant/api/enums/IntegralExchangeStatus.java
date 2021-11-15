package com.tjcloud.tenant.api.enums;

public enum IntegralExchangeStatus {
	PENDING(0,"兑换中"),
	SUCCESS(1, "兑换成功"),
	FAIL(2, "兑换失败");
	
	private final int code;
	private final String text;
	
	private IntegralExchangeStatus(int code, String text){
		this.code = code;
		this.text = text;
	}
	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public static String getText(int code) {
		for (IntegralExchangeStatus e : IntegralExchangeStatus.values()) {
			if (e.getCode() == code) {
				return e.getText();
			}
		}
		return "";
	}
	
}
