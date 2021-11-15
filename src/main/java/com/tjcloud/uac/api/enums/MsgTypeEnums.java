package com.tjcloud.uac.api.enums;

/**
 * Created by gaojian on 2016/5/25.
 */
public enum MsgTypeEnums {

    ORDER_MSG("ORDER_MSG", 1), //订单推
    ALL_MSG("ALL_MSG", 2), //全局推
    ACCURATE_MSG("ACCURATE_MSG", 3); //精准推


    private final String text;
    private final int status;

    private MsgTypeEnums(String text, int status) {
        this.text = text;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public static String getText(int status) {
        for (MsgTypeEnums e : MsgTypeEnums.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}
