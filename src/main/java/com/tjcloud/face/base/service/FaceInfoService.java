package com.tjcloud.face.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.face.base.entity.FaceInfo;
import com.tjcloud.face.base.vo.FacesetAddVO;

/**
 * 人脸信息表(face_info)
 * @author auto bin.yin 2018.10.17
 */
public interface FaceInfoService extends AbstractService<FaceInfo, String> {
	
	/**
	 * 用于向人脸库中新增用户，及组内用户的人脸图片，
	 * @param facesetAddVO
	 * @return
	 */
	FaceInfo createFaceInfo(FacesetAddVO facesetAddVO);
	
	/**
	 * 删除用户
	 * @param groupId
	 * @param userId
	 */
	void deleteFaceInfo(String groupId, String userId);
}
