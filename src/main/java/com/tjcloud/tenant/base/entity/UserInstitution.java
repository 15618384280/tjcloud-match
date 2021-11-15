package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (UserInstitution)表实体类
 *
 * @author makejava 2021-11-03 15:30:17
 */
public class UserInstitution extends AbstractEntity {
    private static final long serialVersionUID = 750919112088716444L;

    //用户id
    private String userId;
    //机构id
    private String institutionId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }
}