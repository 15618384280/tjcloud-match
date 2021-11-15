package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (user_sign_record)签到打卡记录表
 * @author zhujian 2020.03.17
 */
public class UserSignRecord extends AbstractEntity {
	private static final long serialVersionUID = -1588944234818681480L;

	private String userId;								//用户Id
	private String stadiumId;							//场馆Id
	private String stadiumName;							//场馆名称
	private Integer type;								//类型:0-开放前 1-开放中 2-开放后 3-管理员签到
	private String signDate;							//打卡日期
	private String longitude; 							//经度,东经为正数
	private String latitude; 							//纬度
	private String location;							//定位
	private String remark;								//备注
	private Integer checkBoardHead;						//开放前：警示牌安放到位
	private Integer checkCloth;							//开放前：工作服，工作牌穿戴规范
	private Integer checkPlaceHead;						//开放前：场地环境整洁
	private String checkTemperature;					//开放前：巡查人员体温
	private Integer checkService;						//开放中：入/出场服务规范
	private Integer checkSafe;							//开放中：场内运动安全有序
	private Integer checkBoardAfter;					//开放后：警示牌回收到位
	private Integer checkPlaceAfter;					//开放后：场地环境整洁
	private Integer isScore;		                    //是否打分 0-未打分  1-已打分
	
	/**一级场馆人员*/
	private List<UserSignRecordImage> faceImageList;	//笑脸照片集
	private List<UserSignRecordImage> normImageList;	//规范照片集
	private List<UserSignRecordImage> placeImageList;	//场地照片集
	/**管理员*/
	private List<UserSignRecordImage> signImageList;	//管理员签到照片集
	
	
	private String tenantUserId;						//租户用户Id

	public Integer getIsScore() {
		return isScore;
	}

	public void setIsScore(Integer isScore) {
		this.isScore = isScore;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getCheckBoardHead() {
		return checkBoardHead;
	}
	public void setCheckBoardHead(Integer checkBoardHead) {
		this.checkBoardHead = checkBoardHead;
	}
	public Integer getCheckCloth() {
		return checkCloth;
	}
	public void setCheckCloth(Integer checkCloth) {
		this.checkCloth = checkCloth;
	}
	public Integer getCheckPlaceHead() {
		return checkPlaceHead;
	}
	public void setCheckPlaceHead(Integer checkPlaceHead) {
		this.checkPlaceHead = checkPlaceHead;
	}

	public String getCheckTemperature() {
		return checkTemperature;
	}

	public void setCheckTemperature(String checkTemperature) {
		this.checkTemperature = checkTemperature;
	}

	public Integer getCheckService() {
		return checkService;
	}
	public void setCheckService(Integer checkService) {
		this.checkService = checkService;
	}
	public Integer getCheckSafe() {
		return checkSafe;
	}
	public void setCheckSafe(Integer checkSafe) {
		this.checkSafe = checkSafe;
	}
	public Integer getCheckBoardAfter() {
		return checkBoardAfter;
	}
	public void setCheckBoardAfter(Integer checkBoardAfter) {
		this.checkBoardAfter = checkBoardAfter;
	}
	public Integer getCheckPlaceAfter() {
		return checkPlaceAfter;
	}
	public void setCheckPlaceAfter(Integer checkPlaceAfter) {
		this.checkPlaceAfter = checkPlaceAfter;
	}
	public List<UserSignRecordImage> getFaceImageList() {
		return faceImageList;
	}
	public void setFaceImageList(List<UserSignRecordImage> faceImageList) {
		this.faceImageList = faceImageList;
	}
	public List<UserSignRecordImage> getNormImageList() {
		return normImageList;
	}
	public void setNormImageList(List<UserSignRecordImage> normImageList) {
		this.normImageList = normImageList;
	}
	public List<UserSignRecordImage> getPlaceImageList() {
		return placeImageList;
	}
	public void setPlaceImageList(List<UserSignRecordImage> placeImageList) {
		this.placeImageList = placeImageList;
	}
	public List<UserSignRecordImage> getSignImageList() {
		return signImageList;
	}
	public void setSignImageList(List<UserSignRecordImage> signImageList) {
		this.signImageList = signImageList;
	}
	public String getTenantUserId() {
		return tenantUserId;
	}
	public void setTenantUserId(String tenantUserId) {
		this.tenantUserId = tenantUserId;
	}
	
	
}
