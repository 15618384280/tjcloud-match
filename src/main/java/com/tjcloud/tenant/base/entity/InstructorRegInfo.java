package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 指导员报名信息表
 * (InstructorRegInfo)表实体类
 *
 * @author makejava 2021-07-22 16:15:29
 */
public class InstructorRegInfo extends AbstractEntity {
    private static final long serialVersionUID = -11628189821797931L;

    //指导员ID
    private String instructorId;
    private String sNo;
    private Boolean check;
    //姓名
    private String name;
    //手机号
    private String phone;
    //指导方向 (0-设施管理维护,1-赛事活动组织,2-健身技能培训,3-运动健康指导)
    private Integer guideDirection;
    //指导员等级 (0-三级指导员,1-二级指导员,2-一级指导员,3-国家级指导员)
    private Integer instructorLevel;
    private String courseId;
    private Integer courseNo;
    private String courseName;
    //任务完成率
    private Double rate;
    //考试结果
    private String result;
    //发证单位 
    private String issuingUnit;
    //发证单位名称
    private String issuingUnitName;

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

    public String getInstructorId() {
        return instructorId;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getIssuingUnit() {
        return issuingUnit;
    }

    public void setIssuingUnit(String issuingUnit) {
        this.issuingUnit = issuingUnit;
    }

    public String getIssuingUnitName() {
        return issuingUnitName;
    }

    public void setIssuingUnitName(String issuingUnitName) {
        this.issuingUnitName = issuingUnitName;
    }
}