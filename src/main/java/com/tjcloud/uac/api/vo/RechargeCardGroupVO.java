package com.tjcloud.uac.api.vo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.uac.base.entity.RechargeCardGroup;

/**
 * 
 * @author Administrator
 *
 */
public class RechargeCardGroupVO implements Serializable {
	private static final long serialVersionUID = 1471333865415L;
	
	private String id;//票券主键id
	private String type; //类型
	private String startTime; //有效开始时间
	private String endTime; //有效结束时间
	private Integer perAmount; //金额,单位分
	private String remark; //备注
	private Integer number; //数量
	private String saleTarget; //销售对象
	private Integer totalAmount; //总金额,单位分
	private boolean disabled; //删除标记

	public RechargeCardGroupVO(RechargeCardGroup rechargeCardGroup) {
		BeanUtils.copyProperties(rechargeCardGroup, this);
		this.setStartTime(DateUtils.toString(rechargeCardGroup.getStartTime()));
		this.setEndTime(DateUtils.toString(rechargeCardGroup.getEndTime()));
	}
	
	public RechargeCardGroupVO() {
	}

	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return this.startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return this.endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getPerAmount() {
		return this.perAmount;
	}
	public void setPerAmount(Integer perAmount) {
		this.perAmount = perAmount;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getNumber() {
		return this.number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getSaleTarget() {
		return this.saleTarget;
	}
	public void setSaleTarget(String saleTarget) {
		this.saleTarget = saleTarget;
	}

	public Integer getTotalAmount() {
		return this.totalAmount;
	}
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public boolean isDisabled() {
		return this.disabled;
	}
	public void setDisabled(boolean b) {
		this.disabled = b;
	}
}