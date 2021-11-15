package com.tjcloud.tenant.api.enums;

public enum TenantApplyRoleTypeEnums
{
	// 1-menuId 2-operationId
	MENUID("menuId",1),
	OPERATIONID("operationId",2);
	
	private final String text;
	private final int status;
	
	private TenantApplyRoleTypeEnums(String text, int status)
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
		for (TenantApplyRoleTypeEnums e : TenantApplyRoleTypeEnums.values())
		{
			if (e.getStatus() == status)
			{
				return e.getText();
			}
		}
		return "";
	}
}
