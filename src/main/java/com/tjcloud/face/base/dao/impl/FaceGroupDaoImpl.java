package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceGroupDao;
import com.tjcloud.face.base.entity.FaceGroup;
import org.springframework.stereotype.Repository;

@Repository("faceGroupDao")
public class FaceGroupDaoImpl extends AbstractIBatisDaoImpl<FaceGroup, String> implements FaceGroupDao {

}
