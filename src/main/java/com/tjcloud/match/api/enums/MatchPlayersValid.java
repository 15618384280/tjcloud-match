package com.tjcloud.match.api.enums;

/**
 * Created by ryan on 2017/3/10.
 * 是否已删除
 */
public enum MatchPlayersValid {

    MATCH_PLAYERS_VALID("有效", 0),
    MATCH_PLAYERS_INVALID("删除", 1),;

    private final String text;
    private final int status;

    private MatchPlayersValid(String text, int status) {
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
        for (OutlineInvalld e : OutlineInvalld.values()) {
            if (e.getStatus() == status) {
                return e.getText();
            }
        }
        return "";
    }
}