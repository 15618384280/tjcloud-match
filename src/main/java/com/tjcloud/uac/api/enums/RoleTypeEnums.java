package com.tjcloud.uac.api.enums;

public enum RoleTypeEnums {

	// 如果是PLATFORM没有数据过滤,如果是TENANT_ADMIN对此租户下没有数据过滤
	
	PLATFORM_ADMIN("PLATFORM_ADMIN",0),
	PLATFORM_USER("PLATFORM_USER", 1),
	PLATFORM_SELLER("SELLER", 2),
	TENANT_ADMIN("TENANT_ADMIN",3),
	TENANT_USER("TENANT_USER", 4);
	
	private final String text;
	private final int status;
	
	private RoleTypeEnums(String text, int status)
	{
		this.text = text;
		this.status = status;
	}
	
	public String getText() {
		return text;
	}
	public int getStatus() {
		return status;
	}
	
	public static String getText(int status)
	{
		for (RoleTypeEnums e : RoleTypeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
	
}
