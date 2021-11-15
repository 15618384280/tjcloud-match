package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 发票抬头信息表(uac_invoice_title)
 * @author auto bin.yin 2016.12.23
 */
@LogRequired
public class InvoiceTitle extends AbstractEntity {
	private static final long serialVersionUID = 1482470403488L;

	private String title; //抬头
	private Integer invoiceType; //发票类型
	private String userId; //用户id
	private String userName; //用户姓名
	private Boolean isDefault; //设为默认

	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
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

	public Boolean getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
}