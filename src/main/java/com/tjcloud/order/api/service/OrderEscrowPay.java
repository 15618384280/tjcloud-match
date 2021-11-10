package com.tjcloud.order.api.service;

import com.tjcloud.core.exception.ServiceException;

/**
 *微信、支付宝第三方支付接口
 * @author zhoupf
 *
 */
public interface OrderEscrowPay {

	/**
	 * 退款
	 * @param outTradeNo				商户订单号
	 * @param refundNo					退款商户订单号
	 * @param refundTotalAmount			退款金额（单位：分）
	 * @param actualAmount				订单实际支付金额
	 * @param reason					退款说明（ps：订单退款）
	 * @param tradeType					微信支付方式（JSAPI：网页，NATIVE：微信，APP：移动应用，WAP：扫码支付）
	 * @return false:退款失败，true:退款成功
	 * @throws ServiceException
	 */
	boolean escrowRefund(String outTradeNo, String refundNo, String refundTotalAmount, String actualAmount, String reason) throws ServiceException;

}
