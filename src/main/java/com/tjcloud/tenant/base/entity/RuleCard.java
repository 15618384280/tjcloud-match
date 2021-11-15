package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (rule_card)
 * @author auto bin.yin 2019.05.22
 */
public class RuleCard extends AbstractEntity {
    private static final long serialVersionUID = 1558508078987L;

    private String cardCategoryId;   //会员卡类型id
    private String type;             //卡类型(1充值卡,2次卡,4时间卡)
    private Long sumAmount;          //充值金额
    private Long rechargeMinAmount;          //最低充值金额
    private Long giftAmount;         //其中赠送金额
    private Long rechargeMaxAmount;    //最高充值金额
    private String message;     	 //描述

    private String rechargeableUnit; //充值单位：如 元，次 年月天
    private Long expiryDate; 		 // 有效期至
    private int duration; 			 // 有效期至
    private String effectiveType; 	 // 有效期单位：天 ，月 年
    private String giftUnit;         // 赠送单位 ：如 元，次 年月天
    public String getGiftUnit() {
        return giftUnit;
    }
    public void setGiftUnit(String giftUnit) {
        this.giftUnit = giftUnit;
    }
    public String getRechargeableUnit() {
        return rechargeableUnit;
    }
    public void setRechargeableUnit(String rechargeableUnit) {
        this.rechargeableUnit = rechargeableUnit;
    }
    public Long getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getEffectiveType() {
        return effectiveType;
    }
    public void setEffectiveType(String effectiveType) {
        this.effectiveType = effectiveType;
    }



    public String getCardCategoryId() {
        return this.cardCategoryId;
    }
    public void setCardCategoryId(String cardCategoryId) {
        this.cardCategoryId = cardCategoryId;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Long getGiftAmount() {
        return this.giftAmount;
    }
    public void setGiftAmount(Long giftAmount) {
        this.giftAmount = giftAmount;
    }

    public Long getRechargeMinAmount() {
        return rechargeMinAmount;
    }

    public void setRechargeMinAmount(Long rechargeMinAmount) {
        this.rechargeMinAmount = rechargeMinAmount;
    }

    public Long getRechargeMaxAmount() {
        return rechargeMaxAmount;
    }

    public void setRechargeMaxAmount(Long rechargeMaxAmount) {
        this.rechargeMaxAmount = rechargeMaxAmount;
    }

    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Long getSumAmount() {
        return sumAmount;
    }

    public void setSumAmount(Long sumAmount) {
        this.sumAmount = sumAmount;
    }
}
