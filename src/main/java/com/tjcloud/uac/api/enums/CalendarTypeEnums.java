package com.tjcloud.uac.api.enums;

/**
 * Created by gaojian on 2016/5/25.
 */
public enum CalendarTypeEnums {

    CURRENCY_CALENDAR("CURRENCY_CALENDAR",1),
    TENANT_CALENDAR("TENANT_CALENDAR", 2);

    private final String text;
    private final int status;

    private CalendarTypeEnums(String text, int status)
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
        for (CalendarTypeEnums e : CalendarTypeEnums.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
