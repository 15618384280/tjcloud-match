package com.tjcloud.order.enums;

public enum OrderFitnessDataEnums {
    FACE_SCAN_CODE_Date("扫码-刷脸日期", "face_scan_code_date"),
    FACE_NUM ("人脸识别", "face_num"),
    SCAN_CODE_NUM ("扫码数", "scan_code_num"),
    SCAN_CARD_NUM("刷卡","scan_card_num"),
    AGE("年龄", "age"),
    CODE_DATA_AGE_NUM("三码合一年数据", "code_data_age_num"),
    CODE_DATA_WEEK_NUM("三码合一周数据", "code_data_week_num"),
    CODE_DATA_RADIO_WOMAN("女士所占比例","code_data_radio_woman"),
    CODE_DATA_RADIO_MAN("男士所占比例","code_data_radio_man"),
    ZERO_EIGHTEEN_AGE_RADIO("18岁以下","zero_eighteen_age_radio"),
    NINETEEN_THIRTY_AGE_RADIO("19-30岁","nineteen_thirty_age_radio"),
    THIRTY_ONE_FORTY_AGE_RADIO("31-40岁","thirty_one_forty_age_radio"),
    FORTY_ONE_FIFTY_AGE_RADIO("41-50岁","forty_one_fifty_age_radio"),
    FIFTY_ONE_SIXTY_AGE_RADIO("51-60岁","fifty_one_sixty_age_radio"),
    SIXTY_ONE_AGE_RADIO("61岁以上","sixty_one_age_radio"),
    LAST_WEEK_STADIUM_NUM("上周场馆数","last_week_stadium_num"),
    THIS_WEEK_STADIUM_NUM("本周场馆数","this_week_stadium_num"),
    STADIUM_NUM("场馆数","stadium_num"),
    SP_RANK("场馆排行", "swimPool_rank"),
    REGION_RANK("地区排行", "region_rank");

    private String text;
    private String code;

    private OrderFitnessDataEnums(String text, String code) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return this.code;
    }
    public String getText() {
        return this.text;
    }

    public static String getText(String code) {
        OrderFitnessDataEnums[] array = values();
        for (OrderFitnessDataEnums en : array) {
            if (en.getCode().equals(code)) {
                return en.getText();
            }
        }
        return "";
    }
}
