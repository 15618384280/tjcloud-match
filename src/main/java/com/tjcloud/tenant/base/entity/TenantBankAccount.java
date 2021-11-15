package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 商户的银行账户信息(tenant_bank_account)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class TenantBankAccount extends AbstractEntity {
	private static final long serialVersionUID = 1462850176836L;

	private String tenantId; 			//商户Id
	private String bankName; 			//银行名称
	private String accountName; 		//账户名称
	private String accountNo; 			//账户号码
	private Integer accountType; 		//账户类型
	private String bankAddress;			//开户地址
	private String tenantName;			//商户名
	private String telephone;			//手机号
	private String rate;				//费率
	private Boolean used; 				//启用

	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public Integer getAccountType() {
		return accountType;
	}
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getBankName() {
		return this.bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountName() {
		return this.accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNo() {
		return this.accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public Boolean getUsed() {
		return this.used;
	}
	public void setUsed(Boolean used) {
		this.used = used;
	}
}