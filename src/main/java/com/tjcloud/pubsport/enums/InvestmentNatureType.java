package com.tjcloud.pubsport.enums;

public enum InvestmentNatureType {
    MUNICIPAL_FINANCE("0", "市财政"),
    LOTTERY_FUND("1", "彩票公益金"),
    FINANCE_STREET("2", "街道财政"),
    REGIONAL_FINANCIAL("3", "区财政"),
    SOCIAL_INVESTMENT("4", "社会投资"),
    VILLAGE_FINANCIAL("5", "村财政"),
    TOWN_FINANCIAL("6", "镇财政");

    private String key;
    private String text;


    private InvestmentNatureType(String key, String text) {
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
        InvestmentNatureType[] array = values();
        for (InvestmentNatureType en : array) {
            if (en.getKey().equals(key)) {
                return en.getText();
            }
        }
        return "";
    }

    public static InvestmentNatureType get(String key) {
        InvestmentNatureType[] array = values();
        for (InvestmentNatureType en : array) {
            if (en.getKey().equals(key)) {
                return en;
            }
        }
        return null;
    }
}