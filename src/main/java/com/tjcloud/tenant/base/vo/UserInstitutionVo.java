package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.UserInstitution;

/**
 * @Author TJ20210430
 * @Date 2021/11/4 16:43
 * Describe:
 */
public class UserInstitutionVo extends UserInstitution {
   private String id;
    private String name;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
