package com.tjcloud.face.base.dao.impl;

import com.tjcloud.data.mybatis.dao.impl.AbstractIBatisDaoImpl;
import com.tjcloud.face.base.dao.FaceCameraDao;
import com.tjcloud.face.base.entity.FaceCamera;
import org.springframework.stereotype.Repository;

@Repository("faceCameraDao")
public class FaceCameraDaoImpl extends AbstractIBatisDaoImpl<FaceCamera, String> implements FaceCameraDao {

}
