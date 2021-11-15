package com.tjcloud.tenant.api.enums;

public enum FlowTypeEnums {
	// 经办进度(1-申请中，2-办理中，3-已领取)
	APPLYING("申请中",1),
	IN_HAND("办理中",2),
	ALREADY_RECEIVED("已领取",3),
	APPLY_REJECT("已驳回", 4);
	
	private final String text;
	private final int status;
	
	private FlowTypeEnums(String text, int status) {
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
		for (FlowTypeEnums e : FlowTypeEnums.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
