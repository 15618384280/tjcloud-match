package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.pubsport.enums.AuditState;
import com.tjcloud.pubsport.enums.DcpoType;

/**
 * 调查主表(dc_place_opinionaire)
 * @author auto bin.yin 2019.02.20
 */
public class DcPlaceOpinionaire extends AbstractEntity {
	private static final long serialVersionUID = 1550639073603L;

	private String tenantId; //租户ID
	private String tableNo; //表号
	private String enact; //制定机关
	private String approve; //批准机关
	private String approveNo; //批准文号
	private String validityTime; //有效期至
	private String submitDate; //报出日期
	private String auditId; //审核人ID
	private String auditName; //审核人名字
	private String claimsmanId; //调查员ID
	private String claimsman; //调查员
	private Integer poYear; //调查年份
	private String objectId; //如果type=0-单位调查表，则调查单位ID。如果如果type=1-场地调查表，则场地ID
	private Integer type; //调查类型（0-单位调查表，1-场地调查表）
	private String typeName; //调查表类型名称
	private String typeNameCode; //调查表类型名称Code
	private Integer state; //审批状态（0-暂存,1-待审核，2-已驳回，3-一级审核通过, 4-二级审核通过）
	private Boolean print; //是否打印（0-未打印,1-已打印）
	private Integer printCount; //打印次数

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
	public String getSubmitDate() {
		return this.submitDate;
	}
	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
	public String getAuditId() {
		return this.auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getAuditName() {
		return this.auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public String getClaimsmanId() {
		return this.claimsmanId;
	}
	public void setClaimsmanId(String claimsmanId) {
		this.claimsmanId = claimsmanId;
	}
	public String getClaimsman() {
		return this.claimsman;
	}
	public void setClaimsman(String claimsman) {
		this.claimsman = claimsman;
	}
	public Integer getPoYear() {
		return this.poYear;
	}
	public void setPoYear(Integer poYear) {
		this.poYear = poYear;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getTypeNameCode() {
		return typeNameCode;
	}
	public void setTypeNameCode(String typeNameCode) {
		this.typeNameCode = typeNameCode;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getStateText() {
		return (this.state !=null) ? AuditState.getText(this.state) : "";
	}
	public String getTypeText() {
		return (this.type !=null) ? DcpoType.getText(this.type) : "";
	}
	public Boolean getPrint() {
		return print;
	}
	public void setPrint(Boolean print) {
		this.print = print;
	}
	public Integer getPrintCount() {
		return printCount;
	}
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	
}