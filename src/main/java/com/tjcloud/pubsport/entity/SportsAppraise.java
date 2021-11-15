package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 意见评价(ps_sports_appraise)
 * @author auto bin.yin 2018.02.27
 */
public class SportsAppraise extends AbstractEntity {
	private static final long serialVersionUID = 1519719772048L;

	private String tenantId; //租户ID
	private String placeId; //场所ID
	private String placeName; //场所名称
	private String province; //省
	private String provinceName; //省名称
	private String city; //市
	private String cityName; //市名称
	private String district; //区
	private String districtName; //区名称
	private String street; //街道
	private String streetName; //街道名称
	private String committee; //居委
	private String committeeName; //居委名称
	private String appraiserName; //报修人
	private String appraiserMobile; //报修人联系方式
	private Integer appraiseStart; //报修级别
	private String appraiseContent; //损坏描述
	private Long appraiseTime; //维修时间
	private String replyName; //回复人
	private Long replyTime; //回复时间
	private String replyContent; //回复内容
	private Integer auditStatus; //审核状态(0.未审核,1.审核通过,2.审核不通过)
    private String photoUrl;
    private Integer adviceType; //建议类型

	public Integer getAdviceType() {
		return adviceType;
	}

	public void setAdviceType(Integer adviceType) {
		this.adviceType = adviceType;
	}

	public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
	public String getAppraiserName() {
		return appraiserName;
	}
	public void setAppraiserName(String appraiserName) {
		this.appraiserName = appraiserName;
	}
	public String getAppraiserMobile() {
		return appraiserMobile;
	}
	public void setAppraiserMobile(String appraiserMobile) {
		this.appraiserMobile = appraiserMobile;
	}
	public Integer getAppraiseStart() {
		return appraiseStart;
	}
	public void setAppraiseStart(Integer appraiseStart) {
		this.appraiseStart = appraiseStart;
	}
	public String getAppraiseContent() {
		return appraiseContent;
	}
	public void setAppraiseContent(String appraiseContent) {
		this.appraiseContent = appraiseContent;
	}
	public Long getAppraiseTime() {
		return appraiseTime;
	}
	public void setAppraiseTime(Long appraiseTime) {
		this.appraiseTime = appraiseTime;
	}
	public String getReplyName() {
		return replyName;
	}
	public void setReplyName(String replyName) {
		this.replyName = replyName;
	}
	public Long getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Long replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Integer getAuditStatus() {
		return auditStatus;
	}
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
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
}