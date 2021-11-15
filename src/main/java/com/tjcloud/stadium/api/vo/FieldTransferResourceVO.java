package com.tjcloud.stadium.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/9/23.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class FieldTransferResourceVO implements Serializable {
    private static final long serialVersionUID = -785586101020280901L;

    @JsonProperty("period_date")
    private String periodDate;

    @JsonProperty("end_period")
    private String endPeriod;

    @JsonProperty("start_period")
    private String startPeriod;
    private int price;

    @JsonProperty("resource_status")
    private String resourceStatus;//俩种状态 一种已订 一种未订
    private String auction;

    @JsonProperty("box_no")
    private Integer boxNo;

    private String sessionId;

    public String getPeriodDate() {
        return this.periodDate;
    }

    public void setPeriodDate(String periodDate) {
        this.periodDate = periodDate;
    }

    public String getEndPeriod() {
        return this.endPeriod;
    }

    public void setEndPeriod(String endPeriod) {
        this.endPeriod = endPeriod;
    }

    public String getStartPeriod() {
        return this.startPeriod;
    }

    public void setStartPeriod(String startPeriod) {
        this.startPeriod = startPeriod;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getResourceStatus() {
        return this.resourceStatus;
    }

    public void setResourceStatus(String resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public String getAuction() {
        return this.auction;
    }

    public void setAuction(String auction) {
        this.auction = auction;
    }

    public Integer getBoxNo() {
        return boxNo;
    }

    public void setBoxNo(Integer boxNo) {
        this.boxNo = boxNo;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
