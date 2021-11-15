package com.tjcloud.tenant.api.enums;

public enum BankAccountTypeEnums
{
	// 账户类型
	// 1-银行卡 2-支付宝 3-微信
	CARD("银行卡",1),
	ALIPAY("支付宝",2),
	WXPAY("微信",3);
	
	private final String text;
	private final int status;
	
	private BankAccountTypeEnums(String text, int status)
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
		for (BankAccountTypeEnums e : BankAccountTypeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
