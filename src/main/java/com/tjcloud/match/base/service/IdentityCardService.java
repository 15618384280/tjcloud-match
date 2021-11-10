package com.tjcloud.match.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.match.base.entity.IdentityCard;

/**
 * 身份证信息库(identity_card)
 * @author auto bin.yin 2019.01.14
 */
public interface IdentityCardService extends AbstractService<IdentityCard, String> {
	/**
	 * 验证身份证
	 * @param cardNo
	 * @param realName
	 * @return
	 */
	IdentityCard verifyIdcardv(String cardNo, String realName);
}
