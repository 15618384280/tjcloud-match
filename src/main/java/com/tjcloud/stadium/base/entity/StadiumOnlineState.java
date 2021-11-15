package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆上下线(stadium_online_state)
 *
 * @author auto bin.yin 2017.12.06
 */
public class StadiumOnlineState extends AbstractEntity {
    private static final long serialVersionUID = 1512531700829L;

    private String objectId; //场馆/项目id
    private boolean aliSport; //阿里体育
    private boolean mapSport;

    public String getObjectId() {
        return this.objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public boolean getAliSport() {
        return this.aliSport;
    }

    public void setAliSport(boolean aliSport) {
        this.aliSport = aliSport;
    }

    public boolean isMapSport() {
        return mapSport;
    }

    public void setMapSport(boolean mapSport) {
        this.mapSport = mapSport;
    }
}