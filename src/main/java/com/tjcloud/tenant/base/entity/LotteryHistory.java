package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 抽奖记录(lottery_history)
 * @author auto bin.yin 2018.07.26
 */
public class LotteryHistory extends AbstractEntity {
	private static final long serialVersionUID = 1532590515943L;

	private String tenantId; //租户ID
	private String lotteryId; //抽奖活动ID
	private String formId; //表单ID
	private String userId; //用户ID
	private String userName; //用户名
	private String userPhone; //用户手机号码
	private String openid; //微信用户ID
	private String prizeId; //奖品ID
	private Integer prizeType; //奖品类型
	private String prizeName; //奖品名称
	private String prizeImage; //奖品图片
	private Integer prizeIndex; //奖品等级
	private Integer counts; //次数
	private Boolean confirmed; //是否已确认
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
	public Integer getPrizeType() {
		return this.prizeType;
	}
	public void setPrizeType(Integer prizeType) {
		this.prizeType = prizeType;
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
	public Integer getCounts() {
		return this.counts;
	}
	public void setCounts(Integer counts) {
		this.counts = counts;
	}
	public Boolean getConfirmed() {
		return this.confirmed;
	}
	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}
	public String getIp() {
		return this.ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}