package com.tjcloud.tenpay.api.service;

import com.tjcloud.tenpay.api.bean.mchpay.*;

public interface TXTenpayMchService {

	/**
	 * 统一下单
	 * @param unifiedorder unifiedorder
	 * @param key key
	 * @return UnifiedorderResult
	 */
	UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder);

}