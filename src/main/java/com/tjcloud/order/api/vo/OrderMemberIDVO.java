package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/10/31.
 */
public class OrderMemberIDVO implements Serializable{
    private static final long serialVersionUID = 5904230251610178240L;
    private String orderId;
    private String memberCardId;
    private String cardNo;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberCardId() {
        return memberCardId;
    }

    public void setMemberCardId(String memberCardId) {
        this.memberCardId = memberCardId;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
