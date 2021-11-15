package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorCourse)表实体类
 *
 * @author makejava 2021-08-12 14:47:50
 */
public class InstructorCourse extends AbstractEntity {
    private static final long serialVersionUID = 767139766730521249L;
    //id
    //指导方向 (0-设施管理维护,1-赛事活动组织,2-健身技能培训,3-运动健康指导)
    private Integer guideDirection;
    //指导员等级 (0-三级指导员,1-二级指导员,2-一级指导员,3-国家级指导员)
    private Integer instructorLevel;
    //课程id
    private String courseId;
    //课程编号
    private Integer courseNo;
    //课程名称
    private String courseName;
    //是否需要考试
    private Boolean check;

    public Integer getGuideDirection() {
        return guideDirection;
    }

    public void setGuideDirection(Integer guideDirection) {
        this.guideDirection = guideDirection;
    }

    public Integer getInstructorLevel() {
        return instructorLevel;
    }

    public void setInstructorLevel(Integer instructorLevel) {
        this.instructorLevel = instructorLevel;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Integer getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(Integer courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
}