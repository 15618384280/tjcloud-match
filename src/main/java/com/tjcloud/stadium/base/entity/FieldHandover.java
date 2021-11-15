package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 场地交接表(FieldHandover)表实体类
 *
 * @author lucheng 2020-03-21 14:54:27
 */
public class FieldHandover extends AbstractEntity {
    private static final long serialVersionUID = -81239779877787387L;
    //用户id
    private String userId;
    //场馆id
    private String stadiumId;
    //场馆名称
    private String stadiumName;
    //场馆地址
    private String stadiumAddress;
    //校方名称
    private String schoolName;
    //交接日期
    private String handoverDate;
    //状态: 0-待签字 1-交接完成
    private Integer state;
    //备注
    private String remark;
    //场内情况
    private Boolean insideFieldCheck;
    //场外情况
    private Boolean outFieldCheck;
    //场外情况
    private Boolean checkSportCrowd;
    //管理员签字图片URL
    private String signURL;
    //校方签字图片URL
    private String schoolSignURL;

    //交接日期段 非DB字段
    private String dateSlot;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getInsideFieldCheck() {
        return insideFieldCheck;
    }

    public void setInsideFieldCheck(Boolean insideFieldCheck) {
        this.insideFieldCheck = insideFieldCheck;
    }

    public Boolean getOutFieldCheck() {
        return outFieldCheck;
    }

    public void setOutFieldCheck(Boolean outFieldCheck) {
        this.outFieldCheck = outFieldCheck;
    }

    public Boolean getCheckSportCrowd() {
        return checkSportCrowd;
    }

    public void setCheckSportCrowd(Boolean checkSportCrowd) {
        this.checkSportCrowd = checkSportCrowd;
    }

    public String getSignURL() {
        return signURL;
    }

    public void setSignURL(String signURL) {
        this.signURL = signURL;
    }

    public String getSchoolSignURL() {
        return schoolSignURL;
    }

    public void setSchoolSignURL(String schoolSignURL) {
        this.schoolSignURL = schoolSignURL;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getStadiumAddress() {
        return stadiumAddress;
    }

    public void setStadiumAddress(String stadiumAddress) {
        this.stadiumAddress = stadiumAddress;
    }

    public String getHandoverDate() {
        return handoverDate;
    }

    public void setHandoverDate(String handoverDate) {
        this.handoverDate = handoverDate;
    }
}