package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/10/25.
 */
public class StadiumRentReportVO implements Serializable{
    private static final long serialVersionUID = -4410255922729117356L;

    private String stadiumItemId;
    private String stadiumId;

    private String time;
    private String money;
    private String propertion;

    public String getStadiumItemId() {
        return this.stadiumItemId;
    }

    public void setStadiumItemId(String stadiumItemId) {
        this.stadiumItemId = stadiumItemId;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return this.money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getPropertion() {
        return this.propertion;
    }

    public void setPropertion(String propertion) {
        this.propertion = propertion;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }
}
