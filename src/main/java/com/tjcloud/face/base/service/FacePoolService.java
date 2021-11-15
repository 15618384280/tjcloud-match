package com.tjcloud.face.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.face.base.entity.FacePool;

/**
 * 人脸库信息表(face_pool)
 * @author auto bin.yin 2018.10.17
 */
public interface FacePoolService extends AbstractService<FacePool, String>{
	/**
	 * 获取百度FaceConst
	 * @return
	 */
	String getAccessToken(String poolId);
}
