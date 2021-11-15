package com.tjcloud.tenant.api.enums;

public enum PoliticalStatusEnums {
    //政治面貌 (0-中共党员,1-中共预备党员,2-共青团员,3-群众,4-其他党派)
    COMMUNIST("中共党员", 0),
    TRIALCOMMUNIST("中共预备党员", 1),
    MEMBER("共青团员", 2),
    MASSES("群众", 3),
    OTHER("其他党派", 4);

    private final String text;
    private final int status;

    private PoliticalStatusEnums(String text, int status) {
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
        for (PoliticalStatusEnums e : PoliticalStatusEnums.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}
