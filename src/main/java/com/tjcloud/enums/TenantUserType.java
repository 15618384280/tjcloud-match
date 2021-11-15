package com.tjcloud.enums;

/**
 * Created by gaojian on 2016/7/6.
 */
public enum TenantUserType {
    // 如果是PLATFORM没有数据过滤,如果是TENANT_ADMIN对此租户下没有数据过滤

    TENANT_USER("TENANT_USER",1),
    PLATFORM_USER("PLATFORM_USER", 2);

    private final String text;
    private final int status;

    private TenantUserType(String text, int status)
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
        for (TenantUserType e : TenantUserType.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
