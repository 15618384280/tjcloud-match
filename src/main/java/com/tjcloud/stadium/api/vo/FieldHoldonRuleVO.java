package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.FieldHoldonRule;

/**
 * 场地挂起
 * @author lihongzhou
 */
public class FieldHoldonRuleVO implements Serializable{

	private static final long serialVersionUID = -2016094183367915218L;

	private String id;
	private String stadiumId;	// 场馆ID
	private String stadiumName; // 场馆名
	private String stadiumItemId;	// 项目ID
	private String stadiumItemName;	// 项目名
	private Integer reasonType;	// 原因
	private String remark;		// 原因备注
	private String tenantId;	// 租户ID
	
	List<FieldHoldonRuleItemVO> fieldHoldonRuleItemList; // 挂起明细
	
	public String getStadiumItemId() {
		return stadiumItemId;
	}

	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}

	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStadiumId() {
		return stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public Integer getReasonType() {
		return reasonType;
	}

	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<FieldHoldonRuleItemVO> getFieldHoldonRuleItemList() {
		return fieldHoldonRuleItemList;
	}

	public void setFieldHoldonRuleItemList(List<FieldHoldonRuleItemVO> fieldHoldonRuleItemList) {
		this.fieldHoldonRuleItemList = fieldHoldonRuleItemList;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public FieldHoldonRuleVO() {
		super();
	}
	public FieldHoldonRuleVO(FieldHoldonRule rule) {
		setId(rule.getId());
		setTenantId(rule.getTenantId());
		setStadiumId(rule.getStadiumId());
		setStadiumItemId(rule.getStadiumItemId());
		setReasonType(rule.getReasonType());
		setRemark(rule.getRemark());
	}
}
