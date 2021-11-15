package com.tjcloud.order.api.vo;

import java.io.Serializable;

/**
 * 平台对账
 * @author lihongzhou
 */
		
public class PlatformOrderReportVO implements Serializable{
	
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -7281042084618686429L;
	//汇总信息
	private Long orderNum;			// 订单数量
	private Long orderDetailNum;	// 订单明细数量
	private Long amount;			// 订单明细金额
	//订单信息
	private String orderId;			// 订单id
	private String orderNo;			// 订单号
	private String phone;			// 电话
	
	//订单明细
	private String orderDetailId;	// id
	private String stadiumItemId; 	// 项目
	private String stadiumItemName; // 项目名
	private String fieldId;			// 场地
	private String fieldName;		// 场地名
	private String resourceDate;	// 资源日期
	private String beginTime;		// 开始时间
	private String endTime;			// 结束时间
	private Long createdTime;     // 创建时间
	private String createdTimeStr;     // 创建时间
	
	//票劵明细
	private String stadiumTicketName;// 票劵名
	private Long ticketNum;			// 数量
	private String entranceTime;	// 入场时间

	private Long actualAmount;      // 结算金额
	private Long couponAmount; 	    // 配送金额
	private String actualAmountString;      // 结算金额
	private String couponAmountString; 	    // 配送金额
	private String exportAmount;	// 导出金额
	//场地信息
	private String city; //场地所在城市代号
	private String cityNames;

	public String getActualAmountString() {
		return actualAmountString;
	}

	public void setActualAmountString(String actualAmountString) {
		this.actualAmountString = actualAmountString;
	}

	public String getCouponAmountString() {
		return couponAmountString;
	}

	public void setCouponAmountString(String couponAmountString) {
		this.couponAmountString = couponAmountString;
	}

	public Long getActualAmount() {
		return actualAmount;
	}

	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Long getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(Long couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getCityNames() {
		return cityNames;
	}
	public void setCityNames(String cityNames) {
		this.cityNames = cityNames;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getExportAmount() {
		return exportAmount;
	}
	public void setExportAmount(String exportAmount) {
		this.exportAmount = exportAmount;
	}
	public String getStadiumTicketName() {
		return stadiumTicketName;
	}
	public void setStadiumTicketName(String stadiumTicketName) {
		this.stadiumTicketName = stadiumTicketName;
	}
	
	public Long getTicketNum() {
		return ticketNum;
	}
	public void setTicketNum(Long ticketNum) {
		this.ticketNum = ticketNum;
	}
	
	public String getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(String entranceTime) {
		this.entranceTime = entranceTime;
	}
	
	public String getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(String orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getFieldId() {
		return fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getResourceDate() {
		return resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Long getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}
	public Long getOrderDetailNum() {
		return orderDetailNum;
	}
	public void setOrderDetailNum(Long orderDetailNum) {
		this.orderDetailNum = orderDetailNum;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	public String getCreatedTimeStr() {
		return createdTimeStr;
	}

	public void setCreatedTimeStr(String createdTimeStr) {
		this.createdTimeStr = createdTimeStr;
	}
}
