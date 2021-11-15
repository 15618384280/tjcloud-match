package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 商品销售(order_goods)
 * @author auto bin.yin 2017.05.10
 */
public class OrderGoods extends AbstractEntity {
	private static final long serialVersionUID = 1494407299094L;

	private String orderId; 									//订单ID
	private String tenantId; 									//租户ID
	private String stadiumId; 									//场馆ID
	private String stadiumName; 								//场馆名称
	private String inventoryId; 								//物资ID
	private String code; 										//物资编码
	private String name; 										//物资名称
	private Integer saleNumber; 								//销售数量
	private Long price; 										//销售价格
	private Long saleTime; 										//销售时间
	private Integer paymentStatus; 								//订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
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
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(String inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSaleNumber() {
		return this.saleNumber;
	}
	public void setSaleNumber(Integer saleNumber) {
		this.saleNumber = saleNumber;
	}
	public Long getPrice() {
		return this.price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getSaleTime() {
		return this.saleTime;
	}
	public void setSaleTime(Long saleTime) {
		this.saleTime = saleTime;
	}
	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}