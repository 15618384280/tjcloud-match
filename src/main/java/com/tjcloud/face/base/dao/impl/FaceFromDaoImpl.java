package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceFromDao;
import com.tjcloud.face.base.entity.FaceFrom;
import org.springframework.stereotype.Repository;

@Repository("faceFromDao")
public class FaceFromDaoImpl extends AbstractIBatisDaoImpl<FaceFrom, String> implements FaceFromDao {

}
