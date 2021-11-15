package com.tjcloud.tenant.api.enums;

public enum VipOpenStatusEnums {

    NOT_OPEN ("未开通", 0),
    OPENED("已开通", 1),
    OUT_OF_DATE("已过期", 2);

    private final String text;
    private final int status;

    private VipOpenStatusEnums(String text, int status)
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
        for (VipOpenStatusEnums e : VipOpenStatusEnums.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
