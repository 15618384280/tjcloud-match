package com.tjcloud.face.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.api.utils.FaceConst;
import com.tjcloud.face.base.dao.FacePoolDao;
import com.tjcloud.face.base.entity.FacePool;
import com.tjcloud.face.base.service.FacePoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("facePoolService")
public class FacePoolServiceImpl extends AbstractIbatisServiceImpl<FacePoolDao, FacePool, String> implements FacePoolService{
	@Autowired
	private FaceConst faceConst;
	
	public String getAccessToken(String poolId) {
		return faceConst.getAccessToken(poolId);
	}
}
