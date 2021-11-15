package com.tjcloud.face.api.enums;

public enum ImageLivenessControl {
	NONE (0, "NONE", "不进行控制"),
	LOW (1, "LOW,","较低的活体要求(高通过率 低攻击拒绝率)"),
	NORMAL (2, ",NORMAL", "一般的活体要求(平衡的攻击拒绝率, 通过率)"),
	HIGH (3, ",HIGH", "较高的活体要求(高攻击拒绝率 低通过率)");
	
	private final int status;
	private final String value;
	private final String text;

	private ImageLivenessControl(int status, String value, String text)
	{
		this.status = status;
		this.value = value;
		this.text = text;
	}


	public int getStatus()
	{
		return status;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public String getText()
	{
		return text;
	}

	public static String getText(int status)
	{
		for (ImageLivenessControl e : ImageLivenessControl.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
	
	public static String getValue(int status)
	{
		for (ImageLivenessControl e : ImageLivenessControl.values())
		{
			if (e.getStatus() == status)
			{
				return e.getValue();
			}
		}
		return "";
	}
}
