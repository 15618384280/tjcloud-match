package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/11/30.
 */
public class MemberCardReportVO implements Serializable{
    private static final long serialVersionUID = 8269865324433539597L;

    private String rechargeAmount;
    private String consumeAmount;
    private String lastRechargeTime;
    private String lastConsumeTime;
    private String memberCardId;

    public String getRechargeAmount() {
        return this.rechargeAmount;
    }

    public void setRechargeAmount(String rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getConsumeAmount() {
        return this.consumeAmount;
    }

    public void setConsumeAmount(String consumeAmount) {
        this.consumeAmount = consumeAmount;
    }

    public String getLastRechargeTime() {
        return this.lastRechargeTime;
    }

    public void setLastRechargeTime(String lastRechargeTime) {
        this.lastRechargeTime = lastRechargeTime;
    }

    public String getLastConsumeTime() {
        return this.lastConsumeTime;
    }

    public void setLastConsumeTime(String lastConsumeTime) {
        this.lastConsumeTime = lastConsumeTime;
    }

    public String getMemberCardId() {
        return this.memberCardId;
    }

    public void setMemberCardId(String memberCardId) {
        this.memberCardId = memberCardId;
    }
}
