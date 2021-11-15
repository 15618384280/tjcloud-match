package com.tjcloud.match.api.enums;

/**
 * Created by ryan on 2017/3/23.
 * 赛制类型
 */
public enum SubjectType {
    SINGLE("个人", 0),
    TEAM("团体", 1);

    private final String text;
    private final int type;

    private SubjectType(String text, int status) {
        this.text = text;
        this.type = status;
    }

    public String getText() {
        return text;
    }

    public int getType() {
        return type;
    }

    public static String getText(int type) {
        for (SubjectType t : SubjectType.values()) {
            if (t.getType() == type) {
                return t.getText();
            }
        }
        return "";
    }
}
