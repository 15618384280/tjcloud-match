package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/9/30.
 */
public class PriceCollectionVO implements Serializable{
    private static final long serialVersionUID = 3406588740784124703L;

    private String fieldId;
    private String beginTime;
    private String endTime;
    private int always;
    private long beginEffectDate;
    private long endEffectDate;
    private int price;
    private int discountPrice;

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public void setFieldId(String fieldId) {
        this.fieldId = fieldId;
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

    public int getAlways() {
        return this.always;
    }

    public void setAlways(int always) {
        this.always = always;
    }

    public long getBeginEffectDate() {
        return this.beginEffectDate;
    }

    public void setBeginEffectDate(long beginEffectDate) {
        this.beginEffectDate = beginEffectDate;
    }

    public long getEndEffectDate() {
        return this.endEffectDate;
    }

    public void setEndEffectDate(long endEffectDate) {
        this.endEffectDate = endEffectDate;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
