package com.tjcloud.tenant.base.entity;

public enum InsDirection {

    设施管理维护,
    赛事活动组织,
    健身技能培训,
    运动健康指导,
    默认;

    public static InsDirection fromOrdinal(int ordinal) {
        for (InsDirection value : values()) {
            if (value.ordinal() == ordinal) {
                return value;
            }
        }
        return InsDirection.fromOrdinal(4);
    }
}
