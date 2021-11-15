package com.tjcloud.face.api.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.face.base.vo.*;

import java.util.List;

public interface FaceApiService {
	
	/**
	 * 比对两张图片中人脸的相似度，并返回相似度分值；
	 * 相似度大于70则判定为同一个人
	 * @param images
	 * @param groupId
	 * @return
	 */
	Boolean faceMatch(List<ImageAttr> images, String fromId, Integer score);
	
	/**
	 * M：N识别：也称为M：N识别，待识别图片中含有多个人脸时，在指定人脸集合中，找到这多个人脸分别最相似的人脸
	 * @param images
	 * @param groupId
	 * @return
	 */
	JSONObject faceSearch(ImageSearch images, String groupId);
	
	/**
	 * M：N识别：也称为M：N识别，待识别图片中含有多个人脸时，在指定人脸集合中，找到这多个人脸分别最相似的人脸
	 * @param images
	 * @param groupId
	 * @return
	 */
	List<String> faceSearchImage(ImageSearch images);
	
	/**
	 * 游泳健康电子卡
	 * 人脸识别检测照片是否符合人脸认证
	 * @param faceDetectBody
	 * @param poolId
	 * @return
	 */
	FaceDetectResults checkSwinFaceSearch(FaceDetectBody faceDetectBody,String poolId);
	
	/**
	 * 学校场地开放
	 * 人脸识别检测照片是否符合人脸认证
	 * @param faceDetectBody
	 * @param poolId
	 * @return
	 */
	FaceDetectResults checkOpenSchoolSearch(FaceDetectBody faceDetectBody,String poolId);
	
	/**
	 * 人脸检测与属性分析
	 * @param faceDetectBody
	 * @param poolId
	 * @return
	 */
	FaceDetectResults faceDetect(FaceDetectBody faceDetectBody,String poolId);
	
	/**
	 * 身份证识别
	 * @param ocrIdcard
	 * @return
	 */
	JSONObject ocrIdcard(OcrIdcard ocrIdcard);
}
