package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 协会会员表(member_house_sign)
 * @author cuike 2019.04.25
 */

public class MemberHouseSign extends AbstractEntity {

	private static final long serialVersionUID = -5903984385895663770L;
	private String tenantId; //租户ID
	private String memberHouseId; //协会ID
	private String userId; //用户ID
	private String name; //会员姓名
	private Integer sex; //性别（0：男 1：女）
	private String phone; //联系电话
	private String idCard; //身份证号
	private Integer state; //审核状态（0-待审核，1-审核通过，2-驳回）
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getMemberHouseId() {
		return memberHouseId;
	}
	public void setMemberHouseId(String memberHouseId) {
		this.memberHouseId = memberHouseId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
}
