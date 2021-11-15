package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆营业额统计表(stadium_operate_report)
 * @author auto bin.yin 2018.03.12
 */
public class StadiumOperateReport extends AbstractEntity {
	private static final long serialVersionUID = 1520840647405L;

	private String tenantId; //商户id
	private String stadiumId; //场馆id
	private Integer type; //统计类型0-其他 1-散客 2-网络预定 3-会员卡 4-长订 5-活动 6-商品
	private String period; //区间(Y.年,M.月,D.日,H.时)
	private Long amount; //金额
	private Long collectTime; //统计时间

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
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPeriod() {
		return this.period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getCollectTime() {
		return this.collectTime;
	}
	public void setCollectTime(Long collectTime) {
		this.collectTime = collectTime;
	}
}