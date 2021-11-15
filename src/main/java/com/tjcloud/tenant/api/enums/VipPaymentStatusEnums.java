package com.tjcloud.tenant.api.enums;

/**
 * 支付状态（0-未支付,1-已支付,2-已取消,3-退款中,4-已退款）
 * @author TJ_zhoupf
 *
 */
public enum VipPaymentStatusEnums {

    PAYABLE ("未支付", 0),
    PAID("已支付", 1),
    REFUND("已退款", 2);

    private final String text;
    private final int status;

    private VipPaymentStatusEnums(String text, int status)
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
