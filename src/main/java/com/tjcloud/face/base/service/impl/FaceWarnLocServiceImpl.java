package com.tjcloud.face.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.base.dao.FaceWarnLocDao;
import com.tjcloud.face.base.entity.FaceWarnLoc;
import com.tjcloud.face.base.service.FaceWarnLocService;
import org.springframework.stereotype.Service;

@Service("faceWarnLocService")
public class FaceWarnLocServiceImpl extends AbstractIbatisServiceImpl<FaceWarnLocDao, FaceWarnLoc, String> implements FaceWarnLocService {

}
