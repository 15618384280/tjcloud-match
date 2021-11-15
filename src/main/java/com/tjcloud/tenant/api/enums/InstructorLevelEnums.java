package com.tjcloud.tenant.api.enums;

public enum InstructorLevelEnums {
	//指导员等级 (0-,1-二级指导员,2-一级指导员,3-国家级指导员)
	LEVEL3("三级指导员",0),
	LEVEL2("二级指导员",1),
	LEVEL1("一级指导员",2),
	NATIONAL("国家级指导员",3);

	private final String text;
	private final int status;

	private InstructorLevelEnums(String text, int status) {
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
		for (InstructorLevelEnums e : InstructorLevelEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
