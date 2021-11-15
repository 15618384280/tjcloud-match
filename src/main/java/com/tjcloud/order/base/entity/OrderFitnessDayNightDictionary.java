package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class OrderFitnessDayNightDictionary extends AbstractEntity {
    private static final long serialVersionUID = 931701312175328345L;
    //地区
    private String region;
    //早
    private Integer early;
    //晚
    private Integer late;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getEarly() {
        return early;
    }

    public void setEarly(Integer early) {
        this.early = early;
    }

    public Integer getLate() {
        return late;
    }

    public void setLate(Integer late) {
        this.late = late;
    }
}
