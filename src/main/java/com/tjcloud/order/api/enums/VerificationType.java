package com.tjcloud.order.api.enums;

public enum VerificationType {
    OTHER("其他", 0),
    STADIUM_CODE("场馆扫码核销", 1),
    PLATFORM_CUSTOMER("平台客服核销", 2),
    TIMEOUT("到时间系统核销", 3),;

    private final String text;
    private final int status;

    private VerificationType(String text, int status)
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
        for (VerificationType e : VerificationType.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
