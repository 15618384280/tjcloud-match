package com.tjcloud.alipay.api.service;

import com.alipay.api.AlipayApiException;
import com.tjcloud.core.response.ResponseResult;

public interface AlipayTradeApiService {
	/**
	 * alipay.trade.query(根据商户订单号查询订单)
	 * @param bizContent = "{\"out_trade_no\":\"123213445324538\"}";
	 * @return
	 * @throws AlipayApiException 请处理异常
	 */
	ResponseResult queryAlipayByOrderNo(String orderNo);

	ResponseResult getRSASign(String outTradeNo, String subject, String body, String amount, String notifyUrl, String method, String returnUrl);

}
