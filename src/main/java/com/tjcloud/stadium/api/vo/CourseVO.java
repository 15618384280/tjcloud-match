package com.tjcloud.stadium.api.vo;

import com.tjcloud.stadium.base.entity.Course;

import java.io.Serializable;

public class CourseVO extends Course implements Serializable {
    private static final long serialVersionUID = -4461799333757895186L;
    private Integer state;	 //学习状态：0-未开始；1-学习中；2-已完成；

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
