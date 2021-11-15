package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 用户账户表--涉及余额、积分、发票(uac_account)
 * @author auto bin.yin 2016.08.17
 */
@LogRequired
public class Account extends AbstractEntity {
	private static final long serialVersionUID = 1471417820435L;

	private String userId; //用户Id,uac_user
	private Integer balance; //运动豆余额
	private Integer integral; // 积分
	private Integer creditPoint; //信用分
	private Integer invoicePoint; //可开发票余额

	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getBalance() {
		return this.balance;
	}
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getCreditPoint() {
		return this.creditPoint;
	}
	public void setCreditPoint(Integer creditPoint) {
		this.creditPoint = creditPoint;
	}

	public Integer getInvoicePoint() {
		return this.invoicePoint;
	}
	public void setInvoicePoint(Integer invoicePoint) {
		this.invoicePoint = invoicePoint;
	}
}