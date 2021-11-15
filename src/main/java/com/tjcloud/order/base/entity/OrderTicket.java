package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 票卷订单明细(order_ticket)
 * @author auto bin.yin 2016.08.12
 */
@LogRequired
public class OrderTicket extends AbstractEntity {
	private static final long serialVersionUID = 1470990823050L;

	private String orderId; 									//订单Id
	private String orderRefundId; 								//退订订单Id
	private Integer tickerType; 								//券类型: 0-凭票、1-计时付费、2-计次
	private Boolean ismember; 									//false-不是会员卡，true-是会员
	private String memberCardId; 								//会员卡ID
	private String cardNo; 										//会员卡号
	private Integer paymentStatus; 								//订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
	private Integer amount; 									//金额
	private String doorId; 										//闸机控制器ID
	private Boolean entranceStatus;								//false-未入场，true-已入场
	private Long entranceTime;									//入场时间
	private Long playingTime;									//出场时间
	private Integer playingMinute;								//运动了多少分钟
	private String entranceBeginTime; 							//开始时间
	private String entranceEndTime; 							//结束时间 
	private String tenantId; 									//租户Id
	private String stadiumId; 									//场馆Id
	private String stadiumName; 								//场馆名称，冗余
	private String stadiumItemId; 								//场馆ItemId
	private String stadiumItemName; 							//项目名称，冗余
	private Long orderDate; 									//订单日期
	private String stadiumTicketId; 							//票劵ID
	private String stadiumTicketName; 							//票劵名称
	private Integer ticketPeriod; 								//0-通用  1-工作日 2-周末
	private String timeLimitedHours; 							//限时小时
	private Integer ticketNum;									//数量
	private Integer entranceCode; 								//入场验证码
	private String keyNo; 										//钥匙序列号
	private String codeNo; 										//钥匙编号
	private String insideNo; 									//会员卡内码
	private String categoryName; 								//会员卡名称
	private Integer categoryType; 								//会员卡类型
	private String categoryTypeText; 							//类型TEXT
	private String valEndTime; 									//会员卡有效期
	private Integer inPunchCount; 								//进闸机最大刷卡次数
	private Integer outPunchCount; 								//出闸机最大刷卡次数
	private String idCard; 										//身份证号
	
	public String getTimeLimitedHours() {
		return timeLimitedHours;
	}
	public void setTimeLimitedHours(String timeLimitedHours) {
		this.timeLimitedHours = timeLimitedHours;
	}
	public Integer getTicketPeriod() {
		return ticketPeriod;
	}
	public void setTicketPeriod(Integer ticketPeriod) {
		this.ticketPeriod = ticketPeriod;
	}
	public String getStadiumTicketName() {
		return stadiumTicketName;
	}
	public void setStadiumTicketName(String stadiumTicketName) {
		this.stadiumTicketName = stadiumTicketName;
	}
	public String getEntranceBeginTime() {
		return entranceBeginTime;
	}
	public void setEntranceBeginTime(String entranceBeginTime) {
		this.entranceBeginTime = entranceBeginTime;
	}
	public String getEntranceEndTime() {
		return entranceEndTime;
	}
	public void setEntranceEndTime(String entranceEndTime) {
		this.entranceEndTime = entranceEndTime;
	}
	public Integer getEntranceCode() {
		return entranceCode;
	}
	public void setEntranceCode(Integer entranceCode) {
		this.entranceCode = entranceCode;
	}
	public void setEntranceStatus(Boolean entranceStatus) {
		this.entranceStatus = entranceStatus;
	}
	public Boolean getEntranceStatus() {
		return this.entranceStatus;
	}
	
	public Long getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(Long entranceTime) {
		this.entranceTime = entranceTime;
	}
	
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderRefundId() {
		return this.orderRefundId;
	}
	public void setOrderRefundId(String orderRefundId) {
		this.orderRefundId = orderRefundId;
	}

	public Integer getTickerType() {
		return tickerType;
	}
	public void setTickerType(Integer tickerType) {
		this.tickerType = tickerType;
	}
	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDoorId() {
		return doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
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

	public Long getOrderDate() {
		return this.orderDate;
	}
	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public String getStadiumTicketId() {
		return this.stadiumTicketId;
	}
	public void setStadiumTicketId(String stadiumTicketId) {
		this.stadiumTicketId = stadiumTicketId;
	}
	public Integer getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(Integer ticketNum) {
		this.ticketNum = ticketNum;
	}
	public Long getPlayingTime() {
		return playingTime;
	}
	public void setPlayingTime(Long playingTime) {
		this.playingTime = playingTime;
	}
	public Integer getPlayingMinute() {
		return playingMinute;
	}
	public void setPlayingMinute(Integer playingMinute) {
		this.playingMinute = playingMinute;
	}
	public String getKeyNo() {
		return keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public Boolean getIsmember() {
		return ismember;
	}
	public void setIsmember(Boolean ismember) {
		this.ismember = ismember;
	}
	
	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public Integer getInPunchCount() {
		return inPunchCount;
	}
	public void setInPunchCount(Integer inPunchCount) {
		this.inPunchCount = inPunchCount;
	}
	public Integer getOutPunchCount() {
		return outPunchCount;
	}
	public void setOutPunchCount(Integer outPunchCount) {
		this.outPunchCount = outPunchCount;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getInsideNo() {
		return insideNo;
	}
	public void setInsideNo(String insideNo) {
		this.insideNo = insideNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}
	public String getCategoryTypeText() {
		return categoryTypeText;
	}
	public void setCategoryTypeText(String categoryTypeText) {
		this.categoryTypeText = categoryTypeText;
	}
	public String getValEndTime() {
		return valEndTime;
	}
	public void setValEndTime(String valEndTime) {
		this.valEndTime = valEndTime;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
}