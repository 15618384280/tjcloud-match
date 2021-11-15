package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 全民健身打卡记录(order_fitness)
 * @author auto bin.yin 2017.08.29
 */
public class OrderFitness extends AbstractEntity {
	private static final long serialVersionUID = 1503971570267L;

	private String orderId; 			//订单Id
	private String userId; 				//用户Id
	private String userName; 			//用户姓名
	private String cardNo; 				//卡号
	private String phone; 				//手机号
	private Long birthday; 				//出生时间
	private String gender; 				//性别
	private Integer amount; 			//金额
	private Long entranceTime; 			//入场时间（打卡时间）
	private Long outTime;				//出场时间
	private Integer fitnessStatus;		//0-未出场 1-已出场
	private Integer commented;			//0-未评价 1-已评价
	private Integer confirmed;			//0-未确认 1-已确认
	private String tenantId; 			//租户Id
	private String province; 			//省
	private String city; 				//市
	private String district; 			//区
	private String street; 				//街道
	private String sportType; 			//项目类型，篮球，羽毛球,关键字段
	private String stadiumId; 			//场馆Id
	private String stadiumName; 		//场馆名称，冗余
	private String stadiumItemId; 		//场馆ItemId
	private String stadiumItemName; 	//项目名称，冗余
	private Integer channel; 			//打卡来源:1-扫码、2-刷卡、3-订单 4-人脸识别
	private String sourceId;			// 源数据表主键，如：order_detail_fieId.id

	public Integer getCommented() {
		return commented;
	}
	public void setCommented(Integer commented) {
		this.commented = commented;
	}
	public Integer getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}
	public Long getOutTime() {
		return outTime;
	}
	public void setOutTime(Long outTime) {
		this.outTime = outTime;
	}
	public Integer getFitnessStatus() {
		return fitnessStatus;
	}
	public void setFitnessStatus(Integer fitnessStatus) {
		this.fitnessStatus = fitnessStatus;
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getBirthday() {
		return this.birthday;
	}
	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return this.gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Long getEntranceTime() {
		return this.entranceTime;
	}
	public void setEntranceTime(Long entranceTime) {
		this.entranceTime = entranceTime;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getProvince() {
		return this.province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return this.city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return this.district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return this.street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
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
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getCreatorTimeText() {
		if(this.getCreatedTime() == null) {
			return "";
		}
		return (0 == this.getCreatedTime()) ? "" : DateUtils.toString(this.getCreatedTime());
	}
	public String getEntranceTimeText() {
		if(this.getEntranceTime() == null) {
			return "";
		}
		return (0 == this.getEntranceTime()) ? "" : DateUtils.toString(this.getEntranceTime(),"HH:mm:ss");
	}
	public String getOutTimeText() {
		if(this.getOutTime() == null) {
			return "";
		}
		return (0 == this.getOutTime()) ? "" : DateUtils.toString(this.getOutTime(),"HH:mm:ss");
	}
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
}