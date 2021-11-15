package com.tjcloud.order.api.enums;

public enum OrderEntranceStatus {
	
	UNCONFIRMED("未确认", 0),
	CONFIRMED("已入场", 1);
	
	private final String text;
	private final int status;

	private OrderEntranceStatus(String text, int status)
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
		for (OrderEntranceStatus e : OrderEntranceStatus.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
