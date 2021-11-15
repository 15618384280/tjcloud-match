package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

import java.util.List;

/**
 * 报修记录(ps_repair_record)
 * @author auto bin.yin 2018.03.13
 */
public class RepairRecord extends AbstractEntity {
	private static final long serialVersionUID = 1520927072689L;

	private String tenantId; //租户ID
	private String placeId; //场所ID
	private String placeName; //场所名称
	private String materialId; //器材ID
	private String meterialName; //器材名称
	private String materialSpec; //器材型号
	private String factoryId; //供应商ID
	private String factoryName; //供应商名称
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
	private String buyTime; //购入时间
	private String guaranteeDateStart; //保修开始日期
	private String guaranteeDateEnd; //保修结束日期
	private String reporterName; //报修人
	private String reporterMobile; //报修人联系方式
	private String reportImage; //报修图片
	private String reportTime; //报修时间
	private Integer reportDuration; //报修时长
	private Integer reportLevel; //损坏等级
	private String reportText; //损坏描述
	private Long auditTime; //审核时间
	private Integer repairStatus; //维修状态
	private String repairman; //维修人员ID
	private String repairmanName; //维修人员名称
	private String repairmanPhone; //维修人员联系方式
	private Long repairAmount; //维修金额
	private Integer repairTimes; //维修次数
	private Integer repairLevel; //维修级别(1.一级,2.二级,3.三级)
	private Long repairTime; //维修时间
	private Integer repairDuration; //维修时长
	private String repairImage; //维修图片
	private String repairText; //维修留言
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	List<RepairRecord> records;
	public List<RepairRecord> getRecords() {
		return records;
	}
	public void setRecords(List<RepairRecord> records) {
		this.records = records;
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
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMeterialName() {
		return meterialName;
	}
	public void setMeterialName(String meterialName) {
		this.meterialName = meterialName;
	}
	public String getMaterialSpec() {
		return materialSpec;
	}
	public void setMaterialSpec(String materialSpec) {
		this.materialSpec = materialSpec;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
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
	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getGuaranteeDateStart() {
		return guaranteeDateStart;
	}
	public void setGuaranteeDateStart(String guaranteeDateStart) {
		this.guaranteeDateStart = guaranteeDateStart;
	}
	public String getGuaranteeDateEnd() {
		return guaranteeDateEnd;
	}
	public void setGuaranteeDateEnd(String guaranteeDateEnd) {
		this.guaranteeDateEnd = guaranteeDateEnd;
	}
	public String getReporterName() {
		return reporterName;
	}
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	public String getReporterMobile() {
		return reporterMobile;
	}
	public void setReporterMobile(String reporterMobile) {
		this.reporterMobile = reporterMobile;
	}
	public String getReportImage() {
		return reportImage;
	}
	public void setReportImage(String reportImage) {
		this.reportImage = reportImage;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getReportDuration() {
		return reportDuration;
	}
	public void setReportDuration(Integer reportDuration) {
		this.reportDuration = reportDuration;
	}
	public Integer getReportLevel() {
		return reportLevel;
	}
	public void setReportLevel(Integer reportLevel) {
		this.reportLevel = reportLevel;
	}
	public String getReportText() {
		return reportText;
	}
	public void setReportText(String reportText) {
		this.reportText = reportText;
	}
	public Long getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Long auditTime) {
		this.auditTime = auditTime;
	}
	public Integer getRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(Integer repairStatus) {
		this.repairStatus = repairStatus;
	}
	public String getRepairman() {
		return repairman;
	}
	public void setRepairman(String repairman) {
		this.repairman = repairman;
	}
	public String getRepairmanName() {
		return repairmanName;
	}
	public void setRepairmanName(String repairmanName) {
		this.repairmanName = repairmanName;
	}
	public String getRepairmanPhone() {
		return repairmanPhone;
	}
	public void setRepairmanPhone(String repairmanPhone) {
		this.repairmanPhone = repairmanPhone;
	}
	public Long getRepairAmount() {
		return repairAmount;
	}
	public void setRepairAmount(Long repairAmount) {
		this.repairAmount = repairAmount;
	}
	public Integer getRepairTimes() {
		return repairTimes;
	}
	public void setRepairTimes(Integer repairTimes) {
		this.repairTimes = repairTimes;
	}
	public Integer getRepairLevel() {
		return repairLevel;
	}
	public void setRepairLevel(Integer repairLevel) {
		this.repairLevel = repairLevel;
	}
	public Long getRepairTime() {
		return repairTime;
	}
	public void setRepairTime(Long repairTime) {
		this.repairTime = repairTime;
	}
	public Integer getRepairDuration() {
		return repairDuration;
	}
	public void setRepairDuration(Integer repairDuration) {
		this.repairDuration = repairDuration;
	}
	public String getRepairImage() {
		return repairImage;
	}
	public void setRepairImage(String repairImage) {
		this.repairImage = repairImage;
	}
	public String getRepairText() {
		return repairText;
	}
	public void setRepairText(String repairText) {
		this.repairText = repairText;
	}

	public Long getReportTimeLong() {
		if(this.reportTime == null){
			return this.getCreatedTime();
		}
		try{
			return DateUtils.toLongDateTime(this.reportTime);	
		}catch(Exception e){
			return this.getCreatedTime();
		}
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