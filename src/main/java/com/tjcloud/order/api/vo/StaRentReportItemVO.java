package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/10/25.
 */
public class StaRentReportItemVO implements Serializable{
    private static final long serialVersionUID = -4410255922729117356L;

    private String stadiumId;

    private String stadiumItemId;
    private String stadiumItemName;

    private String cashTime = "0";
    private String cashMoney = "0";
    private String cashPropertion = "0";

    private String platformTime = "0";
    private String platformMoney = "0";
    private String platformPropertion = "0";

    private String cardTime = "0";
    private String cardMoney = "0";
    private String cardPropertion = "0";

    private Integer totalItemMoney = 0;

    public String getStadiumId() {
        return this.stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getStadiumItemId() {
        return this.stadiumItemId;
    }

    public void setStadiumItemId(String stadiumItemId) {
        this.stadiumItemId = stadiumItemId;
    }

    public String getStadiumItemName() {
        return this.stadiumItemName;
    }

    public void setStadiumItemName(String stadiumItemName) {
        this.stadiumItemName = stadiumItemName;
    }

    public String getCashTime() {
        return this.cashTime;
    }

    public void setCashTime(String cashTime) {
        this.cashTime = cashTime;
    }

    public String getCashMoney() {
        return this.cashMoney;
    }

    public void setCashMoney(String cashMoney) {
        this.cashMoney = cashMoney;
    }

    public String getCashPropertion() {
        return this.cashPropertion;
    }

    public void setCashPropertion(String cashPropertion) {
        this.cashPropertion = cashPropertion;
    }

    public String getPlatformTime() {
        return this.platformTime;
    }

    public void setPlatformTime(String platformTime) {
        this.platformTime = platformTime;
    }

    public String getPlatformMoney() {
        return this.platformMoney;
    }

    public void setPlatformMoney(String platformMoney) {
        this.platformMoney = platformMoney;
    }

    public String getPlatformPropertion() {
        return this.platformPropertion;
    }

    public void setPlatformPropertion(String platformPropertion) {
        this.platformPropertion = platformPropertion;
    }

    public String getCardTime() {
        return this.cardTime;
    }

    public void setCardTime(String cardTime) {
        this.cardTime = cardTime;
    }

    public String getCardMoney() {
        return this.cardMoney;
    }

    public void setCardMoney(String cardMoney) {
        this.cardMoney = cardMoney;
    }

    public String getCardPropertion() {
        return this.cardPropertion;
    }

    public void setCardPropertion(String cardPropertion) {
        this.cardPropertion = cardPropertion;
    }

    public Integer getTotalItemMoney() {
        return totalItemMoney;
    }

    public void setTotalItemMoney(Integer totalItemMoney) {
        this.totalItemMoney = totalItemMoney;
    }
}
