package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 地标主表(MatchLandmark)表实体类
 *
 * @author lucheng 2020-10-19 11:21:45
 */
public class MatchLandmark extends AbstractEntity {
    private static final long serialVersionUID = -67698809160232217L;
    //租户Id
    private String tenantId;
    //赛事Id
    private String matchId;
    //地标名称
    private String markName;
    //地标短名
    private String shortName;
    //地标介绍
    private String introduce;
    //地图坐标，json数组
    private Object mapCoord;
    //地标展示页面背景图—URL
    private String backgroundHref;
    //地标LOGO—URL
    private String logoHref;
    //状态（0-未点亮,1-已点亮）
    private Boolean state;
    //排序
    private Long sortNo;
    //达标地标数量
    private Integer standardMarkNum;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Object getMapCoord() {
        return mapCoord;
    }

    public void setMapCoord(Object mapCoord) {
        this.mapCoord = mapCoord;
    }

    public String getBackgroundHref() {
        return backgroundHref;
    }

    public void setBackgroundHref(String backgroundHref) {
        this.backgroundHref = backgroundHref;
    }

    public String getLogoHref() {
        return logoHref;
    }

    public void setLogoHref(String logoHref) {
        this.logoHref = logoHref;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Long getSortNo() {
        return sortNo;
    }

    public void setSortNo(Long sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getStandardMarkNum() {
        return standardMarkNum;
    }

    public void setStandardMarkNum(Integer standardMarkNum) {
        this.standardMarkNum = standardMarkNum;
    }
}