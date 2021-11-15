package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;

/**
 * 系统定义报名字段表 (sign_field_table)
 * @author auto bin.yin 2016.12.12
 */
public class SignFieldTable extends AbstractEntity {
	private static final long serialVersionUID = 1481527808678L;

	private String tenantId; 									//租户Id
	private String controlKey; 									//KEY（key不能重复）
	private String comment; 									//显示名称
	private String remarks; 									//备注
	private Integer type; 										//类型(1-文本,2-下拉框,3-日期,4-文件)
	private String html; 										//HTML
	private String value; 										//默认值（JSON格式字符串）
	private Integer state; 										//显示状态(0-不显示,1-显示,2-显示且必填)
	private Integer editable; 									//不可编辑(0-不可编辑,1-可编辑)
	private Integer sortNo; 									//排序
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	
	public String getControlKey() {
		return controlKey;
	}
	public void setControlKey(String controlKey) {
		this.controlKey = controlKey;
	}
	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
		setControlKey(SignRecordFieldUtils.convertControlKey(comment));
	}
	public String getRemarks() {
		return this.remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getHtml() {
		return this.html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getState() {
		return this.state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getEditable() {
		return this.editable;
	}
	public void setEditable(Integer editable) {
		this.editable = editable;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	
}