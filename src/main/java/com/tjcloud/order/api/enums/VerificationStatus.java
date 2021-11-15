package com.tjcloud.order.api.enums;

public enum VerificationStatus {
    NO_VERIFICATION("未核销", 0),
    VERIFICATION("已核销", 1),;

    private final String text;
    private final int status;

    private VerificationStatus(String text, int status)
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
        for (OrderStatus e : OrderStatus.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
