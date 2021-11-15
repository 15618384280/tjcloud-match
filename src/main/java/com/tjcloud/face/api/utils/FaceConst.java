package com.tjcloud.face.api.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.data.redis.service.RedisCache;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.entity.FacePool;
import com.tjcloud.face.base.service.FaceGroupService;
import com.tjcloud.face.base.service.FacePoolService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Map;


@Component("faceConst")
public class FaceConst {
	
	@Autowired
	private FaceJsoup faceJsoup;
	@Autowired
	private RedisCache redisCache;
	@Autowired
	private FacePoolService facePoolService;
	@Autowired
	private FaceGroupService faceGroupService;
	
	private static final Logger logger = LoggerFactory.getLogger(FaceConst.class);

	private JSONObject getAccessTokenObject(String poolId){
		try {
			FacePool facePool = facePoolService.get(poolId);
			if(facePool == null){
				FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(poolId);
				facePool = facePoolService.get(faceGroup.getPoolId());
			}
			String accessToken = redisCache.get(FaceConfigUrl.BAIDUBCE_API_ACCESS_TOKEN_KEY + facePool.getAppId());
			if(StringUtils.isEmpty(accessToken)){
				Map<String, String> params = Maps.newHashMap();
				params.put("clientId", facePool.getApiKey());
				params.put("clientSecret", facePool.getSecretKey());
				accessToken = faceJsoup.doGet(FaceConfigUrl.GET_ACCESS_TOKEN, params);
				logger.debug("获取Access Token: {}", accessToken);
				JSONObject token = JSONObject.parseObject(accessToken, JSONObject.class);
				BigDecimal expires_in = new BigDecimal(token.getString("expires_in")).subtract(new BigDecimal(600));
				redisCache.set(FaceConfigUrl.BAIDUBCE_API_ACCESS_TOKEN_KEY +facePool.getAppId(), accessToken, expires_in.longValue());
			}
			return JSONObject.parseObject(accessToken, JSONObject.class);
		} catch (Exception e) {
			return new JSONObject();
		}
	}
	
	public String getAccessToken(String poolId){
		return getAccessTokenObject(poolId).getString(FaceConfigUrl.ACCESS_TOKEN_KEY);
	}
}
