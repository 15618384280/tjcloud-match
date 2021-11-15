package com.tjcloud.tenant.base.entity;

public enum InsLevel {

    三级指导员,
    二级指导员,
    一级指导员,
    国家级指导员,
    预备指导员,
    默认;

    public static InsLevel fromOrdinal(int ordinal) {
        for (InsLevel value : values()) {
            if (value.ordinal() == ordinal) {
                return value;
            }
        }
        return InsLevel.fromOrdinal(5);
    }
}
