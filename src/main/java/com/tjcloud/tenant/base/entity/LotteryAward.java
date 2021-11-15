package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 获奖人员(lottery_award)
 * @author auto bin.yin 2018.07.26
 */
public class LotteryAward extends AbstractEntity {
	private static final long serialVersionUID = 1532590515754L;

	private String tenantId; //租户ID
	private String lotteryId; //抽奖活动ID
	private String code; //获奖码
	private String formId; //表单ID
	private String userId; //用户ID
	private String userName; //用户名
	private String userPhone; //用户手机号码
	private String openid; //微信用户ID
	private String prizeId; //奖品ID
	private String prizeName; //奖品名称
	private String prizeImage; //奖品图片
	private Integer prizeIndex; //奖品等级
	private Integer prizeStatus; //状态(0.未领奖,1.已领奖,2.已过期)
	private String ip; //IP地址

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getLotteryId() {
		return this.lotteryId;
	}
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFormId() {
		return this.formId;
	}
	public void setFormId(String formId) {
		this.formId = formId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return this.userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getOpenid() {
		return this.openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getPrizeId() {
		return this.prizeId;
	}
	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}
	public String getPrizeName() {
		return this.prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}
	public String getPrizeImage() {
		return this.prizeImage;
	}
	public void setPrizeImage(String prizeImage) {
		this.prizeImage = prizeImage;
	}
	public Integer getPrizeIndex() {
		return this.prizeIndex;
	}
	public void setPrizeIndex(Integer prizeIndex) {
		this.prizeIndex = prizeIndex;
	}
	public Integer getPrizeStatus() {
		return this.prizeStatus;
	}
	public void setPrizeStatus(Integer prizeStatus) {
		this.prizeStatus = prizeStatus;
	}
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}