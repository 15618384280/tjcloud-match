package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.FieldHoldonRuleVO;

/**
 * 场地挂起规则(field_holdon_rule)
 * @author auto bin.yin 2016.07.22
 */
@LogRequired
public class FieldHoldonRule extends AbstractEntity {
	private static final long serialVersionUID = 1469171900013L;

	private String tenantId; //租户Id
	private String stadiumId; //场馆Id
	private String stadiumItemId; //项目Id
	private Integer reasonType; //挂起原因
	private String remark; //挂起原因说明
	
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Integer getReasonType() {
		return this.reasonType;
	}
	public void setReasonType(Integer reasonType) {
		this.reasonType = reasonType;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public FieldHoldonRule() {
		super();
	}
	public FieldHoldonRule(FieldHoldonRuleVO fieldHoldonRuleVO) {
		setTenantId(fieldHoldonRuleVO.getTenantId());
		setStadiumId(fieldHoldonRuleVO.getStadiumId());
		setStadiumItemId(fieldHoldonRuleVO.getStadiumItemId());
		setReasonType(fieldHoldonRuleVO.getReasonType());
		setRemark(fieldHoldonRuleVO.getRemark());
	}
	
	
}