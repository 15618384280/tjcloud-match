package com.tjcloud.uac.api.enums;

public enum MessageTypeEnums {

    ORDER_SUCCESS_MSG("订场成功通知",0), 
    ORDER_REFUND_MSG("订单退订通知", 1),
    ALARM("ALARM", 4), //越界报警
    REPAIR("REPAIR", 5), //报修/维修
    MATERIAL_APPLY("MATERIAL_APPLY", 6), //物料申请
    EXCEPTION("EXCEPTION", 7), //异常情况
    PUSH_MSG("消息推送", 9); //精准推


    private final String text;
    private final int status;

    private MessageTypeEnums(String text, int status) {
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
        for (MessageTypeEnums e : MessageTypeEnums.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}
