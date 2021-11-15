package com.tjcloud.tenant.api.enums;

public enum VoucherStateEnums {
	//优惠券状态 (1-未用,2-已用,3-过期,4-收回)
	UNUSE("未使用",1),
	USED("已使用",2),
	OVERTIME("已过期",3),
	BACK("已收回", 4),
	OCCUPY("已占用",5);
	
	private final String text;
	private final int status;
	
	private VoucherStateEnums(String text, int status) {
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
		for (VoucherStateEnums e : VoucherStateEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
