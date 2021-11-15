package com.tjcloud.tenant.base.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tjcloud.core.utils.DateUtils;
import org.springframework.stereotype.Service;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.tenant.base.dao.UserStepcountDao;
import com.tjcloud.tenant.base.entity.UserStepcount;

@Service("userStepcountService")
public class UserStepcountServiceImpl extends AbstractIbatisServiceImpl<UserStepcountDao, UserStepcount, String> implements UserStepcountService {

	@Override
	public UserStepcount findByUserIdAndDate(String userId, String date) {
		Map<String, Object> params = new HashMap<String,Object>(2); 
		params.put("userId", userId);
		params.put("reportDate", date);
		return findOne(params);
	}

	@Override
	public List<UserStepcount> findByUserIdAndTime(String userId, Long gameTime, Long gameEndTime) {
		Map<String, Object> params = new HashMap<String,Object>(2);
		params.put("userId", userId);
		params.put("reportBeginDate", DateUtils.formatJustDate(gameTime));
		params.put("reportEndDate", DateUtils.formatJustDate(gameEndTime));
		return findBy(params);
	}

}
