package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.order.api.enums.MemberCardSalesType;

/**
 * 会员卡-充续卡明细表(order_card_sales_detail)
 * 
 * @author auto bin.yin 2018.12.21
 */
public class OrderCardSalesDetail extends AbstractEntity {
	private static final long serialVersionUID = 1545370618684L;

	private String tenantId; // 租户ID
	private String memberCardId; // 会员卡ID
	private String stadiumId; // 场馆ID
	private String orderId; // 订单ID
	private String orderNo; // 订单号
	private String cardCategoryId; // 会员卡类型Id
	private String cardCategoryName; // 会员卡类型名称
	private Integer cardType; // 卡类型,1-充值卡,2-次卡,3-主从卡
	private String cardTypeName; // 卡类型名字：1-充值卡,2-次卡,3-主从卡，4-时间卡
	private String cardNo; // 卡号
	private String userName; // 会员姓名
	private String phone; // 手机号
	private String idCard; // 身份证
	private Integer balance; // 余额,当为从卡时余额一直是0
	private Integer beforBalance; // 上一次结余
	private Integer times; // 剩余次数,当卡类型为次卡时有值
	private Integer otherFee; // 工本费：当办卡时有值
	private Integer salesType; // 充续卡类型：1-办卡；2-充值；3-续卡；
	private String salesTypeName; // 充续卡类型名称：1-办卡；2-充值；3-续卡；
	private Integer feeType; // 款项类型：1-充值、2-消费、3-工本费、4-补卡手续费、5-封卡手续费、6-续卡费、7-时间卡收款费
	private String feeTypeName; // 款项类型名称：1-充值、2-消费、3-工本费、4-补卡手续费、5-封卡手续费、6-续卡费、7-时间卡收款费
	private Integer payType; // 付款方式：0-其他1-现金 2-银行卡 3-微信 4-支付宝 5-支票 6-团购劵 7-代金劵
								// 8-会员卡 9-会员卡按天扣除
	private Long salesTime; // 订单时间
	private Integer salesFrequency; // 充续次数,当卡类型为次卡时有值
	private Long salesAmount; // 充续金额,单位分
	private Long discountAmount; // 折扣金额
	private Long actualAmount; // 实付金额,单位分
	private String valBeginTime; // 有效期开始时间
	private String valEndTime; // 有效期截止时间
	private String remark; // 备注信息
	private String userRemark; // 用户备注信息
	private String consultant; // 会计顾问
	private String contractNo; // 合同号
	private String sellType; // 销售类型
	private String coach; // 教练
	private String memberCardJson;	//会员卡对象：Json存储

	public void filling(Order order) {
		this.tenantId = order.getTenantId();
		this.orderId = order.getId();
		this.orderNo = order.getOrderNo();
		this.payType = order.getOrderPayType();
		this.salesTime = order.getOrderTime();
		this.salesAmount = order.getOrderAmount();
		this.actualAmount = order.getActualAmount();
		this.discountAmount = order.getTenantDisAmount() + order.getPlatformDisAmount();
		this.remark = order.getRemark();
	}

	public void filling(String memberCardId, String cardCategoryId, String cardCategoryName, Integer cardType,
			String cardTypeName, String cardNo, String userName, String phone, String idCard, Integer balance,
			Integer beforBalance, Integer times, String valBeginTime, String valEndTime) {
		this.memberCardId = memberCardId; // 会员卡ID
		this.cardCategoryId = cardCategoryId; // 会员卡类型Id
		this.cardCategoryName = cardCategoryName; // 会员卡类型名称
		this.cardType = cardType; // 卡类型,冗余字段,1-充值卡,2-次卡,3-主从卡
		this.cardTypeName = cardTypeName;
		this.cardNo = cardNo; // 卡号
		this.userName = userName; // 会员姓名
		this.phone = phone; // 手机号
		this.idCard = idCard; // 身份证
		this.balance = balance; // 余额,当为从卡时余额一直是0
		this.beforBalance = beforBalance; // 上一次结余
		this.times = times; // 剩余次数,当卡类型为次卡时有值
		this.valBeginTime = valBeginTime; // 有效期开始时间
		this.valEndTime = valEndTime; // 有效期截止时间
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getMemberCardId() {
		return this.memberCardId;
	}

	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getCardCategoryId() {
		return this.cardCategoryId;
	}

	public void setCardCategoryId(String cardCategoryId) {
		this.cardCategoryId = cardCategoryId;
	}

	public String getCardCategoryName() {
		return this.cardCategoryName;
	}

	public void setCardCategoryName(String cardCategoryName) {
		this.cardCategoryName = cardCategoryName;
	}

	public Integer getCardType() {
		return this.cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return this.cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getBeforBalance() {
		return this.beforBalance;
	}

	public void setBeforBalance(Integer beforBalance) {
		this.beforBalance = beforBalance;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getOtherFee() {
		return this.otherFee;
	}

	public void setOtherFee(Integer otherFee) {
		this.otherFee = otherFee;
	}

	public Integer getSalesType() {
		return this.salesType;
	}

	public void setSalesType(Integer salesType) {
		this.salesType = salesType;

		if (this.salesType != null) {
			this.salesTypeName = MemberCardSalesType.getText(this.salesType); 
		}
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Long getSalesTime() {
		return this.salesTime;
	}

	public void setSalesTime(Long salesTime) {
		this.salesTime = salesTime;
	}

	public Integer getSalesFrequency() {
		return this.salesFrequency;
	}

	public void setSalesFrequency(Integer salesFrequency) {
		this.salesFrequency = salesFrequency;
	}

	public Long getSalesAmount() {
		return this.salesAmount;
	}

	public void setSalesAmount(Long salesAmount) {
		this.salesAmount = salesAmount;
	}

	public Long getDiscountAmount() {
		return this.discountAmount;
	}

	public void setDiscountAmount(Long discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Long getActualAmount() {
		return this.actualAmount;
	}

	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}

	public String getValBeginTime() {
		return this.valBeginTime;
	}

	public void setValBeginTime(String valBeginTime) {
		this.valBeginTime = valBeginTime;
	}

	public String getValEndTime() {
		return this.valEndTime;
	}

	public void setValEndTime(String valEndTime) {
		this.valEndTime = valEndTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getConsultant() {
		return this.consultant;
	}

	public void setConsultant(String consultant) {
		this.consultant = consultant;
	}

	public String getContractNo() {
		return this.contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public String getSellType() {
		return this.sellType;
	}

	public void setSellType(String sellType) {
		this.sellType = sellType;
	}

	public String getCoach() {
		return this.coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public Integer getFeeType() {
		return feeType;
	}

	public void setFeeType(Integer feeType) {
		this.feeType = feeType;
	}

	public String getFeeTypeName() {
		return feeTypeName;
	}

	public void setFeeTypeName(String feeTypeName) {
		this.feeTypeName = feeTypeName;
	}

	public String getCardTypeName() {
		return cardTypeName;
	}

	public void setCardTypeName(String cardTypeName) {
		this.cardTypeName = cardTypeName;
	}
	public String getMemberCardJson() {
		return memberCardJson;
	}

	public void setMemberCardJson(String memberCardJson) {
		this.memberCardJson = memberCardJson;
	}
	public String getSalesTypeName() {
		return salesTypeName;
	}

	public void setSalesTypeName(String salesTypeName) {
		this.salesTypeName = salesTypeName;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	public String getSalesTypeText() {
		if (this.salesType == null) {
			return "";
		}
		return MemberCardSalesType.getText(this.salesType);
	}
	
	public String getSalesTimeText(){
		return DateUtils.toString(this.salesTime);
	}
	
	public String getSalesTimeFullText(){
		return DateUtils.toFullString(this.salesTime);
	}
	
	public Integer getBalanceOrTimes(){
		if(this.cardType == null){
			return 0;
		}
		if(this.cardType.intValue() == 2){
			return this.times;
		}
		return this.balance;
	}
}