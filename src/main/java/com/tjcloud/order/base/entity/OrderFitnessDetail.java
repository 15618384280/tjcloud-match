package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 全民健身打卡记录详情(order_fitness_detail)
 *
 * @author gcy 2021-1-26 14:15:43
 */
public class OrderFitnessDetail extends AbstractEntity {

    private String objectId;            //全民打卡记录id
    private String temperature;            //体温
    private String type;                //健康码状态

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}