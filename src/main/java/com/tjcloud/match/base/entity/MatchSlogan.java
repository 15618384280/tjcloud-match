package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事标题(MatchSlogan)表实体类
 *
 * @author makejava 2021-06-24 13:49:14
 */
public class MatchSlogan extends AbstractEntity {
    private static final long serialVersionUID = 376366645995478511L;

    //赛事Id
    private String matchId;
    //科目Id
    private String subjectId;
    //标题
    private String sloganName;

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSloganName() {
        return sloganName;
    }

    public void setSloganName(String sloganName) {
        this.sloganName = sloganName;
    }
}
