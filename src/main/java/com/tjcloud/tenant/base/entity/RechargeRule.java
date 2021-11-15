package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
/**
 * (recharge_rule)
 * @author auto bin.yin 2020.05.22
 */
public class RechargeRule extends AbstractEntity {
    private static final long serialVersionUID = -7263643535395755496L;

    private Long rechargeAmount;    //充值金额
    private Long invalidAmount;     //划线价格
    private int duration;             // 有效期至
    private String effectiveType;     // 有效期单位：天 ，月 年￿
    private int cancelTimeNum;        // 退订次数
    private int rankNo;              // 排名
    private String message;     	 //描述

    public Long getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Long rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public Long getInvalidAmount() {
        return invalidAmount;
    }

    public void setInvalidAmount(Long invalidAmount) {
        this.invalidAmount = invalidAmount;
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

    public int getCancelTimeNum() {
        return cancelTimeNum;
    }

    public void setCancelTimeNum(int cancelTimeNum) {
        this.cancelTimeNum = cancelTimeNum;
    }

    public int getRankNo() {
        return rankNo;
    }

    public void setRankNo(int rankNo) {
        this.rankNo = rankNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
