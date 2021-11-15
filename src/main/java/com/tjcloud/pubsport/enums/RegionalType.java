package com.tjcloud.pubsport.enums;

public enum RegionalType {
    VILLAGE("0", "小区"),
    PUBLIC_GREEN_SPACE("1","公共绿地");

    private String key;
    private String text;


    private RegionalType(String key, String text) {
        this.key = key;
        this.text = text;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
    public static String getText(String key) {
        RegionalType[] array = values();
        for (RegionalType en : array) {
            if (en.getKey().equals(key)) {
                return en.getText();
            }
        }
        return "";
    }

    public static RegionalType get(String key) {
        RegionalType[] array = values();
        for (RegionalType en : array) {
            if (en.getKey().equals(key)) {
                return en;
            }
        }
        return null;
    }
}


