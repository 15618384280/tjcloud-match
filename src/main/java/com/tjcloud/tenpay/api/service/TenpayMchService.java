package com.tjcloud.tenpay.api.service;

import com.tjcloud.tenpay.api.bean.mchpay.*;

public interface TenpayMchService {

	/**
	 * 统一下单
	 * @param unifiedorder unifiedorder
	 * @param key key
	 * @return UnifiedorderResult
	 */
	UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder);

	/**
	 * 查询订单
	 * @param mchOrderquery mchOrderquery
	 * @param key key
	 * @return MchOrderInfoResult
	 */
	MchOrderInfoResult payOrderquery(MchOrderquery mchOrderquery, String key);

}