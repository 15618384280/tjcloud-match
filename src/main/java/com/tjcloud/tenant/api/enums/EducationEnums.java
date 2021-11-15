package com.tjcloud.tenant.api.enums;

public enum EducationEnums {
    //学历 (0-小学,1-初中,2-高中,2-中专,2-大专,2-本科,2-硕士研究生,2-博士研究生)
    PRIMARYSCHOOL("小学", 0),
    JUNIORHIGHSCHOOL("初中", 1),
    HIGHSCHOOL("高中", 2),
    TECHNICALSECONDARYSCHOOL("中专", 3),
    JUNIORCOLLEGE("大专", 4),
    UNDERGRADUATE("本科", 5),
    POSTGRADUATE("硕士研究生", 6),
    PHDSTUDENT("博士研究生", 7),
    NOEDUCATION("", 8);


    private final String text;
    private final int status;

    private EducationEnums(String text, int status) {
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
        for (EducationEnums e : EducationEnums.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}
