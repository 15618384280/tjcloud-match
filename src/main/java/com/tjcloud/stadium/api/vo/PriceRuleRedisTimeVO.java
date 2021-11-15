package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/6/29.
 */
public class PriceRuleRedisTimeVO implements Serializable{
    private static final long serialVersionUID = -3239143146509937926L;

    private String beginTime;
    private String endTime;
    private String money;

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

    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
