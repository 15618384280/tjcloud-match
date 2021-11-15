package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 银行字典表(dd_bank)
 * @author auto bin.yin 2016.06.23
 */
public class Bank extends AbstractEntity {
	private static final long serialVersionUID = 1466651269893L;

	private String bankCode; //银行代码
	private String bankName; //银行名称
	private Boolean disable = Boolean.FALSE; //是否无效

	public String getBankCode() {
		return this.bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return this.bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Boolean getDisable() {
		return this.disable;
	}
	public void setDisable(Boolean disable) {
		this.disable = disable;
	}
}