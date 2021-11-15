package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class DeclareSportsPlaceItem extends AbstractEntity {
    private static final long serialVersionUID = 3920392868949970251L;

    private String sportsPlaceId; //场所Id
    private String sportsPlaceName; // 场所名
    private String sportsPlaceItemName; //健身场所子项目名字
    private String sportType; //项目类型
    private double fieldCount;		//场地数量


    public String getSportsPlaceId() {
        return sportsPlaceId;
    }

    public void setSportsPlaceId(String sportsPlaceId) {
        this.sportsPlaceId = sportsPlaceId;
    }

    public String getSportsPlaceName() {
        return sportsPlaceName;
    }

    public void setSportsPlaceName(String sportsPlaceName) {
        this.sportsPlaceName = sportsPlaceName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public double getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(double fieldCount) {
        this.fieldCount = fieldCount;
    }

    public String getSportsPlaceItemName() {
        return sportsPlaceItemName;
    }

    public void setSportsPlaceItemName(String sportsPlaceItemName) {
        this.sportsPlaceItemName = sportsPlaceItemName;
    }
}
