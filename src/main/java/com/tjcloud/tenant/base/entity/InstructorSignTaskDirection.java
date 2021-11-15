package com.tjcloud.tenant.base.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorSignTaskDirection)表实体类
 *
 * @author makejava 2021-09-15 14:57:00
 */
public class InstructorSignTaskDirection extends AbstractEntity {
    private static final long serialVersionUID = -83968291696671026L;

    //任务id
    private String taskId;
    //任务方向指导方向 (0-设施管理维护,1-赛事活动组织,2-健身技能培训,3-运动健康指导)
    @JsonSerialize(using = InsDirectionSerializer.class)
    private Integer direction;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }
}