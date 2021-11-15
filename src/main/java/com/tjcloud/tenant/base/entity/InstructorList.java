package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 指导员机构数据导入(InstructorList)表实体类
 *
 * @author makejava 2021-11-02 14:56:40
 */
public class InstructorList extends AbstractEntity {
private static final long serialVersionUID = 440353747945525665L;
    //区code
    private String district;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Boolean getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(Boolean verifyType) {
        this.verifyType = verifyType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Boolean getNeedExamed() {
        return needExamed;
    }

    public void setNeedExamed(Boolean needExamed) {
        this.needExamed = needExamed;
    }

    public Integer getInstructorLevel() {
        return instructorLevel;
    }

    public void setInstructorLevel(Integer instructorLevel) {
        this.instructorLevel = instructorLevel;
    }

    public Integer getGuideDirection() {
        return guideDirection;
    }

    public void setGuideDirection(Integer guideDirection) {
        this.guideDirection = guideDirection;
    }

    public String getIssuingUnit() {
        return issuingUnit;
    }

    public void setIssuingUnit(String issuingUnit) {
        this.issuingUnit = issuingUnit;
    }

    public String getIssuingUnitName() {
        return issuingUnitName;
    }

    public void setIssuingUnitName(String issuingUnitName) {
        this.issuingUnitName = issuingUnitName;
    }

    //区名称
    private String districtName;
    //街道code
    private String street;
    //街道名称
    private String streetName;
    //名称
    private String name;
    //民族
    private String people;
    //性别
    private String sex;
    //身份证号
    private String idCard;
    //(导入数据是否与指导员表核实)状态:0未核实1已核实 是否已经录入
    private Boolean verifyType;
    //补充说明
    private String remark;
    //机构id
    private String institutionId;
    //机构名称
    private String institutionName;
    //是否直接发证 0 直接发证 1 不直接发证，需要考试
    private Boolean needExamed;
    //指导员等级
    private Integer instructorLevel;
    //指导方向
    private Integer guideDirection;
    //发证单位code
    private String issuingUnit;
    //发证单证
    private String issuingUnitName;

    


}
