package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.Constants;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 积分兑换记录(integral_exchange_record)
 * @author auto bin.yin 2019.02.23
 */
public class IntegralExchangeRecord extends AbstractEntity {
	private static final long serialVersionUID = 1550912297515L;

	private String tenantId;
	private String userId; //用户
	private String productId; //商品id
	private String productName; //商品名
	private Integer productType; //商品类型0-优惠券 1-运动豆 2-实物
	private String voucherId;	//优惠券id
	private Long integral; //消耗积分
	private Long exchangeTime; //兑换时间
	private Integer exchangeStatus; //兑换是否成功0-兑换中 1-兑换成功 2-兑换失败
	private Integer channel;    //渠道 0-运动合肥小程序

	public String getExchangeTimeText() {
		if(this.exchangeTime != null) {
			return DateUtils.toString(this.exchangeTime, Constants.YYYY_MM_DD_HH_MM_SS);
		}
		return "";
	}
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getVoucherId() {
		return voucherId;
	}
	public void setVoucherId(String voucherId) {
		this.voucherId = voucherId;
	}
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getProductId() {
		return this.productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return this.productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductType() {
		return this.productType;
	}
	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	public Long getIntegral() {
		return this.integral;
	}
	public void setIntegral(Long integral) {
		this.integral = integral;
	}
	public Long getExchangeTime() {
		return this.exchangeTime;
	}
	public void setExchangeTime(Long exchangeTime) {
		this.exchangeTime = exchangeTime;
	}
	public Integer getExchangeStatus() {
		return this.exchangeStatus;
	}
	public void setExchangeStatus(Integer exchangeStatus) {
		this.exchangeStatus = exchangeStatus;
	}
}