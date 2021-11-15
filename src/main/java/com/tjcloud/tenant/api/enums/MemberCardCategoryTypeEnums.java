package com.tjcloud.tenant.api.enums;

public enum MemberCardCategoryTypeEnums {
	// 1-充值卡  2-次卡 3-主从卡 4-时间卡
	RECHARGE("充值卡",1),
	TIMES("次卡",2),
	MASTERSLAVE("主从卡",3),
	HOURS("时间卡",4);
	
	private final String text;
	private final int status;
	
	private MemberCardCategoryTypeEnums(String text, int status) {
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
		for (MemberCardCategoryTypeEnums e : MemberCardCategoryTypeEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
