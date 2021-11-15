package com.tjcloud.order.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 交易表(transaction)
 * @author auto bin.yin 2016.07.25
 */
@LogRequired
public class Transaction extends AbstractEntity {
	private static final long serialVersionUID = 1469426629519L;

	private String transactionNo; 										//交易号
	private String objectId; 											//保存订单Id和退订表Id
	private Integer transactionType; 									//1-收入，2-支出
	private Integer paymentType; 										//支付方式：运动豆、场馆卡、次卡、支付宝、微信支付
	private Integer payRelation; 										//交易类型，对公对私 1-B2P | 2-P2B | 3-B2B | 4-P2P，Business to personnel 
	private String payee; 												//收款方，对应商户id，平台是1
	private String Payer; 												//付款方，userId,tenantId
	private Long transactionTime; 										//交易日期
	private Long paymentTime; 											//申请支付日期
	private Long resultTime; 											//返回结果日期
	private Long amount; 												//金额
	private Integer transactionStatus; //交易状态,1-交易中|2-交易成功|3-交易失败|8-交易超时|9-交易作废(场景用户点击付款后取消，然后15分钟后订单自动取消，这时需要作废交易，并且MQ异步给支付平台发送取消交易)
	private String errorLog; //记录交易异常原因
	private String transactionId; 										// 微信方支付交易单号

	public String getTransactionNo() {
		return this.transactionNo;
	}
	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public Integer getTransactionType() {
		return this.transactionType;
	}
	public void setTransactionType(Integer transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getPaymentType() {
		return this.paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getPayRelation() {
		return this.payRelation;
	}
	public void setPayRelation(Integer payRelation) {
		this.payRelation = payRelation;
	}

	public String getPayee() {
		return this.payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayer() {
		return this.Payer;
	}
	public void setPayer(String Payer) {
		this.Payer = Payer;
	}

	public Long getTransactionTime() {
		return this.transactionTime;
	}
	public void setTransactionTime(Long transactionTime) {
		this.transactionTime = transactionTime;
	}

	public Long getPaymentTime() {
		return this.paymentTime;
	}
	public void setPaymentTime(Long paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Long getResultTime() {
		return this.resultTime;
	}
	public void setResultTime(Long resultTime) {
		this.resultTime = resultTime;
	}

	public Long getAmount() {
		return this.amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Integer getTransactionStatus() {
		return this.transactionStatus;
	}
	public void setTransactionStatus(Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getErrorLog() {
		return this.errorLog;
	}
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
}