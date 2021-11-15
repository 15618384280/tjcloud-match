package com.tjcloud.pubsport.enums;

//审批状态（0-暂存,1-审核中，2-已驳回，3-总局审核中, 4-审核通过）
public enum AuditState {
	UTRSTATN("草稿", 0),
	WAIT_CONFIRM("审核中", 1),
	TURN_DOWN("已驳回", 2),
	ONE_PASS_AUDIT("市级审核中", 3),
	TOW_PASS_AUDIT("审核通过", 4);
	
	private String text;
	private Integer code;

	private AuditState(String text, Integer code) {
		this.code = code;
		this.text = text;
	}

	public Integer getCode() {
		return this.code;
	}
	public String getText() {
		return this.text;
	}
	public static String getText(Integer code) {
		AuditState[] array = values();
		for (AuditState en : array) {
			if (en.getCode() == code) {
				return en.getText();
			}
		}
		return "";
	}
	
	public static AuditState get(Integer code) {
		AuditState[] array = values();
		for (AuditState en : array) {
			if (en.getCode() == code) {
				return en;
			}
		}
		return null;
	}
}
