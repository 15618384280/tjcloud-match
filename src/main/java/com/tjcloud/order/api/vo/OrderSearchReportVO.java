package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/10/27.
 */
public class OrderSearchReportVO implements Serializable{
    private static final long serialVersionUID = -5447712983144946288L;

    private String orderId;
    private String orderNo;

    private String tenantId;
    private String stadiumId;
    private String userName;
    private String mobile;
    private String orderAmount = "0";
    private String amount = "0";
    private String orderType;
    private String orderTypeS;
    private String orderStatus;
    private String orderStatusS;
    private String channel;
    private String channelS;
    private String createdTime;
    private String createdTimeS;
    private String orderSource;
    private String tenantName;

    private String stadiumName;
    private String name;
    private String memberCard;
    private String hasPayAmount = "0";
    private String userId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getStadiumId() {
        return this.stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOrderAmount() {
        return this.orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getOrderType() {
        return this.orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getOrderTypeS() {
        return this.orderTypeS;
    }

    public void setOrderTypeS(String orderTypeS) {
        this.orderTypeS = orderTypeS;
    }

    public String getOrderStatus() {
        return this.orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatusS() {
        return this.orderStatusS;
    }

    public void setOrderStatusS(String orderStatusS) {
        this.orderStatusS = orderStatusS;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelS() {
        return this.channelS;
    }

    public void setChannelS(String channelS) {
        this.channelS = channelS;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedTimeS() {
        return this.createdTimeS;
    }

    public void setCreatedTimeS(String createdTimeS) {
        this.createdTimeS = createdTimeS;
    }

    public String getOrderSource() {
        return this.orderSource;
    }

    public void setOrderSource(String orderSource) {
        this.orderSource = orderSource;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getStadiumName() {
        return this.stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberCard() {
        return this.memberCard;
    }

    public void setMemberCard(String memberCard) {
        this.memberCard = memberCard;
    }

    public String getHasPayAmount() {
        return this.hasPayAmount;
    }

    public void setHasPayAmount(String hasPayAmount) {
        this.hasPayAmount = hasPayAmount;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
