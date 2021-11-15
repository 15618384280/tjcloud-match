package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 机构类型表(InstitutionType)表实体类
 *
 * @author makejava 2021-11-03 15:30:31
 */
public class InstitutionType extends AbstractEntity {
    private static final long serialVersionUID = 535952354888937653L;
    //机构类型名称
    private String typeName;
    //机构编号
    private String code;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}