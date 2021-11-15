package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class LearnCourse extends AbstractEntity {

    private static final long serialVersionUID = -5725175666745429683L;

    private String userId; //用户id
    private String courseId; //课程Id
    private Integer state;	 //学习状态：0-未开始；1-学习中；2-已完成；

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
