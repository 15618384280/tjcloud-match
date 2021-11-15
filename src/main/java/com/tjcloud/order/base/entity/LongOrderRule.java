package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 注释(long_order_rule)
 * @author auto bin.yin 2016.07.20
 */
@LogRequired
public class LongOrderRule extends AbstractEntity {
	private static final long serialVersionUID = 1468999364848L;

	private String orderId; 			//订单ID
	private String orderNo;				//订单编号
	private Integer longOrderType;		//预定类型 0-普通长订 1-活动占地
	private Integer unitPrice;			//场时单价
	private Integer totalCount;			//长订总场次
	private Integer createCount;		//已生成场次
	private Integer useCount;			//已完成场次
	private Integer cancelCount;		//已取消场次
	private String beginPeriod; 		//开始周期    yyyy-mm-dd
	private String endPeriod; 			//结束日期	yyyy-mm-dd
	private String orderUserId; 		//预定用户id
	private String sales; 				//销售人员姓名
	private Long orderAmount; 			//订单金额
	private Long actualAmount; 			//实付金额
	private String stadiumName;			//场馆名称
	private String stadiumId;			//场馆ID
	private String tenantId;			//租户ID
	private String stadiumItemId;		//子场馆id
	private String stadiumItemName;		//子场馆名称
	private Integer status; 			//不用填
	private String note;				//备注
	private String memberId;			//会员id
	private String orderMemberName;		//会员名称
	private String memberCardId;		//会员卡id
	private String memberCardNo;		//会员卡号
	private Object tenant;
	private Object stadium;

	private List<LongOrderRuleItem> longOrderRuleItems;
	
	public Integer getLongOrderType() {
		return longOrderType;
	}
	public void setLongOrderType(Integer longOrderType) {
		this.longOrderType = longOrderType;
	}
	public Integer getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getMemberCardId() {
		return memberCardId;
	}
	public void setMemberCardId(String memberCardId) {
		this.memberCardId = memberCardId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberCardNo() {
		return memberCardNo;
	}
	public void setMemberCardNo(String memberCardNo) {
		this.memberCardNo = memberCardNo;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	
	public Integer getCreateCount() {
		return createCount;
	}
	public void setCreateCount(Integer createCount) {
		this.createCount = createCount;
	}
	
	public Integer getUseCount() {
		return useCount;
	}
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}
	
	public Integer getCancelCount() {
		return cancelCount;
	}
	public void setCancelCount(Integer cancelCount) {
		this.cancelCount = cancelCount;
	}
	
	public String getBeginPeriod() {
		return this.beginPeriod;
	}
	public void setBeginPeriod(String beginPeriod) {
		this.beginPeriod = beginPeriod;
	}

	public String getEndPeriod() {
		return this.endPeriod;
	}
	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getOrderUserId() {
		return this.orderUserId;
	}
	public void setOrderUserId(String orderUserId) {
		this.orderUserId = orderUserId;
	}

	public String getSales() {
		return this.sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
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

	public String getStadiumName() {
		return this.stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

	public String getStadiumId() {
		return this.stadiumId;
	}

	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<LongOrderRuleItem> getLongOrderRuleItems() {
		return this.longOrderRuleItems;
	}

	public void setLongOrderRuleItems(List<LongOrderRuleItem> longOrderRuleItems) {
		this.longOrderRuleItems = longOrderRuleItems;
	}

	public String getTenantId() {
		return this.tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getOrderMemberName() {
		return this.orderMemberName;
	}

	public void setOrderMemberName(String orderMemberName) {
		this.orderMemberName = orderMemberName;
	}

	public String getStadiumItemName() {
		return this.stadiumItemName;
	}

	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}

	public Object getTenant() {
		return this.tenant;
	}

	public void setTenant(Object tenant) {
		this.tenant = tenant;
	}

	public Object getStadium() {
		return this.stadium;
	}

	public void setStadium(Object stadium) {
		this.stadium = stadium;
	}
}