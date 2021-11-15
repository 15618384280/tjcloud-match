package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 赛事报名团队表(subject_team)
 * @author auto bin.yin 2016.12.12
 */
public class SubjectTeam extends AbstractEntity {
	private static final long serialVersionUID = 1481527808619L;

	private String subjectId; 									//科目ID
	private String subjectName; 								//科目名称
	private String teamName; 									//团队名称
	private Integer teamSex; 									//团队性别(0-女,1-男,2-混合)
	private Integer teamNum; 									//团队人数
	private String captainName; 								//队长姓名
	private Integer sex; 										//性别（0-女,1-男,2-'）
	private String phone; 										//手机号
	private String certificateNo; 								//证件号
	private String achievement; 								//成绩
	private String orderNo;										//订单号
	private Integer payment; 									//支付状态（0-未支付,1-已支付,2-已取消,3-退款中,4-已退款,5-线下导入,6-线下支付）
	private Integer expenses; 									//报名费
	/**
	 * 支付方式：1-运动豆、2-场馆卡、3-次卡、4-支付宝、5-微信支付、6-红包支付、7-线下支付、8-租户会员卡、9-第三方支付
	 * 支付渠道
	 * @see com.tjcloud.order.api.enums.PaymentType
	 * @see com.tjcloud.match.api.enums.PaymentType
	 */
	private Integer paymentType;
	private Long paymentTime; 								    // 支付时间

	public String getSubjectId() {
		return this.subjectId;
	}
	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getTeamName() {
		return this.teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Integer getTeamSex() {
		return this.teamSex;
	}
	public void setTeamSex(Integer teamSex) {
		this.teamSex = teamSex;
	}
	public Integer getTeamNum() {
		return this.teamNum;
	}
	public void setTeamNum(Integer teamNum) {
		this.teamNum = teamNum;
	}
	public String getCaptainName() {
		return this.captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public Integer getSex() {
		return this.sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCertificateNo() {
		return this.certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getAchievement() {
		return this.achievement;
	}
	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
			this.orderNo = orderNo;
	}
	public Integer getPayment() {
		return this.payment;
	}
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
	public Integer getExpenses() {
		return expenses;
	}
	public void setExpenses(Integer expenses) {
		this.expenses = expenses;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Long getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Long paymentTime) {
		this.paymentTime = paymentTime;
	}
}