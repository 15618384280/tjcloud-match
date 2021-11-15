package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.Instructor;

public class InstitutionInstructorVo extends Instructor {
    private String id; //指导员id
    private Integer guideDirection;//指导员方向
    private Integer instructorLevel;
    private String directionName;
    private String levelName;

    public String getDirectionName() {
        return directionName;
    }

    public void setDirectionName(String directionName) {
        this.directionName = directionName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getGuideDirection() {
        return guideDirection;
    }

    public void setGuideDirection(Integer guideDirection) {
        this.guideDirection = guideDirection;
    }

    public Integer getInstructorLevel() {
        return instructorLevel;
    }

    public void setInstructorLevel(Integer instructorLevel) {
        this.instructorLevel = instructorLevel;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}
