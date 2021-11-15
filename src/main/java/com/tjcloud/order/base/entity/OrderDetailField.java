package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 订场订单明细(order_detail_field)
 * @author auto bin.yin 2016.07.27
 */
@LogRequired
public class OrderDetailField extends AbstractEntity {
	private static final long serialVersionUID = 1469606915455L;

	private String orderId; 				//订单Id
	private String orderRefundId; 			//退订订单Id
	private Integer paymentStatus; 			//1-未支付、2-已支付、3-退款，4.已改签
	private Integer amount; 				//金额
	private Boolean entranceStatus; 		//false-未入场，true-已入场
	private Long entranceTime; 				//入场时间
	private String tenantId; 				//租户Id
	private String stadiumId; 				//场馆Id
	private String stadiumName; 			//场馆名称，冗余
	private String stadiumItemId; 			//场馆ItemId
	private String stadiumItemName; 		//项目名称，冗余
	private String fieldId; 				//场地Id
	private String fieldName; 				//场地名称，冗余
	private String sessionId; 				//场次Id，此字段为冗余字段，并且会存在空情况（商户可以每15分钟预定）
	private Long orderDate; 				//订单日期
	private String resourceDate; 			//资源日期（YYYY-MM-DD）
	private String beginTime; 				//开始时间，19:00
	private String endTime; 				//结束时间，20:15
	private String beforeOrderDetailId; 	//改签前订单明细Id
	
	public Long getEntranceTime() {
		return entranceTime;
	}
	public void setEntranceTime(Long entranceTime) {
		this.entranceTime = entranceTime;
	}
	public Boolean getEntranceStatus() {
		return this.entranceStatus;
	}
	public void setEntranceStatus(boolean entranceStatus) {
		this.entranceStatus = entranceStatus;
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

	public String getFieldId() {
		return this.fieldId;
	}
	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return this.fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Long getOrderDate() {
		return this.orderDate;
	}
	public void setOrderDate(Long orderDate) {
		this.orderDate = orderDate;
	}

	public String getResourceDate() {
		return this.resourceDate;
	}
	public void setResourceDate(String resourceDate) {
		this.resourceDate = resourceDate;
	}

	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBeforeOrderDetailId() {
		return this.beforeOrderDetailId;
	}
	public void setBeforeOrderDetailId(String beforeOrderDetailId) {
		this.beforeOrderDetailId = beforeOrderDetailId;
	}
}