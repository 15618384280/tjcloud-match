package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 调查记录场地代码所属的场地信息表(dc_po_stadium_item)
 * @author auto bin.yin 2019.02.20
 */
public class DcPoStadiumItem extends AbstractEntity {
	private static final long serialVersionUID = 1550639073878L;

	private Integer enteringYear; //调查年份
	private String enquierId; //所属单位
	private String stadiumItemName; //项目名称
	private String tenantId; //所属商户,关键字段
	private String stadiumId; //场地ID
	private String stadiumName; //场地名称
	private String telephone; //联系电话
	private String sportType; //场地代码名称
	private String sportTypeCode; //场地代码code
	private Long floorSpace; //体育场地面积(平方米)
	private Long quantitySpace; //体育场地数量(块/个)
	private Long quantitySeat; //固定座席(座)
	private Long coveredArea; //建筑面积(平方米)
	private String surfaceMaterial; //面层材料
	private String freezeMode; //冻冰方式（滑冰场馆填写；来源于字典表）
	private Long quantityIce; //冰面数量(块)
	private Long trailArea; //雪道面积(平方米)
	private Long quantityRopeway; //索道数量(条)
	private Long maxdip; //最大高差(米)
	private Long trailLength; //雪道长度(米)
	private Long footpath; //健身步道长度（米）
	private Long quantityApparatus; //器材件数(件)
	private Long trackLength; //赛道长度(米)
	private Long pierQuantity; //码头或栈桥数量
	private Long pierLength; //码头或栈桥长度
	private Long trackQuantity; //跑道数量
	private Long elevenFootball; //内场设置足球场（十一人制）数量
	private Long sevenFootball; //内场设置足球场（七人制）数量
	private Long fiveFootball; //内场设置足球场（五人制）数量
	private Long plateTargetPosition; //靶位数量(飞碟靶场填写)
	private Long holeQuantity; //球洞数量
	private Long shootTargetPosition; //靶位数量(122012射击馆填写)
	private Long sportsApparatus; //器材件数(500002楼宇健身场地填写)
	private Long source; //填写来源 0-小程序，1-PC
	private Integer isAuxiliary; //附属用房设置体育场地情况(0-不是附属并且不是分项，1-是附属, 2-是分项)

	private String auxiliaryId; //附属场地父级ID

	public Integer getEnteringYear() {
		return this.enteringYear;
	}
	public void setEnteringYear(Integer enteringYear) {
		this.enteringYear = enteringYear;
	}
	public String getEnquierId() {
		return enquierId;
	}
	public void setEnquierId(String enquierId) {
		this.enquierId = enquierId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSportType() {
		return this.sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	public String getSportTypeCode() {
		return this.sportTypeCode;
	}
	public void setSportTypeCode(String sportTypeCode) {
		this.sportTypeCode = sportTypeCode;
	}
	public Long getFloorSpace() {
		return this.floorSpace;
	}
	public void setFloorSpace(Long floorSpace) {
		this.floorSpace = floorSpace;
	}
	public Long getQuantitySpace() {
		return this.quantitySpace;
	}
	public void setQuantitySpace(Long quantitySpace) {
		this.quantitySpace = quantitySpace;
	}
	public Long getQuantitySeat() {
		return this.quantitySeat;
	}
	public void setQuantitySeat(Long quantitySeat) {
		this.quantitySeat = quantitySeat;
	}
	public Long getCoveredArea() {
		return this.coveredArea;
	}
	public void setCoveredArea(Long coveredArea) {
		this.coveredArea = coveredArea;
	}
	public String getSurfaceMaterial() {
		return this.surfaceMaterial;
	}
	public void setSurfaceMaterial(String surfaceMaterial) {
		this.surfaceMaterial = surfaceMaterial;
	}
	public String getFreezeMode() {
		return this.freezeMode;
	}
	public void setFreezeMode(String freezeMode) {
		this.freezeMode = freezeMode;
	}
	public Long getQuantityIce() {
		return this.quantityIce;
	}
	public void setQuantityIce(Long quantityIce) {
		this.quantityIce = quantityIce;
	}
	public Long getTrailArea() {
		return this.trailArea;
	}
	public void setTrailArea(Long trailArea) {
		this.trailArea = trailArea;
	}
	public Long getQuantityRopeway() {
		return this.quantityRopeway;
	}
	public void setQuantityRopeway(Long quantityRopeway) {
		this.quantityRopeway = quantityRopeway;
	}
	public Long getMaxdip() {
		return this.maxdip;
	}
	public void setMaxdip(Long maxdip) {
		this.maxdip = maxdip;
	}
	public Long getTrailLength() {
		return this.trailLength;
	}
	public void setTrailLength(Long trailLength) {
		this.trailLength = trailLength;
	}
	public Long getFootpath() {
		return this.footpath;
	}
	public void setFootpath(Long footpath) {
		this.footpath = footpath;
	}
	public Long getQuantityApparatus() {
		return this.quantityApparatus;
	}
	public void setQuantityApparatus(Long quantityApparatus) {
		this.quantityApparatus = quantityApparatus;
	}
	public Long getTrackLength() {
		return this.trackLength;
	}
	public void setTrackLength(Long trackLength) {
		this.trackLength = trackLength;
	}
	public Long getPierQuantity() {
		return this.pierQuantity;
	}
	public void setPierQuantity(Long pierQuantity) {
		this.pierQuantity = pierQuantity;
	}
	public Long getPierLength() {
		return this.pierLength;
	}
	public void setPierLength(Long pierLength) {
		this.pierLength = pierLength;
	}
	public Long getTrackQuantity() {
		return this.trackQuantity;
	}
	public void setTrackQuantity(Long trackQuantity) {
		this.trackQuantity = trackQuantity;
	}
	public Long getElevenFootball() {
		return this.elevenFootball;
	}
	public void setElevenFootball(Long elevenFootball) {
		this.elevenFootball = elevenFootball;
	}
	public Long getSevenFootball() {
		return this.sevenFootball;
	}
	public void setSevenFootball(Long sevenFootball) {
		this.sevenFootball = sevenFootball;
	}
	public Long getFiveFootball() {
		return this.fiveFootball;
	}
	public void setFiveFootball(Long fiveFootball) {
		this.fiveFootball = fiveFootball;
	}
	public Long getPlateTargetPosition() {
		return this.plateTargetPosition;
	}
	public void setPlateTargetPosition(Long plateTargetPosition) {
		this.plateTargetPosition = plateTargetPosition;
	}
	public Long getHoleQuantity() {
		return this.holeQuantity;
	}
	public void setHoleQuantity(Long holeQuantity) {
		this.holeQuantity = holeQuantity;
	}
	public Long getShootTargetPosition() {
		return this.shootTargetPosition;
	}
	public void setShootTargetPosition(Long shootTargetPosition) {
		this.shootTargetPosition = shootTargetPosition;
	}
	public Long getSportsApparatus() {
		return this.sportsApparatus;
	}
	public void setSportsApparatus(Long sportsApparatus) {
		this.sportsApparatus = sportsApparatus;
	}
	public Long getSource() {
		return this.source;
	}
	public void setSource(Long source) {
		this.source = source;
	}
	public Integer getIsAuxiliary() {
		return this.isAuxiliary;
	}
	public void setIsAuxiliary(Integer isAuxiliary) {
		this.isAuxiliary = isAuxiliary;
	}
	public String getAuxiliaryId() {
		return this.auxiliaryId;
	}
	public void setAuxiliaryId(String auxiliaryId) {
		this.auxiliaryId = auxiliaryId;
	}
}