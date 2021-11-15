package com.tjcloud.tenant.api.enums;

public enum ApprovalStatusEnums {
	//指导员审核状态 (0-审核中,1-审核通过,2-审核未通过)
	UNAUDIT("审核中",0),
	PASS("审核通过",1),
	REJECT("审核未通过",2);

	private final String text;
	private final int status;

	private ApprovalStatusEnums(String text, int status) {
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
		for (ApprovalStatusEnums e : ApprovalStatusEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
