package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.OrderGoods;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * 商品售卖订单
 * @author lihongzhou
 */
public class OrderGoodsVO implements Serializable{

	private static final long serialVersionUID = -8363337636296215364L;
	
	private String orderId;			//订单id
	private String orderNo;			//订单号
	private Integer orderType;  	//8-商品售卖
	private String orderTypeText;	//
	private String userName;		//用户
	private String phone;			//电话
	private Integer orderAmount;	//订单金额
	private Integer actualAmount;	//实付金额
	private Integer orderStatus; 	//订单状态3-已支付
	private String orderStatusText;	//
	private Integer orderPayType;	//支付类型
	private String orderPayTypeText;	//
	private String remark;			//备注
	private String orderTime;		//下单时间
	
	private List<OrderGoods> orderDetails; // 订单明细

	public String getOrderStatusText() {
		return orderStatusText;
	}
	public void setOrderStatusText(String orderStatusText) {
		this.orderStatusText = orderStatusText;
	}
	public String getOrderTypeText() {
		return orderTypeText;
	}
	public void setOrderTypeText(String orderTypeText) {
		this.orderTypeText = orderTypeText;
	}
	public String getOrderPayTypeText() {
		return orderPayTypeText;
	}
	public void setOrderPayTypeText(String orderPayTypeText) {
		this.orderPayTypeText = orderPayTypeText;
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

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Integer getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Integer actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	public List<OrderGoods> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderGoods> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
