package com.tjcloud.tenant.api.enums;

public enum VoucherErrorStatusEnums {
	//优惠券状态 0-可用 1-限额不足 2-活动未开始 3-限制订单时间 4-限制运动类型 5-限制渠道（暂无）
	USE("可用",0),
	LIMIT_PRICE("限额",1),
	UNTIME("活动未开始",2),
	LIMIT_TIME("限时", 3),
	LIMIT_TYPE("限运动类型", 4),
	LIMIT_CHANEL("限渠道", 5);
	
	private final String text;
	private final int status;
	
	private VoucherErrorStatusEnums(String text, int status) {
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
		for (VoucherErrorStatusEnums e : VoucherErrorStatusEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
