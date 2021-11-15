package com.tjcloud.order.api.vo;

import com.tjcloud.order.base.entity.LongOrderRuleItem;
import com.tjcloud.order.base.entity.OrderDetailField;

import java.io.Serializable;
import java.util.List;

/**
 * 创建场地订单
 * @author lihongzhou
 */
public class CreateFieldOrderVO implements Serializable{

	private static final long serialVersionUID = 6190043917999913879L;

	private Integer orderPayType;		// 付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡
	private Integer orderType;			// 订单类型
	private Integer paymentType;		// 支付类型
	private String tenantId;			// 租户ID
	private String stadiumId;			// 场馆id
	private String stadiumName;			// 场馆名
	private String stadiumItemId;		// 项目id
	private String stadiumItemName;		// 项目名
	private Long actualAmount;			// 实收
	private Long tenantDisAmount;		// 优惠金额
	private String remark;				// 备注
	
	private String userId;				// 用户Id
	private String userName;			// 用户姓名
	private String phone;				// 手机号
	private String cardNo;				// 会员卡号
	
	private List<OrderDetailField> orderDetails;	//订单明细
	
	//长订字段
	private Long orderAmount;			// 订单金额
	private String memberId;			// 会员id 
	private String orderMemberName;		// 会员名
	private String memberCardId;		// 会员卡id
	private String memberCardNo;		// 会员卡号
	private String sales;				// 销售人员
	private String beginPeriod;			// 开始日期
	private String endPeriod;			// 结束日期
	private Integer unitPrice;			// 场时单价
	private Integer totalCount;			// 总场时
	private Integer longOrderType;		// 长订类型
	
	private String tokenId;				// 创建人
	
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getLongOrderType() {
		return longOrderType;
	}
	public void setLongOrderType(Integer longOrderType) {
		this.longOrderType = longOrderType;
	}
	public String getTokenId() {
		return tokenId;
	}
	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}
	private List<LongOrderRuleItem> longOrderRuleItems;	// 长订订单明细
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<LongOrderRuleItem> getLongOrderRuleItems() {
		return longOrderRuleItems;
	}
	public void setLongOrderRuleItems(List<LongOrderRuleItem> longOrderRuleItems) {
		this.longOrderRuleItems = longOrderRuleItems;
	}
	public Long getOrderAmount() {
		return orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getOrderMemberName() {
		return orderMemberName;
	}
	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}
	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	public String getMemberCardNo() {
		return memberCardNo;
	}
	public void setMemberCardNo(String memberCardNo) {
		this.memberCardNo = memberCardNo;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getBeginPeriod() {
		return beginPeriod;
	}
	public void setBeginPeriod(String beginPeriod) {
		this.beginPeriod = beginPeriod;
	}
	public String getEndPeriod() {
		return endPeriod;
	}
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}
	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}

	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public Long getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Long getTenantDisAmount() {
		return tenantDisAmount;
	}
	public void setTenantDisAmount(Long tenantDisAmount) {
		this.tenantDisAmount = tenantDisAmount;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public List<OrderDetailField> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailField> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
}
