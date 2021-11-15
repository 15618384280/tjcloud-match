package com.tjcloud.tenant.base.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorSignTaskRecord)表实体类
 *
 * @author makejava 2021-09-15 14:57:10
 */
public class InstructorSignTaskRecord extends AbstractEntity {
    private static final long serialVersionUID = -82351882865276051L;
    //任务Id
    private String taskId;
    //指导员id
    private String instructorId;
    //姓名
    private String name;
    //方向
    @JsonSerialize(using = InsDirectionSerializer.class)
    private Integer direction;
    //等级
    @JsonSerialize(using = InsLevelSerializer.class)
    private Integer insLevel;
    //服务区域
    private String serviceArea;
    //领取日期
    private String receDate;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getInsLevel() {
        return insLevel;
    }

    public void setInsLevel(Integer insLevel) {
        this.insLevel = insLevel;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getReceDate() {
        return receDate;
    }

    public void setReceDate(String receDate) {
        this.receDate = receDate;
    }
}