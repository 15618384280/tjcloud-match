package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 发票邮寄地址(uac_invoice_revicer_message)
 * @author auto bin.yin 2016.12.23
 */
@LogRequired
public class InvoiceRevicerMessage extends AbstractEntity {
	private static final long serialVersionUID = 1482470403699L;

	private String userId; //用户id
	private String userName; //用户名称
	private String receiverName; //收件人姓名
	private String receiverMobile; //收件人号码
	private String address; //收件地址
	private Boolean isDefault; //设为默认

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

	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverMobile() {
		return this.receiverMobile;
	}
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getIsDefault() {
		return this.isDefault;
	}
	public void setIsDefault(Boolean isDefault) {
		this.isDefault = isDefault;
	}
}