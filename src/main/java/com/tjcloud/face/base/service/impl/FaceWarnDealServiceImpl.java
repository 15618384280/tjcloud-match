package com.tjcloud.face.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.base.dao.FaceWarnDealDao;
import com.tjcloud.face.base.entity.FaceWarnDeal;
import com.tjcloud.face.base.service.FaceWarnDealService;
import org.springframework.stereotype.Service;

@Service("faceWarnDealService")
public class FaceWarnDealServiceImpl extends AbstractIbatisServiceImpl<FaceWarnDealDao, FaceWarnDeal, String> implements FaceWarnDealService {
	
}
