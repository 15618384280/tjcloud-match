package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 积分兑换运动豆(integral_exchange)
 * @author auto niuhao 2020.10.29
 */
public class IntegralExchange extends AbstractEntity {
    private static final long serialVersionUID = -7812312301976306088L;
    private String orderId; //订单id
    private String userId; //用户id
    private String phone; //用户手机号
    private Long exchangeAmount; //兑换金额
    private Integer source;   //兑换来源  0-移动

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getExchangeAmount() {
        return exchangeAmount;
    }

    public void setExchangeAmount(Long exchangeAmount) {
        this.exchangeAmount = exchangeAmount;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
}

