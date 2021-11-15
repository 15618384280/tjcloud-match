package com.tjcloud.tenant.api.enums;

public enum GuideDirectionEnums {
    //指导方向 (0-设施管理维护,1-赛事活动组织,2-健身技能培训,3-运动健康指导)
    FACILITY("设施管理维护", 0),
    MATCH("赛事活动组织", 1),
    FITNESS("健身技能培训", 2),
    SPORTS("运动健康指导", 3);

    private final String text;
    private final int status;

    private GuideDirectionEnums(String text, int status) {
        this.text = text;
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public int getStatus() {
        return status;
    }

    public static String getText(int status) {
        for (GuideDirectionEnums e : GuideDirectionEnums.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}
