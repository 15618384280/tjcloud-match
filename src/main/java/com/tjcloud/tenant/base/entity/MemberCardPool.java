package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 会员卡池(member_card_pool)
 * @author auto bin.yin 2016.06.20
 */
@LogRequired
public class MemberCardPool extends AbstractEntity {
	private static final long serialVersionUID = 1466411795983L;

	private String cardNo; 					//卡号
	private String tenantId; 				//租户ID
	private Boolean available; 				//0-可用1-已用
	private Long usedDate; 					//使用时间
	private Integer batchNo;				//批次
	private Boolean distinction;            //区分线上线下
	
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	public Integer getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(Integer batchNo) {
		this.batchNo = batchNo;
	}
	public Boolean getAvailable() {
		return available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public Long getUsedDate() {
		return this.usedDate;
	}
	public void setUsedDate(Long usedDate) {
		this.usedDate = usedDate;
	}

	public Boolean getDistinction() {
		return distinction;
	}

	public void setDistinction(Boolean distinction) {
		this.distinction = distinction;
	}
}