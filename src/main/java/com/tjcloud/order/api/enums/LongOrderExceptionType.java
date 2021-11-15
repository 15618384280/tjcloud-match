package com.tjcloud.order.api.enums;

public enum LongOrderExceptionType {
	RELEASE("释放", 0),
	OCCUPY("占用", 1);
	
	private final String text;
	private final int status;

	private LongOrderExceptionType(String text, int status)
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
		for (LongOrderExceptionType e : LongOrderExceptionType.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
