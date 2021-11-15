package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class MaterialLargeCategory extends AbstractEntity {

    private static final long serialVersionUID = -2859329208855235736L;
    private String tenantId; //租户ID
    private String name; //名称
    private String code; //名称

    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
