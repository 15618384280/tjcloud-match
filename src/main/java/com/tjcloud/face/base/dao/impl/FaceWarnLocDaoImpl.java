package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceWarnLocDao;
import com.tjcloud.face.base.entity.FaceWarnLoc;
import org.springframework.stereotype.Repository;

@Repository("faceWarnLocDao")
public class FaceWarnLocDaoImpl extends AbstractIBatisDaoImpl<FaceWarnLoc, String> implements FaceWarnLocDao {

}
