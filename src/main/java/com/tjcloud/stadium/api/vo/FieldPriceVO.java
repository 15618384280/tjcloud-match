package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/7/14.
 */
public class FieldPriceVO implements Serializable{
    private static final long serialVersionUID = -4451056143392342327L;

    private int price;
    private int discountPrice;
    private String beginTime;
    private String endTime;
    private String sessionId;
    private Boolean used;
    private Integer index; //处于第几个营业时间内
    private Integer coordinate; //坐标为几
    private Integer boxNo; //占几格

    private String reason;//如果已被占用 原因

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getUsed() {
        return this.used;
    }

    public void setUsed(Boolean used) {
        this.used = used;
    }

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getCoordinate() {
        return this.coordinate;
    }

    public void setCoordinate(Integer coordinate) {
        this.coordinate = coordinate;
    }

    public Integer getBoxNo() {
        return this.boxNo;
    }

    public void setBoxNo(Integer boxNo) {
        this.boxNo = boxNo;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
