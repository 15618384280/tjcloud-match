package com.tjcloud.tenant.api.enums;

public enum MemberCardCategoryAttrTypeEnums
{
	// 0-属于租户（所有场馆可办），1-属于场馆（所属场馆可办），2-属于项目（所属项目可办）
	TENANT("TENANT",0),
	STADIUM("stadium",1),
	STADIUMITEM("stadiumItem",2);
	
	private final String text;
	private final int status;
	
	private MemberCardCategoryAttrTypeEnums(String text, int status)
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
		for (MemberCardCategoryAttrTypeEnums e : MemberCardCategoryAttrTypeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
