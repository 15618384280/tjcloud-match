package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/6/28.
 */
public class StadiumItemOpeningTimeDayVO implements Serializable{
    private static final long serialVersionUID = -1851186127754410509L;

    private String id;
    private String openingId;
    private Integer dayOfWeek;

    private List<StadiumItemOpeningTimeDateVO> stadiumItemOpeningTimeDateVOList;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOpeningId() {
        return this.openingId;
    }

    public void setOpeningId(String openingId) {
        this.openingId = openingId;
    }

    public Integer getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<StadiumItemOpeningTimeDateVO> getStadiumItemOpeningTimeDateVOList() {
        return this.stadiumItemOpeningTimeDateVOList;
    }

    public void setStadiumItemOpeningTimeDateVOList(List<StadiumItemOpeningTimeDateVO> stadiumItemOpeningTimeDateVOList) {
        this.stadiumItemOpeningTimeDateVOList = stadiumItemOpeningTimeDateVOList;
    }
}
