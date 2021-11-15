package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/6/28.
 */
public class StadiumItemOpeningTimeVO implements Serializable{
    private static final long serialVersionUID = -7836052627896350255L;

    private String id;
    private String stadiumItemId;
    private Boolean always;
    private String beginEffecDate;
    private String endEffecDate;

    private List<StadiumItemOpeningTimeDayVO> stadiumItemOpeningTimeDayVOList;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStadiumItemId() {
        return this.stadiumItemId;
    }

    public void setStadiumItemId(String stadiumItemId) {
        this.stadiumItemId = stadiumItemId;
    }

    public Boolean getAlways() {
        return this.always;
    }

    public void setAlways(Boolean always) {
        this.always = always;
    }

    public String getBeginEffecDate() {
        return this.beginEffecDate;
    }

    public void setBeginEffecDate(String beginEffecDate) {
        this.beginEffecDate = beginEffecDate;
    }

    public String getEndEffecDate() {
        return this.endEffecDate;
    }

    public void setEndEffecDate(String endEffecDate) {
        this.endEffecDate = endEffecDate;
    }

    public List<StadiumItemOpeningTimeDayVO> getStadiumItemOpeningTimeDayVOList() {
        return this.stadiumItemOpeningTimeDayVOList;
    }

    public void setStadiumItemOpeningTimeDayVOList(List<StadiumItemOpeningTimeDayVO> stadiumItemOpeningTimeDayVOList) {
        this.stadiumItemOpeningTimeDayVOList = stadiumItemOpeningTimeDayVOList;
    }
}
