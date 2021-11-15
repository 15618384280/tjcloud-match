package com.tjcloud.match.base.vo;

import com.tjcloud.match.api.enums.Sex;
import com.tjcloud.match.base.entity.MatchPlayers;

import java.io.Serializable;

/**
 * Created by ryan on 2017/3/10.
 */
public class MatchPlayersVO extends MatchPlayers implements Serializable {
    private static final long serialVersionUID = 837145947051831487L;
    private String subjectName;
    private String sexStr;

    public String getSexStr() {
        return sexStr;
    }

    public void setSexStr(String sexStr) {
        this.sexStr = sexStr;
        if (sexStr.equals(Sex.MAN.getText())) {
            super.setSex(Sex.MAN.getStatus());
        } else {
            super.setSex(Sex.WOMAN.getStatus());
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
