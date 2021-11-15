package com.tjcloud.tenant.api.enums;

public enum VipSourceEnums {

    WEB("WEB", 1),
    IOS("IOS", 2),
    ANDROID("Android", 3),
    WEIXIN_APP("微信小程序", 4);

    private final String text;
    private final int status;

    private VipSourceEnums(String text, int status)
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
        for (VipPaymentStatusEnums e : VipPaymentStatusEnums.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
