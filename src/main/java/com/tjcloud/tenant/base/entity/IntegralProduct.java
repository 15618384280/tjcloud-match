package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 积分商品(integral_product)
 * @author auto bin.yin 2019.02.23
 */
public class IntegralProduct extends AbstractEntity {
	private static final long serialVersionUID = 1550912297328L;

	private String tenantId;	//0-运动合肥 1-我要运动 2-运动厦门
	private String productName; //商品名
	private String productDes; //商品描述
	private String productMainImg; // 商品主图 
	private Integer productType; //商品类型0-优惠券 1-运动豆 2-实物
	private String voucherTplId; //优惠券id
	private Long startTime; //兑换开始时间
	private Long endTime; //兑换结束时间
	private Long integral; //消耗积分
	private Long productPrice; //获得运动豆数
	private Boolean isLimitTimes; //是否限制兑换次数
	private Boolean isCycle; //是否周期性
	private Integer cycleType; //周期类型0-天1-周2-月3-年
	private Integer limitTimes; //限制兑换次数
	private Boolean exchangeable; //是否可兑换
	private Boolean isLimitTime; //是否限制兑换时间
	private String beginTime; //兑换开始时间 HH:mm
	private String overTime; //兑换结束时间 HH:mm
	private Long totalCount; //总数
	private Long leftCount;  //剩余数
	private Boolean online; //上下线
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Boolean getIsCycle() {
		return isCycle;
	}
	public void setIsCycle(Boolean isCycle) {
		this.isCycle = isCycle;
	}
	public Integer getCycleType() {
		return cycleType;
	}
	public void setCycleType(Integer cycleType) {
		this.cycleType = cycleType;
	}
	public Long getLeftCount() {
		return leftCount;
	}
	public void setLeftCount(Long leftCount) {
		this.leftCount = leftCount;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}
	public String getProductMainImg() {
		return productMainImg;
	}
	public void setProductMainImg(String productMainImg) {
		this.productMainImg = productMainImg;
	}
	public String getStartTimeText() {
		if(this.startTime != null) {
			return DateUtils.toString(this.startTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	public String getEndTimeText() {
		if(this.endTime != null) {
			return DateUtils.toString(this.endTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDes() {
		return this.productDes;
	}
	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}
	public Integer getProductType() {
		return this.productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public String getVoucherTplId() {
		return this.voucherTplId;
	}
	public void setVoucherTplId(String voucherTplId) {
		this.voucherTplId = voucherTplId;
	}
	public Long getStartTime() {
		return this.startTime;
	}
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}
	public Long getEndTime() {
		return this.endTime;
	}
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Long getProductPrice() {
		return this.productPrice;
	}
	public void setProductPrice(Long productPrice) {
		this.productPrice = productPrice;
	}
	public Boolean getIsLimitTimes() {
		return this.isLimitTimes;
	}
	public void setIsLimitTimes(Boolean isLimitTimes) {
		this.isLimitTimes = isLimitTimes;
	}
	public Integer getLimitTimes() {
		return this.limitTimes;
	}
	public void setLimitTimes(Integer limitTimes) {
		this.limitTimes = limitTimes;
	}
	public Boolean getExchangeable() {
		return this.exchangeable;
	}
	public void setExchangeable(Boolean exchangeable) {
		this.exchangeable = exchangeable;
	}
	public Boolean getIsLimitTime() {
		return this.isLimitTime;
	}
	public void setIsLimitTime(Boolean isLimitTime) {
		this.isLimitTime = isLimitTime;
	}
	public String getBeginTime() {
		return this.beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getOverTime() {
		return this.overTime;
	}
	public void setOverTime(String overTime) {
		this.overTime = overTime;
	}
	public Boolean getOnline() {
		return this.online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
}