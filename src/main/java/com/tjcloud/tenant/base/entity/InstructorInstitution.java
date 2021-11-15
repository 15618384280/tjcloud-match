package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 指导机构表(InstructorInstitution)表实体类
 *
 * @author makejava 2021-11-03 15:30:24
 */
public class InstructorInstitution extends AbstractEntity {
    private static final long serialVersionUID = -65594914693083917L;

    //机构名称
    private String name;
    //机构类型id
    private String typeId;
    //机构类型名称
    private String typeName;
    //机构code
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

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