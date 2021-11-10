package com.tjcloud.face.api.service;

import com.tjcloud.face.base.vo.ImageSearch;

import java.util.List;

public interface FaceApiService {

	/**
	 * M：N识别：也称为M：N识别，待识别图片中含有多个人脸时，在指定人脸集合中，找到这多个人脸分别最相似的人脸
	 * @param images
	 * @param groupId
	 * @return
	 */
	List<String> faceSearchImage(ImageSearch images);

}
