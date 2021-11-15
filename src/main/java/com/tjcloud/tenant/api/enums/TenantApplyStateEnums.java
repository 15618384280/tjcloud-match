package com.tjcloud.tenant.api.enums;

public enum TenantApplyStateEnums {
	// 0-申请  1-申请中  2-通过 3-驳回
	APPLY("APPLY",0),
	APPLYING("APPLYING",1),
	PASS("SUCCESS",2),
	REJECT("REJECT",3);
	
	private final String text;
	private final int status;
	
	private TenantApplyStateEnums(String text, int status) {
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
		for (TenantApplyStateEnums e : TenantApplyStateEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
