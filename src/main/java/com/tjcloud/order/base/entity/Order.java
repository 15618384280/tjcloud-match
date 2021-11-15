package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.order.api.enums.OrderChannel;

/**
 * 订单总表(order)
 * @author auto bin.yin 2016.08.27
 */
@LogRequired
public class Order extends AbstractEntity {
	private static final long serialVersionUID = 1472288924502L;

	private String orderNo; 			//订单编号,内外部系统订单要标示，生成格式，可以参考https://www.zhihu.com/question/19805896/answer/16517990
	private Integer orderType; 			//订单类型: 1-WEB、2-租户后台、3-大众点评、4-口碑、5-IOS、6-Android，7-上海银行，8-微信，9-宝山羽协，10-手机，11-其他,12-V2网页，13-携程，14-糯米，15、平台管理员，16、微信小程序，17、扫码支付
	private String userId; 				//用户ID
	private String userName;			//用户姓名
	private String phone; 				//联系电话
	private String tenantId; 			//租户ID
	private Long orderAmount; 			//订单金额,单位分,订单金额=sum(订单明细)
	private Long actualAmount; 			//实付金额,单位分,初始化时为订单金额-红包总金额,实付金额在支付完成后，再也不会发生变化
	private Long tenantDisAmount; 		//租户优惠金额
	private Long platformDisAmount; 	//平台优惠金额
	private Long cashPledge; 			//押金
	private Boolean useCoupon;			//是否使用红包
	private String couponId; 			//红包ID
	private Long couponAmount; 			//红包金额
	private Long couponReturnAmount; 	//退回红包金额
	private Long refundTotalAmount; 	//退款总金额
	private Integer orderAttr;			//订单归属:1-要运动、2-租户
	private Integer channel; 			//订单来源:1-平台、2-商户自有、3-大众点评、4-口碑、5-IOS、6-Android
	private Long orderTime; 			//创建订单时间
	private Long paymentTime; 			//支付时间，冗余字段可在交易表查找到
	private Integer orderStatus; 		//0-预定失败,1-待处理,2-待支付,3-已支付,4-已关闭,5-部分退款,6-全额退款
	private Integer orderPayType;		//付款方式：1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵 8-会员卡
	private String remark; 				//用户填写的备注
	private String failInfo; 			//下单失败原因
	private Integer serviceFee;			//服务费
	private Integer orderSource;		//场馆来源 0-platform 1-ctrip携程

	private Integer cnt;
	private Integer invoiceStatus;		// 0-不可开票 1-待申请 2-开票中 3-已开票
	private Integer commented;			// 0-未评论 1-已评价 2-可评价
	private Boolean profitSharing;		// 分账订单标志 false-不分账 true-分账
	private Long verificationTime;      // 核销时间
	private String verificationPerson;  // 核销人
	private Integer verificationType;   // 核销方式   1-场馆扫码核销，2-平台客服核销，3-到时间系统核销
	private Boolean verificationStatus;  // 核销状态   0-未核销 1-已核销
	private String escrowOrderNo;       //第三方订单号

	public String getEscrowOrderNo() {
		return escrowOrderNo;
	}

	public void setEscrowOrderNo(String escrowOrderNo) {
		this.escrowOrderNo = escrowOrderNo;
	}

	public Integer getVerificationType() {
		return verificationType;
	}

	public void setVerificationType(Integer verificationType) {
		this.verificationType = verificationType;
	}

	public Boolean getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(Boolean verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public Long getVerificationTime() {
		return verificationTime;
	}

	public void setVerificationTime(Long verificationTime) {
		this.verificationTime = verificationTime;
	}

	public String getVerificationPerson() {
		return verificationPerson;
	}

	public void setVerificationPerson(String verificationPerson) {
		this.verificationPerson = verificationPerson;
	}

	public Boolean getUseCoupon() {
		return useCoupon;
	}
	public void setUseCoupon(Boolean useCoupon) {
		this.useCoupon = useCoupon;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public Integer getCommented() {
		return commented;
	}
	public void setCommented(Integer commented) {
		this.commented = commented;
	}
	public Integer getInvoiceStatus() {
		return invoiceStatus;
	}
	public void setInvoiceStatus(Integer invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	public Integer getOrderSource() {
		return orderSource;
	}
	public void setOrderSource(Integer orderSource) {
		this.orderSource = orderSource;
	}
	public Integer getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Integer serviceFee) {
		this.serviceFee = serviceFee;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getOrderPayType() {
		return orderPayType;
	}
	public void setOrderPayType(Integer orderPayType) {
		this.orderPayType = orderPayType;
	}
	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderType() {
		return this.orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public Long getOrderAmount() {
		return this.orderAmount;
	}
	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Long getActualAmount() {
		return this.actualAmount;
	}
	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}

	public Long getTenantDisAmount() {
		if(this.tenantDisAmount == null){
			return 0L;
		}
		return this.tenantDisAmount;
	}
	public void setTenantDisAmount(Long tenantDisAmount) {
		this.tenantDisAmount = tenantDisAmount;
	}

	public Long getPlatformDisAmount() {
		if(this.platformDisAmount == null){
			return 0L;
		}
		return this.platformDisAmount;
	}
	public void setPlatformDisAmount(Long platformDisAmount) {
		this.platformDisAmount = platformDisAmount;
	}
	
	public Long getCashPledge() {
		if(cashPledge == null){
			return 0L;
		}
		return cashPledge;
	}
	public void setCashPledge(Long cashPledge) {
		this.cashPledge = cashPledge;
	}
	public Long getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(Long couponAmount) {
		this.couponAmount = couponAmount;
	}
	
	public Long getCouponReturnAmount() {
		return this.couponReturnAmount;
	}
	public void setCouponReturnAmount(Long couponReturnAmount) {
		this.couponReturnAmount = couponReturnAmount;
	}

	public Long getRefundTotalAmount() {
		return this.refundTotalAmount;
	}
	public void setRefundTotalAmount(Long refundTotalAmount) {
		this.refundTotalAmount = refundTotalAmount;
	}

	public Integer getOrderAttr() {
		return orderAttr;
	}
	public void setOrderAttr(Integer orderAttr) {
		this.orderAttr = orderAttr;
	}

	public String getChannelText() {
		return OrderChannel.getText(getChannel());
	}
	public Integer getChannel() {
		return this.channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public Long getOrderTime() {
		return this.orderTime;
	}
	public void setOrderTime(Long orderTime) {
		this.orderTime = orderTime;
	}

	public Long getPaymentTime() {
		return this.paymentTime;
	}
	public void setPaymentTime(Long paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getRemark() {
		return this.remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getFailInfo() {
		return this.failInfo;
	}
	public void setFailInfo(String failInfo) {
		this.failInfo = failInfo;
	}

	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public Boolean getProfitSharing() {
		return profitSharing;
	}

	public void setProfitSharing(Boolean profitSharing) {
		this.profitSharing = profitSharing;
	}
}