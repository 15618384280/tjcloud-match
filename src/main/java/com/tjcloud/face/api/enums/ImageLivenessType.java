package com.tjcloud.face.api.enums;

public enum ImageLivenessType {
	FACELIVENESS_NO0 (0, "faceliveness,faceliveness", "两张图片都做活体检测"),
	FACELIVENESS_NO1 (1, "faceliveness,","第一张图片做活体检测"),
	FACELIVENESS_NO2 (2, ",faceliveness", "第二张图做活体检测");
	
	private final int status;
	private final String value;
	private final String text;

	private ImageLivenessType(int status, String value, String text)
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
		for (ImageLivenessType e : ImageLivenessType.values())
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
		for (ImageLivenessType e : ImageLivenessType.values())
		{
			if (e.getStatus() == status)
			{
				return e.getValue();
			}
		}
		return "";
	}
}
