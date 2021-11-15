package com.tjcloud.uac.base.entity;

import org.springframework.beans.BeanUtils;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.uac.api.vo.RechargeCardGroupVO;

/**
 * 充值卡组表(uac_recharge_card_group)
 * @author auto bin.yin 2016.08.16
 */
@LogRequired
public class RechargeCardGroup extends AbstractEntity {
	private static final long serialVersionUID = 1471333865415L;

	private String type; //类型
	private Long startTime; //有效开始时间
	private Long endTime; //有效结束时间
	private Integer perAmount; //金额,单位分
	private String remark; //备注
	private Integer number; //数量
	private String saleTarget; //销售对象
	private Integer totalAmount; //总金额,单位分

	public RechargeCardGroup(RechargeCardGroupVO rechargeCardGroupVO) {
		BeanUtils.copyProperties(rechargeCardGroupVO, this);
		this.setStartTime(DateUtils.toLong(rechargeCardGroupVO.getStartTime()));
		this.setEndTime(DateUtils.toLong(rechargeCardGroupVO.getEndTime()));
	}
	public RechargeCardGroup() {
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getStartTime() {
		return startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Integer getPerAmount() {
		return this.perAmount;
	}
	public void setPerAmount(Integer perAmount) {
		this.perAmount = perAmount;
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
}