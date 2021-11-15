package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by gaojian on 2016/8/18.
 */
public class BatchFieldSessionVO implements Serializable{
    private static final long serialVersionUID = 974448994756826096L;

    private String stadiumItemId;
    private String perTime; //每场时长
    private String timeSetBegin;//开始时间
    private String timeSetEnd;//结束时间
    private List<String> fieldIdList;//场地list
    private List<Integer> dayOfWeeks;//日期类型
    private Boolean always;

    public String getStadiumItemId() {
        return this.stadiumItemId;
    }

    public void setStadiumItemId(String stadiumItemId) {
        this.stadiumItemId = stadiumItemId;
    }

    public String getPerTime() {
        return this.perTime;
    }

    public void setPerTime(String perTime) {
        this.perTime = perTime;
    }

    public String getTimeSetBegin() {
        return this.timeSetBegin;
    }

    public void setTimeSetBegin(String timeSetBegin) {
        this.timeSetBegin = timeSetBegin;
    }

    public String getTimeSetEnd() {
        return this.timeSetEnd;
    }

    public void setTimeSetEnd(String timeSetEnd) {
        this.timeSetEnd = timeSetEnd;
    }

    public List<String> getFieldIdList() {
        return this.fieldIdList;
    }

    public void setFieldIdList(List<String> fieldIdList) {
        this.fieldIdList = fieldIdList;
    }

    public List<Integer> getDayOfWeeks() {
        return this.dayOfWeeks;
    }

    public void setDayOfWeeks(List<Integer> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    public Boolean getAlways() {
        return this.always;
    }

    public void setAlways(Boolean always) {

        if(always == null){
            always = true;
        }

        this.always = always;
    }
}
