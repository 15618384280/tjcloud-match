package com.tjcloud.face.base.service;

import com.tjcloud.core.service.AbstractService;
import com.tjcloud.face.base.entity.FaceGroup;

/**
 * 人脸范围信息表(face_group)
 * @author auto bin.yin 2018.12.05
 */
public interface FaceGroupService extends AbstractService<FaceGroup, String> {

	/**
	 * 创建人脸库用户组
	 * @param faceGroup
	 * @return
	 */
	FaceGroup createFaceGroup(FaceGroup faceGroup);
	
	/**
	 * 根据名称获取分组
	 * @param poolId
	 * @param groupName
	 * @return
	 */
	FaceGroup getFaceGroupByName(String poolId, String groupName);
	
	/**
	 * 根据baiduGroupId获取分组
	 * @param baiduGroupId
	 * @return
	 */
	FaceGroup getFaceGroupByBaiduGroupId(String baiduGroupId);
	
	/**
	 * 删除人脸库用户组
	 * @param faceGroupId
	 * @return
	 */
	FaceGroup deleteFaceGroup(String baiduGroupId);
	
}
