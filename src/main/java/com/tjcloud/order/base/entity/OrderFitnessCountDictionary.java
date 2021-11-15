package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class OrderFitnessCountDictionary extends AbstractEntity {

    private static final long serialVersionUID = 438036322771035260L;

    //地区
    private String region;
    //数量
    private Integer num;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
