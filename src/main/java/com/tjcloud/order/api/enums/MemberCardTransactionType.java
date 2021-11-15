package com.tjcloud.order.api.enums;

/**
 * 交易类型: 1-充值、2-消费、3-工本费、4-补卡手续费、5-封卡手续费、6-续卡费、7-、
 * 
 * @author TJ_zhoupf
 *
 */
public enum MemberCardTransactionType {

	RECHARGE("充值", 1), 
	CONSUMER("消费", 2),
	BOOKFEE("办卡费", 3),						//工本费
	REPAIR("补卡费", 4),					    //补卡手续费
	ENVELOP("封卡手续费", 5),					//封卡手续费
	CONTINUATION("续卡费", 6),				//续卡费
	HOURS_BOOKFEE("时间卡收款费", 7),			//时间卡收款费
	QUIT("退卡", 8),
	TIMES_BOOKFEE("次卡收款费", 9);			//次卡收款费

	private final String text;
	private final int status;

	private MemberCardTransactionType(String text, int status) {
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
		for (MemberCardTransactionType e : MemberCardTransactionType.values()) {
			if (e.getStatus() == status) {
				return e.getText();
			}
		}
		return "";
	}
}
