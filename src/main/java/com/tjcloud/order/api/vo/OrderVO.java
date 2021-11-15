package com.tjcloud.order.api.vo;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.order.base.entity.*;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单VO
 * @author TJ_zhoupf
 *
 */
public class OrderVO extends Order {

	private static final long serialVersionUID = 7210423295870802173L;

	public LongOrderRule longOrderRule;										//长订场地预定主表
	public List<LongOrderRuleItem> longOrderRuleItem;						//长订场地预定订单明细订单
	public List<OrderDetailField> orderDetailField;							//场地预定订单明细订单
	public List<OrderTicket> orderTicket;									//票卷订单明细订单
	public List<OrderGoods> orderGoods;										//商品销售明细订单
	public OrderYundouRecharge orderYundouRecharge;							//运动豆充值订单明细订单
	public OrderCardRecharge orderCardRecharge;								//会员卡充值订单明细订单

	public OrderCodePay orderCodePay;										//订单
	public OrderInvoice orderInvoice;										//发票订单
	private String payActualAmount; 										//实付金额
	private List<String> orderDetailsId;									//场馆预订订单明细ID

	private JSONObject paramsPayOrder;										//订单支付传参集合
	
	private JSONObject paramsRefundOrder;									//订单退款传参集合
	private boolean checkCancelTime;										//校验可取消时间
	private boolean manageUser;												//管理用户
	private String loginUserId;										    //操作用户

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public OrderCodePay getOrderCodePay() {
		return orderCodePay;
	}
	public void setOrderCodePay(OrderCodePay orderCodePay) {
		this.orderCodePay = orderCodePay;
	}
	public OrderInvoice getOrderInvoice() {
		return orderInvoice;
	}
	public void setOrderInvoice(OrderInvoice orderInvoice) {
		this.orderInvoice = orderInvoice;
	}

	public LongOrderRule getLongOrderRule() {
		return longOrderRule;
	}

	public void setLongOrderRule(LongOrderRule longOrderRule) {
		this.longOrderRule = longOrderRule;
	}

	public List<LongOrderRuleItem> getLongOrderRuleItem() {
		return longOrderRuleItem;
	}

	public void setLongOrderRuleItem(List<LongOrderRuleItem> longOrderRuleItem) {
		this.longOrderRuleItem = longOrderRuleItem;
	}

	public List<OrderDetailField> getOrderDetailField() {
		return orderDetailField;
	}

	public void setOrderDetailField(List<OrderDetailField> orderDetailField) {
		this.orderDetailField = orderDetailField;
	}
	
	public List<OrderTicket> getOrderTicket() {
		return orderTicket;
	}

	public void setOrderTicket(List<OrderTicket> orderTicket) {
		this.orderTicket = orderTicket;
	}
	
	public List<OrderGoods> getOrderGoods() {
		return orderGoods;
	}

	public void setOrderGoods(List<OrderGoods> orderGoods) {
		this.orderGoods = orderGoods;
	}

	public OrderYundouRecharge getOrderYundouRecharge() {
		return orderYundouRecharge;
	}

	public void setOrderYundouRecharge(OrderYundouRecharge orderYundouRecharge) {
		this.orderYundouRecharge = orderYundouRecharge;
	}

	public OrderCardRecharge getOrderCardRecharge() {
		return orderCardRecharge;
	}

	public void setOrderCardRecharge(OrderCardRecharge orderCardRecharge) {
		this.orderCardRecharge = orderCardRecharge;
	}

	public List<String> getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(List<String> orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public JSONObject getParamsPayOrder() {
		return paramsPayOrder;
	}

	public void setParamsPayOrder(JSONObject paramsPayOrder) {
		this.paramsPayOrder = paramsPayOrder;
	}

	public JSONObject getParamsRefundOrder() {
		return paramsRefundOrder;
	}

	public void setParamsRefundOrder(JSONObject paramsRefundOrder) {
		this.paramsRefundOrder = paramsRefundOrder;
	}

	public boolean getCheckCancelTime() {
		return checkCancelTime;
	}

	public void setCheckCancelTime(boolean checkCancelTime) {
		this.checkCancelTime = checkCancelTime;
	}

	public boolean isManageUser() {
		return manageUser;
	}

	public void setManageUser(boolean manageUser) {
		this.manageUser = manageUser;
	}

	public String getPayActualAmount() {
		return payActualAmount;
	}

	public void setPayActualAmount(String payActualAmount) {
		this.payActualAmount = payActualAmount;
		if(!StringUtils.isEmpty(payActualAmount)){
			try {
				this.setActualAmount(new BigDecimal(100).multiply(new BigDecimal(payActualAmount)).longValue());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
