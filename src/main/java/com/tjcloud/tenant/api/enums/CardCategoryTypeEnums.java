package com.tjcloud.tenant.api.enums;

/**
 * 
 * @author TJ_zhoupf
 *
 */
public enum CardCategoryTypeEnums
{
	RECHARGE_CARD("充值卡",1),
	TIMES_CARD("次卡",2),
	RECHARGE_YUDOU_CARD("充值运动豆卡",3),
	RECHARGE_HOURS("时间卡",4);
	
	private final String text;
	private final int status;
	
	private CardCategoryTypeEnums(String text, int status)
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
		for (CardCategoryTypeEnums e : CardCategoryTypeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
