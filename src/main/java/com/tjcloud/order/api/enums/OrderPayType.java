package com.tjcloud.order.api.enums;

//付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡
public enum OrderPayType {
	OTHERS("其他",0),
	CASH("现金",1),
	BANKCARD("银行卡",2),
	TENPAY("微信支付", 3),
	ALIPAY("支付宝", 4),
	CHECK("支票",5),
	GROUP("团购劵",6),
	VOUCHERS("代金劵",7),
	MEMBERCARD("会员卡",8),
	DAYBYDAY("按天支付",9),
	UNIONPAY("银联支付", 10);

	private final String text;
	private final int status;

	private OrderPayType(String text, int status)
	{
		this.text = text;
		this.status = status;
	}

	public String getText()
	{
		return text;
	}

	public int getStatus()
	{
		return status;
	}

	public static String getText(int status)
	{
		for (OrderPayType e : OrderPayType.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
