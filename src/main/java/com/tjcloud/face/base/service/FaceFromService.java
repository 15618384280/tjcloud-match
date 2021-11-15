package com.tjcloud.face.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.face.base.entity.FaceFrom;

/**
 * 人脸范围信息表(face_from)
 * @author auto bin.yin 2018.12.05
 */
public interface FaceFromService extends AbstractService<FaceFrom, String> {

	/**
	 * 保存人脸库来源
	 * @param faceFrom
	 * @return
	 */
	FaceFrom createFaceFrom(FaceFrom faceFrom);
}
