package com.tjcloud.face.base.service.impl;

import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.base.dao.FaceCameraDao;
import com.tjcloud.face.base.entity.FaceCamera;
import com.tjcloud.face.base.service.FaceCameraService;
import org.springframework.stereotype.Service;

@Service("faceCameraService")
public class FaceCameraServiceImpl extends AbstractIbatisServiceImpl<FaceCameraDao, FaceCamera, String> implements FaceCameraService {

}
