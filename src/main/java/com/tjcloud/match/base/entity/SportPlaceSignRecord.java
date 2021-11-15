package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 健身苑点打卡记录表(SportPlaceSignRecord)表实体类
 *
 * @author makejava 2021-06-24 16:47:45
 */
public class SportPlaceSignRecord extends AbstractEntity {
    private static final long serialVersionUID = 326449742334344640L;

    //报名Id
    private String signRecordId;
    //场所Id
    private String placeId;
    //场所名称
    private String placeName;
    //打卡人Id
    private String signerId;
    //打卡人姓名
    private String signerName;
    //打卡人联系方式
    private String signerMobile;
    //打卡时间
    private String signinTime;

    //用户打卡经度
    private String userLongitude;
    //用户打卡纬度
    private String userLatitude;
    //标语
    private String sloganName;

    public String getSloganName() {
        return sloganName;
    }

    public void setSloganName(String sloganName) {
        this.sloganName = sloganName;
    }

    public String getUserLongitude() {
        return userLongitude;
    }

    public void setUserLongitude(String userLongitude) {
        this.userLongitude = userLongitude;
    }

    public String getUserLatitude() {
        return userLatitude;
    }

    public void setUserLatitude(String userLatitude) {
        this.userLatitude = userLatitude;
    }

    public String getSignRecordId() {
        return signRecordId;
    }

    public void setSignRecordId(String signRecordId) {
        this.signRecordId = signRecordId;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getSignerId() {
        return signerId;
    }

    public void setSignerId(String signerId) {
        this.signerId = signerId;
    }

    public String getSignerName() {
        return signerName;
    }

    public void setSignerName(String signerName) {
        this.signerName = signerName;
    }

    public String getSignerMobile() {
        return signerMobile;
    }

    public void setSignerMobile(String signerMobile) {
        this.signerMobile = signerMobile;
    }

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }

}
