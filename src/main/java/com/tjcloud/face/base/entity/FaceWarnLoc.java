package com.tjcloud.face.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class FaceWarnLoc extends AbstractEntity {
    private static final long serialVersionUID = 1569790432113L;

    private String locIp; //学校Url
    private String name; //学校名称
    private String stadiumId; //学校Id
    private String adminPhone; //管理员手机号

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getLocIp() {
        return locIp;
    }

    public void setLocIp(String locIp) {
        this.locIp = locIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }
}