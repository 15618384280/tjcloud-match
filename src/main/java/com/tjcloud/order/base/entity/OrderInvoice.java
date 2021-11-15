package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 发票订单(order_invoice)
 * @author auto bin.yin 2017.08.02
 */
public class OrderInvoice extends AbstractEntity {
	private static final long serialVersionUID = 1501662410893L;

	private String orderId; //订单id
	private Integer paymentStatus; //订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
	private Long invoiceAmount; //发票金额
	private Long serviceFee;	//服务费
	private Long totalInvoiceFee;//合计开票金额
	private String receiverName; //收件人
	private String receiverPhone; //电话
	private String receiverAddress; //地址
	private String receiverTitle; //公司抬头
	private Integer titleType;	//0-个人 1-公司
	private String taxpayerNo; //税号
	private boolean isChecked;	//是否已开出
	private Long checkTime;		//寄送时间
	private String fastCompany; // 快递公司
	private String fastNo;		//快递单号
	private String invoiceAddress;	//电子发票地址
	private Integer invoiceType;	//发票类型0-纸质发票 1-电子发票
	private String invoiceNote; 	// 备注
	
	public Integer getTitleType() {
		return titleType;
	}
	public void setTitleType(Integer titleType) {
		this.titleType = titleType;
	}
	public String getInvoiceNote() {
		return invoiceNote;
	}
	public void setInvoiceNote(String invoiceNote) {
		this.invoiceNote = invoiceNote;
	}
	public Integer getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
	public Long getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Long getTotalInvoiceFee() {
		return totalInvoiceFee;
	}
	public void setTotalInvoiceFee(Long totalInvoiceFee) {
		this.totalInvoiceFee = totalInvoiceFee;
	}
	public String getInvoiceAddress() {
		return invoiceAddress;
	}
	public void setInvoiceAddress(String invoiceAddress) {
		this.invoiceAddress = invoiceAddress;
	}
	public Long getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Long checkTime) {
		this.checkTime = checkTime;
	}
	public String getFastCompany() {
		return fastCompany;
	}
	public void setFastCompany(String fastCompany) {
		this.fastCompany = fastCompany;
	}
	public String getFastNo() {
		return fastNo;
	}
	public void setFastNo(String fastNo) {
		this.fastNo = fastNo;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getPaymentStatus() {
		return this.paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public Long getInvoiceAmount() {
		return this.invoiceAmount;
	}
	public void setInvoiceAmount(Long invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getReceiverName() {
		return this.receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverPhone() {
		return this.receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
	public String getReceiverAddress() {
		return this.receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public String getReceiverTitle() {
		return this.receiverTitle;
	}
	public void setReceiverTitle(String receiverTitle) {
		this.receiverTitle = receiverTitle;
	}
	public String getTaxpayerNo() {
		return this.taxpayerNo;
	}
	public void setTaxpayerNo(String taxpayerNo) {
		this.taxpayerNo = taxpayerNo;
	}
}