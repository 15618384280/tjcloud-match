package com.tjcloud.dd.api.enums;

public enum WarningTypeEnum {
	LOCK(1, "锁定场地"),
	BATCH_LOCK(2, "批量锁场"),
	LONG_ORDER(3, "长订预定"),
	CARD_RECHARGE(4, "会员卡充值"),
	CARD_UNBUNDLING(5, "会员卡解绑"),
	SYSTEM_LOGIN(6, "用户登录"),
	SYSTEM_LOGOUT(7, "用户登出"),
	SYSTEM_LOGIN_FAIL(8,"登录失败");

	private int code;
	private String text;

	WarningTypeEnum(int code, String text) {
		this.code = code;
		this.text = text;
	}

	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
	public static String getText(int status) {
		for (WarningTypeEnum e : WarningTypeEnum.values()) {
			if (e.getCode() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
