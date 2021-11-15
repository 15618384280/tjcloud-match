package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

public class DeclareSportsPlace extends AbstractEntity {
    private static final long serialVersionUID = 5464582159494284662L;

    private String tenantId; //租户ID
    private String code; //场所编号
    private String name; //场所名称
    private String constructionType; //建设类型(1-新建，2-改建)
    private String typeId; //场所类型ID
    private String typeName; //场所类型名称
    private Double length; //长
    private Double wide; //宽
    private Double acreage; //面积
    private String province; //省
    private String provinceName; //省名称
    private String city; //市
    private String cityName; //市名称
    private String district; //区
    private String districtName; //区名称
    private String street; //街道
    private String streetName; //街道名称
    private String address; //场所地址

    private String committee; //居委
    private String committeeName; //居委名称

    private String declareTime; //申报时间
    private String schedule; //进度（1-未开工，2-建设中，3-已完工）

    private List<DeclareSportsPlaceItem> sportsPlaceItemList;  // 子项目列表

    public List<DeclareSportsPlaceItem> getSportsPlaceItemList() {
        return sportsPlaceItemList;
    }

    public void setSportsPlaceItemList(List<DeclareSportsPlaceItem> sportsPlaceItemList) {
        this.sportsPlaceItemList = sportsPlaceItemList;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Double getAcreage() {
        return acreage;
    }

    public void setAcreage(Double acreage) {
        this.acreage = acreage;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWide() {
        return wide;
    }

    public void setWide(Double wide) {
        this.wide = wide;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public String getConstructionType() {
        return constructionType;
    }

    public void setConstructionType(String constructionType) {
        this.constructionType = constructionType;
    }

    public String getDeclareTime() {
        return declareTime;
    }

    public void setDeclareTime(String declareTime) {
        this.declareTime = declareTime;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}
