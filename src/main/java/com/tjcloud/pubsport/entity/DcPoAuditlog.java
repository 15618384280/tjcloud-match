package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 审批记录表(dc_po_auditlog)
 * @author auto bin.yin 2019.02.20
 */
public class DcPoAuditlog extends AbstractEntity {
	private static final long serialVersionUID = 1550639073705L;

	private String tenantId; //
	private String poId; //调查表ID
	private String poStadiumId; //调查场地ID
	private String poStadiumItemId; //调查场地明细ID
	private Integer state; //审批状态（0-待审核，1-已驳回，2-审核通过）
	private String revision; //审批意见
	private String auditId; //审核人ID
	private String auditName; //审核人名字

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPoId() {
		return this.poId;
	}
	public void setPoId(String poId) {
		this.poId = poId;
	}
	public String getPoStadiumId() {
		return this.poStadiumId;
	}
	public void setPoStadiumId(String poStadiumId) {
		this.poStadiumId = poStadiumId;
	}
	public String getPoStadiumItemId() {
		return this.poStadiumItemId;
	}
	public void setPoStadiumItemId(String poStadiumItemId) {
		this.poStadiumItemId = poStadiumItemId;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRevision() {
		return this.revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	
}