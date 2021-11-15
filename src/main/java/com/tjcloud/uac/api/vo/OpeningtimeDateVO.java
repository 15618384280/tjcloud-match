package com.tjcloud.uac.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/7/25.
 */
public class OpeningtimeDateVO implements Serializable{
    private static final long serialVersionUID = 9117306403806562331L;

    private String beginTime;
    private String endTime;

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
}
