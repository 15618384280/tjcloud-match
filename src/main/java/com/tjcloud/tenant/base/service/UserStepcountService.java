package com.tjcloud.tenant.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.tenant.base.entity.UserStepcount;

import java.util.List;

/**
 * 用户步数计数(user_stepcount)
 * @author auto bin.yin 2019.04.11
 */
public interface UserStepcountService extends AbstractService<UserStepcount, String> {
	
	UserStepcount findByUserIdAndDate(String userId, String date);

	List<UserStepcount> findByUserIdAndTime(String userId, Long gameTime, Long gameEndTime);
}
