package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 充值卡组表(tenant_rechargeable_card_group)
 * @author auto bin.yin 2017.04.26
 */
@LogRequired
public class TenantRechargeableCardGroup extends AbstractEntity {
	private static final long serialVersionUID = 1493191121605L;

	private String beginTime; 									//有效开始日期
	private String endTime; 									//有效结束日期
	private String type; 										//运动卡类型
	private Integer price; 										//单位为分
	private Integer number; 									//运动卡数量
	private Integer amount; 									//运动卡金额(单位为分)
	private Integer totalAmount; 								//此批运动卡总金额
	private String notes; 										//备注信息
	private String targetCustomer; 								//销售对象

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

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return this.price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNumber() {
		return this.number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getAmount() {
		return this.amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getNotes() {
		return this.notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getTargetCustomer() {
		return this.targetCustomer;
	}
	public void setTargetCustomer(String targetCustomer) {
		this.targetCustomer = targetCustomer;
	}

}