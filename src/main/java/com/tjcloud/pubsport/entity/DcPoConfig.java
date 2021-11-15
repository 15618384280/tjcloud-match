package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 审批记录表(dc_po_config)
 * @author auto bin.yin 2019.02.21
 */
public class DcPoConfig extends AbstractEntity {
	private static final long serialVersionUID = 1550729196919L;

	private String tenantId; //租户ID
	private String tableNo; //表号
	private String enact; //制定机关
	private String approve; //批准机关
	private String approveNo; //批准文号
	private String validityTime; //有效期至

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getTableNo() {
		return this.tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	public String getEnact() {
		return this.enact;
	}
	public void setEnact(String enact) {
		this.enact = enact;
	}
	public String getApprove() {
		return this.approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	public String getApproveNo() {
		return this.approveNo;
	}
	public void setApproveNo(String approveNo) {
		this.approveNo = approveNo;
	}
	public String getValidityTime() {
		return this.validityTime;
	}
	public void setValidityTime(String validityTime) {
		this.validityTime = validityTime;
	}
	
}