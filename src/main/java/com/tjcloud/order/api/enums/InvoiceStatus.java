package com.tjcloud.order.api.enums;

/**
 * 发票状态: 0-不可开票 1-待申请 2-申请中 3-已完成 4-已驳回
 */
public enum InvoiceStatus {
	NONSUPPORT("不可开票", 0),
	APPLY("待申请", 1),
	APPLYING("申请中", 2),
	COMPLETED("已完成", 3),
	REJECT("已驳回", 4);

	private final String text;
	private final int status;

	private InvoiceStatus(String text, int status) {
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
		for (InvoiceStatus e : InvoiceStatus.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
