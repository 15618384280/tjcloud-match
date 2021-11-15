package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 订单总表(order_bracelet_log)
 * @author gcy 2020-8-12 13:45:46
 */
public class OrderBraceletLog extends AbstractEntity {

	private static final long serialVersionUID = -9062742121106445704L;

	private String orderId; 				//订单Id
	private String stadiumId;				//场馆Id
	private String stadiumItemId;			//场馆ItemId
	private String idCard;					//身份证号
	private String orderNo; 				//订单编号,内外部系统订单要标示，生成格式，可以参考https://www.zhihu.com/question/19805896/answer/16517990
	private Integer payType; 				//付款方式：0-其他1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡 9-会员卡按天扣除
	private String eventName;				//事件名称
	private String imei;					//设备识别号
	private String keyNo;					//钥匙序列号
	private Integer remainRingNum;			//手环数量
	private String message;					//消息信息

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumItemId() {
		return stadiumItemId;
	}

	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getKeyNo() {
		return keyNo;
	}

	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}

	public Integer getRemainRingNum() {
		return remainRingNum;
	}

	public void setRemainRingNum(Integer remainRingNum) {
		this.remainRingNum = remainRingNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}