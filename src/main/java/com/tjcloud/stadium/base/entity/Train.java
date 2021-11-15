package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class Train extends AbstractEntity {
    private static final long serialVersionUID = 7242947904035031708L;

    private String trainName;    //培训名称 （例：入职培训、业务培训）
    private Integer trainTypes;   //培训类型 （例：选修、必修）
    private Long endDate;        //结束日期

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public Integer getTrainTypes() {
        return trainTypes;
    }

    public void setTrainTypes(Integer trainTypes) {
        this.trainTypes = trainTypes;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }
}
