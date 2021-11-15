package com.tjcloud.match.base.vo;


import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by ryanchi on 2017/6/23.
 */
public class MatchInfoReport extends AbstractEntity {

    private static final long serialVersionUID = 5060766396613869461L;
    private String matchName;                                   // 赛事名称
    private Long startTime;                                     // 赛事开始时间
    private List<Map<String, Object>> matchSubjectReports;       // 赛事科目报表

    public String getMatchName() {
        return matchName;
    }
    public void setMatchName(String matchName) {
        this.matchName = matchName;
    }
    public Long getStartTime() {
        return startTime;
    }
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }
    public List<Map<String, Object>> getMatchSubjectReports() {
        return matchSubjectReports;
    }
    public void setMatchSubjectReports(List<Map<String, Object>> matchSubjectReports) {
        this.matchSubjectReports = matchSubjectReports;
    }
}
