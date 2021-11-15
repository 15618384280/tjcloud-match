package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 全民健身性别字典表(OrderFitnessGenderDictionary)表实体类
 *
 * @author makejava 2021-06-02 10:49:19
 */
public class OrderFitnessGenderDictionary extends AbstractEntity {
    private static final long serialVersionUID = 764644971597981629L;
    //地区
    private String region;
    //男
    private Integer man;
    //女
    private Integer woman;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getMan() {
        return man;
    }

    public void setMan(Integer man) {
        this.man = man;
    }

    public Integer getWoman() {
        return woman;
    }

    public void setWoman(Integer woman) {
        this.woman = woman;
    }
}
