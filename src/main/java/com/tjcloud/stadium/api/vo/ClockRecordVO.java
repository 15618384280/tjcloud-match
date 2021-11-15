package com.tjcloud.stadium.api.vo;

import java.io.Serializable;

/**
 * Created by gaojian on 2016/9/8.
 */
public class ClockRecordVO implements Serializable{
    private static final long serialVersionUID = -5726813880893338223L;

    private String code;
    private String stadiumItemId;
    private String stadiumId;
    
	public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStadiumItemId() {
        return this.stadiumItemId;
    }

    public void setStadiumItemId(String stadiumItemId) {
        this.stadiumItemId = stadiumItemId;
    }

    public String getStadiumId() {
        return this.stadiumId;
    }

    public void setStadiumId(String stadiumId) {
        this.stadiumId = stadiumId;
    }
}
