package com.tjcloud.tenant.api.enums;

public enum MemberCardUsingScopeEnums
{
	// 1-租户卡 2- 平台卡
	TENANT("TENANT",1),
	PLATFORM("PLATFORM",2);
	
	private final String text;
	private final int status;
	
	private MemberCardUsingScopeEnums(String text, int status)
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
		for (MemberCardUsingScopeEnums e : MemberCardUsingScopeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
