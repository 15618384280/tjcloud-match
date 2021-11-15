package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorOpLog)表实体类
 *
 * @author makejava 2021-08-24 12:01:27
 */
public class InstructorOpLog extends AbstractEntity {
    private static final long serialVersionUID = 339287797125797128L;

    //指导员ID
    private String instructorId;
    //指导员姓名
    private String instructorName;
    //手机号
    private String phone;
    //操作人
    private String operatedBy;
    //用户ID
    private String userId;
    //操作模块
    private String opModule;
    //操作类型
    private String opType;

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOperatedBy() {
        return operatedBy;
    }

    public void setOperatedBy(String operatedBy) {
        this.operatedBy = operatedBy;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOpModule() {
        return opModule;
    }

    public void setOpModule(String opModule) {
        this.opModule = opModule;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }
}