package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceInfoDao;
import com.tjcloud.face.base.entity.FaceInfo;
import org.springframework.stereotype.Repository;

@Repository("faceInfoDao")
public class FaceInfoDaoImpl extends AbstractIBatisDaoImpl<FaceInfo, String> implements FaceInfoDao {

}
