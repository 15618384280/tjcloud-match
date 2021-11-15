package com.tjcloud.order.api.enums;

/**
 * 支付方式：1-运动豆、2-场馆卡、3-次卡、4-支付宝、5-微信支付、6-红包支付、7-线下支付、8-租户会员卡、9-第三方支付
 *
 * @author TJ_zhoupf
 */
public enum PaymentType {

    YUDOU("运动豆", 1),
    CARDS("场馆充值卡", 2),
    TIMCARDS("场馆次卡", 3),
    ALIPAY("支付宝", 4),
    TENPAY("微信支付", 5),
    COUPON("红包支付", 6),
    CASH("线下支付", 7),
    MEMBER_CARD("租户会员卡", 8),
    RECHARGEABLECARD("平台充值卡", 10),
    THIRD_PARTY("第三方支付", 9),
    XM_JH("建行龙支付", 12),
    SHGYPS("shgyps", 13),
    YD_EXCHANGE("yd_exchange", 14),
    UNIONPAY("银联支付", 15),
    ;

    private final String text;
    private final int status;

    private PaymentType(String text, int status) {
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
        for (PaymentType e : PaymentType.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }

    public static PaymentType getPaymentType(int status) {
        for (PaymentType e : PaymentType.values()) {
            if (e.getStatus() == status) {
                return e;
            }
        }
        return null;
    }
}
