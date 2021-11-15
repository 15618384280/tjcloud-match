package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/6/28.
 */
public class StadiumItemOpeningTimeDateVO implements Serializable{
    private static final long serialVersionUID = 5116440992570022701L;

    private String id;
    private String openingTimeDayId;
    private String beginTime;
    private String endTime;
    private Integer index;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpeningTimeDayId() {
        return this.openingTimeDayId;
    }

    public void setOpeningTimeDayId(String openingTimeDayId) {
        this.openingTimeDayId = openingTimeDayId;
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

    public Integer getIndex() {
        return this.index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
