package com.tjcloud.tenant.base.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.tenant.api.enums.ApprovalStatusEnums;
import com.tjcloud.tenant.api.enums.EducationEnums;
import com.tjcloud.tenant.api.enums.PoliticalStatusEnums;
import com.tjcloud.tenant.base.vo.InstructorRegInfoVo;

import java.util.List;

/**
 * 指导员(Instructor)表实体类
 *
 * @author makejava 2021-02-23 15:03:32
 */
public class Instructor extends AbstractEntity {
    private static final long serialVersionUID = 802657343089894249L;
    //姓 名
    private String name;
    //手机号
    private String phone;
    //用户ID
    private String userId;
    //身份证
    private String idCard;
    //民族
    private String people;
    //市
    private String city;
    //市
    private String cityName;
    //区
    private String district;
    //区
    private String districtName;
    //所属街道 
    private String street;
    //所属街道名称
    private String streetName;
    //详细地址
    private String address;
    //最高学历
    private Integer education;
    //政治面貌
    private Integer politicalStatus;
    //服务区域
    private String serviceArea;
    //审核状态
    private Integer approvalStatus;
    //认证状态
    private Integer AuthStatus;
    //审核时间
    private Long approvalTime;
    //备注
    private String remarks;
    private String sNo;
    private String institutionId;
    private Integer source;


    //最高学历名称
    private String educationName;
    //审核状态
    private String approvalStatusName;
    //政治面貌名称
    private String politicalStatusName;
    //指导员认证集合
    List<InstructorCertificate> instructorCertificates;

    List<InstructorRegInfoVo> infos;

    //服务区域数组
    private JSONArray serviceAreaArray;

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public List<InstructorRegInfoVo> getInfos() {
        return infos;
    }

    public void setInfos(List<InstructorRegInfoVo> infos) {
        this.infos = infos;
    }

    public String getsNo() {
        return sNo;
    }

    public void setsNo(String sNo) {
        this.sNo = sNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    public Integer getPoliticalStatus() {
        return politicalStatus;
    }

    public void setPoliticalStatus(Integer politicalStatus) {
        this.politicalStatus = politicalStatus;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public Integer getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(Integer approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getEducationName() {
        if (!ObjectUtils.isEmpty(this.education)) {
            return EducationEnums.getText(this.education);
        }
        return null;
    }
    public String getApprovalStatusName() {
        if (!ObjectUtils.isEmpty(this.approvalStatus)) {
            return ApprovalStatusEnums.getText(this.approvalStatus);
        }
        return null;

    }
    public String getPoliticalStatusName() {
        if (!ObjectUtils.isEmpty(this.politicalStatus)) {
            return PoliticalStatusEnums.getText(this.politicalStatus);
        }
        return null;

    }

    public List<InstructorCertificate> getInstructorCertificates() {
        return instructorCertificates;
    }

    public void setInstructorCertificates(List<InstructorCertificate> instructorCertificates) {
        this.instructorCertificates = instructorCertificates;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getApprovalTime() {
        return approvalTime;
    }

    public void setApprovalTime(Long approvalTime) {
        this.approvalTime = approvalTime;
    }

    public JSONArray getServiceAreaArray() {
        if (StringUtils.isNotEmpty(this.serviceArea)) {
            return JSON.parseArray(this.serviceArea);
        }
        return serviceAreaArray;
    }

    public void setServiceAreaArray(JSONArray serviceAreaArray) {
        if (serviceAreaArray != null) {
            setServiceArea(serviceAreaArray.toString());
        }
        this.serviceAreaArray = serviceAreaArray;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Integer getAuthStatus() {
        return AuthStatus;
    }

    public void setAuthStatus(Integer authStatus) {
        AuthStatus = authStatus;
    }
}