package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class OrderFitnessAgeDictionary extends AbstractEntity {
    private static final long serialVersionUID = -81672695407094914L;

    //地区
    private String region;
    //年龄范围
    private String age;
    //数量
    private Integer num;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
