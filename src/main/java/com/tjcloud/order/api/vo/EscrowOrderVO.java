package com.tjcloud.order.api.vo;

/**
 * 对接第三方的订单
 * @author Administrator
 *
 */
public class EscrowOrderVO extends OrderVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -995542316977380100L;
	
	private String escrowOrderNo;
	private Integer escrowType;
	private String validateCode;

	public String getEscrowOrderNo() {
		return escrowOrderNo;
	}
	public void setEscrowOrderNo(String escrowOrderNo) {
		this.escrowOrderNo = escrowOrderNo;
	}
	public Integer getEscrowType() {
		return escrowType;
	}
	public void setEscrowType(Integer escrowType) {
		this.escrowType = escrowType;
	}
	public String getValidateCode() {
		return validateCode;
	}
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
	
}
