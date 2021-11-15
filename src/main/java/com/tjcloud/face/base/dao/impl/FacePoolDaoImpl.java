package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FacePoolDao;
import com.tjcloud.face.base.entity.FacePool;
import org.springframework.stereotype.Repository;

@Repository("facePoolDao")
public class FacePoolDaoImpl extends AbstractIBatisDaoImpl<FacePool, String> implements FacePoolDao {

}
