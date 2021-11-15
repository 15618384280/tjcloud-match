package com.tjcloud.match.api.enums;

/**
 * 支付状态（0-未支付,1-已支付,2-已取消,3-退款中,4-已退款,5-线下导入,6-线下支付）
 * @author TJ_zhoupf
 *
 */
public enum PaymentStatus {

    PAYABLE ("未支付", 0),
    PAID("已支付", 1),
    CLOSE("已取消", 2),
    REFUNDING("退款中", 3),
    REFUND("已退款", 4),
    IMPORT("线下导入", 5),
    PAYMENT_LINE("线下支付", 6),;

    private final String text;
    private final int status;

    private PaymentStatus(String text, int status)
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
        for (PaymentStatus e : PaymentStatus.values())
        {
            if (e.getStatus() == status)
            {
                return e.getText();
            }
        }
        return "";
    }
}
