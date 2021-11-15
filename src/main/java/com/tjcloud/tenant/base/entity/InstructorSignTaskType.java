package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (InstructorSignTaskType)表实体类
 *
 * @author makejava 2021-09-15 14:57:15
 */
public class InstructorSignTaskType extends AbstractEntity {
    private static final long serialVersionUID = -45021997098656258L;

    //类型名称
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}