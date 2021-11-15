package com.tjcloud.tenant.base.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorSignTaskLevel)表实体类
 *
 * @author makejava 2021-09-15 14:57:05
 */
public class InstructorSignTaskLevel extends AbstractEntity {
    private static final long serialVersionUID = -33933236992190833L;

    //任务id
    private String taskId;
    //任务等级，指导员等级 (0-三级指导员,1-二级指导员,2-一级指导员,3-国家级指导员,4-预备指导员)
    @JsonSerialize(using = InsLevelSerializer.class)
    private Integer insLevel;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getInsLevel() {
        return insLevel;
    }

    public void setInsLevel(Integer insLevel) {
        this.insLevel = insLevel;
    }
}