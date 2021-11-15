package com.tjcloud.tenant.api.enums;

public enum AuthStatusEnums {
	//指导员认证状态(0.未认证,1.指导员,2.非指导员)
	NOTCERTIFIED("未认证",0),
	INSTRUCTOR("指导员",1),
	NOTINSTRUCTOR("非指导员",2);
	private final String text;
	private final int status;

	private AuthStatusEnums(String text, int status) {
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
		for (AuthStatusEnums e : AuthStatusEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
