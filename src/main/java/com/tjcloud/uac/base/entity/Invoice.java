package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 发票信息表(uac_invoice)
 * @author auto bin.yin 2016.12.23
 */
@LogRequired
public class Invoice extends AbstractEntity {
	private static final long serialVersionUID = 1482470403143L;

	private String userId; //申请发票人id
	private String userName;
	private Integer invoiceAmount; //发票额度
	private String invoiceTitle; //发票抬头
	private String receiverName; //收件人
	private String receiverPhone; //手机号
	private String receiverAddress; //收件地址
	private String expressList; //快递单号
	private Integer status; //是否已付运费 0-未付 1-已付 2-已寄送
	private Long applyTime; //发票申请日期
	private Integer invoiceType; //0-普票 1-
	private String invoiceTitleId;
	private String invoiceRevicerMessageId;

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

	public Integer getInvoiceAmount() {
		return this.invoiceAmount;
	}
	public void setInvoiceAmount(Integer invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return this.receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverAddress() {
		return this.receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public String getExpressList() {
		return this.expressList;
	}
	public void setExpressList(String expressList) {
		this.expressList = expressList;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getApplyTime() {
		return this.applyTime;
	}
	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}

	public Integer getInvoiceType() {
		return this.invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitleId() {
		return this.invoiceTitleId;
	}

	public void setInvoiceTitleId(String invoiceTitleId) {
		this.invoiceTitleId = invoiceTitleId;
	}

	public String getInvoiceRevicerMessageId() {
		return this.invoiceRevicerMessageId;
	}

	public void setInvoiceRevicerMessageId(String invoiceRevicerMessageId) {
		this.invoiceRevicerMessageId = invoiceRevicerMessageId;
	}
}