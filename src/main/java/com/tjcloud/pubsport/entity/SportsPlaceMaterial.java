package com.tjcloud.pubsport.entity;

/**
 * 健身场所器材(ps_sports_place_material)
 * @author auto bin.yin 2018.03.12
 */
public class SportsPlaceMaterial extends Material {
	private static final long serialVersionUID = 1520838155560L;

	private String tenantId; //租户ID
	private String placeId; //场所ID
	private String placeType; //场所类型
	private String placeName; //场所名称
	private String materialId; //器材ID
	private Integer quantity; //器材数量
	private String buyDate; //购入时间
	private String guaranteeYears; //保修年限
	private String guaranteeDateStart; //保修开始日期
	private String guaranteeDateEnd; //保修结束日期
	private Integer materialStatus;	//0-正常 1-维修中
	private Boolean isNscc; //是否国体认证
	
	private Long repairTimes; //维修次数
	
	private String province;
	private String provinceName;
	private String city;
	private String cityName;
	private String district;
	private String districtName;
	private String street;
	private String streetName;
	private String address;
	
	public Integer getMaterialStatus() {
		return materialStatus;
	}
	public void setMaterialStatus(Integer materialStatus) {
		this.materialStatus = materialStatus;
	}
	public String getPlaceType() {
		return placeType;
	}
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(String buyDate) {
		this.buyDate = buyDate;
	}
	public String getGuaranteeYears() {
		return guaranteeYears;
	}
	public void setGuaranteeYears(String guaranteeYears) {
		this.guaranteeYears = guaranteeYears;
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
	public Boolean getIsNscc() {
		return isNscc;
	}
	public void setIsNscc(Boolean isNscc) {
		this.isNscc = isNscc;
	}
	public Long getRepairTimes() {
		return repairTimes;
	}
	public void setRepairTimes(Long repairTimes) {
		this.repairTimes = repairTimes;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}