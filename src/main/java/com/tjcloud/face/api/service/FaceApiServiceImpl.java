package com.tjcloud.face.api.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.api.enums.FaceErrorCode;
import com.tjcloud.face.api.utils.FaceConfigUrl;
import com.tjcloud.face.api.utils.FaceJsoup;
import com.tjcloud.face.api.utils.HttpUtil;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.service.FaceGroupService;
import com.tjcloud.face.base.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service("faceApiService")
public class FaceApiServiceImpl implements FaceApiService{
	
	private final static Logger logger = LoggerFactory.getLogger(FaceApiServiceImpl.class);
	
	@Autowired
	private FaceJsoup faceJsoup;
	@Autowired
	private HttpUtil httpUtil;
	@Autowired
	private FaceGroupService faceGroupService;
	
	@Override
	public Boolean faceMatch(List<ImageAttr> images, String groupId, Integer score){
		Boolean faceMatch = false;
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(groupId);
		ValidateUtils.notNull(faceGroup, MessageLocale.EMPTY_CODE, "分组来源不能为空");
		Map<String, String> params = Maps.newHashMap();
		params.put("poolId", faceGroup.getPoolId());
		String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_MATCH, JSONObject.toJSONString(images), params, true);
		logger.debug("baidu Interface request result:{}", result);
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){

		}else{
			throw new BusinessException(MessageLocale.EMPTY_CODE, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		}
		return faceMatch;
	}
	
	@Override
	public JSONObject faceSearch(ImageSearch images, String groupId){
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(groupId);
		ValidateUtils.notNull(faceGroup, MessageLocale.EMPTY_CODE, "分组来源不能为空");
		Map<String, String> params = Maps.newHashMap();
		params.put("poolId", faceGroup.getPoolId());
		String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_SEARCH, JSONObject.toJSONString(images), params, true);
		logger.debug("baidu Interface request result:{}", result);
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
			JSONObject resultJson = (JSONObject) jsonResult.get("result");
			JSONArray userList = (JSONArray) resultJson.get("user_list");
			JSONObject userInfo = new JSONObject();
			Boolean success = false;
			for (int i = 0; i < userList.size(); i++) {
				JSONObject user = userList.getJSONObject(i);
				BigDecimal score = new BigDecimal(user.getString("score"));
				BigDecimal match = new BigDecimal(80);
				if(!success){
					if(score.compareTo(match) >= BigDecimal.ZERO.intValue()){
						success = true;
						userInfo = user;
					}
				}else{
					continue;
				}
			}
			jsonResult.put("success", success);
			jsonResult.put("userInfo", userInfo);
			jsonResult.put("successMessage", (success) ? "验证成功" : "验证失败");
		}else{
			throw new BusinessException(MessageLocale.EMPTY_CODE, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		}
		return jsonResult;
	}
	
	@Override
	public List<String> faceSearchImage(ImageSearch images){
		Boolean success = false;
		List<String> userIds = Lists.newArrayList();
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(images.getGroupIdList());
		ValidateUtils.notNull(faceGroup, MessageLocale.EMPTY_CODE, "分组来源不能为空");
		Map<String, String> params = Maps.newHashMap();
		params.put("poolId", faceGroup.getPoolId());
		String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_SEARCH, JSONObject.toJSONString(images), params, true);
		logger.debug("baidu Interface request result:{}", result);
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
			JSONObject resultJson = (JSONObject) jsonResult.get("result");
			JSONArray userList = (JSONArray) resultJson.get("user_list");
			for (int i = 0; i < userList.size(); i++) {
				JSONObject user = userList.getJSONObject(i);
				BigDecimal score = new BigDecimal(user.getString("score"));
				BigDecimal match = new BigDecimal(70);
				if(score.compareTo(match) >= BigDecimal.ZERO.intValue()){
					success = true;
					userIds.add(user.getString("user_id"));
				}
			}
		}else{
			throw new BusinessException(MessageLocale.EMPTY_CODE, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		}
		return (success) ? userIds : null;
	}
	
	@Override
	public FaceDetectResults checkSwinFaceSearch(FaceDetectBody faceDetectBody,String poolId){
		FaceDetectResults face = faceDetect(faceDetectBody, poolId);
		ValidateUtils.isFalse(face.getFaceNum() == 0, MessageLocale.EMPTY_CODE, "请上传有人脸的照片");
		ValidateUtils.isFalse(face.getFaceNum() > 1, MessageLocale.EMPTY_CODE, "请上传只有一个人脸的照片");
		ValidateUtils.isTrue(face.getQualityBlur() < 0.66, MessageLocale.EMPTY_CODE, "请上传人脸清晰的照片");
		ValidateUtils.isTrue(face.getQualityCompleteness() == 1, MessageLocale.EMPTY_CODE, "请上传人脸都在图像边界内的照片");
		ValidateUtils.isTrue(face.getFaceType().equals("human"), MessageLocale.EMPTY_CODE, "请不要上传卡通人脸照片");
		return face;
	}
	
	@Override
	public FaceDetectResults checkOpenSchoolSearch(FaceDetectBody faceDetectBody,String poolId){
		FaceDetectResults face = faceDetect(faceDetectBody, poolId);
		ValidateUtils.isFalse(face.getFaceNum() == 0, MessageLocale.EMPTY_CODE, "请上传有人脸的照片");
		ValidateUtils.isFalse(face.getFaceNum() > 1, MessageLocale.EMPTY_CODE, "请上传只有一个人脸的照片");
		ValidateUtils.isTrue(face.getQualityBlur() < 0.66, MessageLocale.EMPTY_CODE, "请上传人脸清晰的照片");
		ValidateUtils.isTrue(face.getQualityCompleteness() == 1, MessageLocale.EMPTY_CODE, "请上传人脸都在图像边界内的照片");
		ValidateUtils.isTrue(face.getFaceProbability() == 1, MessageLocale.EMPTY_CODE, "人脸图像质量太差");
		ValidateUtils.isTrue(face.getFaceType().equals("human"), MessageLocale.EMPTY_CODE, "人脸不能是卡通照片");
		return face;
	}
	
	@Override
	public FaceDetectResults faceDetect(FaceDetectBody faceDetectBody,String poolId){
		faceDetectBody.setFaceField(StringUtils.isEmpty(faceDetectBody.getFaceField()) ? FaceConfigUrl.FACE_FIELD : faceDetectBody.getFaceField());
		FaceDetectResults faceResults = null;
		Map<String, String> params = Maps.newHashMap();
		params.put("poolId", poolId);
		String resultJson = faceJsoup.doPost(FaceConfigUrl.POST_FACE_DETECT, JSONObject.toJSONString(faceDetectBody), params, true);
		JSONObject jsonResult = JSONObject.parseObject(resultJson, JSONObject.class);
		logger.debug("baidu Interface request result:{}, message:{}", resultJson, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		String error_code = jsonResult.getString("error_code");
		ValidateUtils.isTrue(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(error_code), MessageLocale.EMPTY_CODE, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		faceResults = new FaceDetectResults();
		JSONObject result = jsonResult.getJSONObject("result");
		faceResults.setFaceNum(result.getInteger("face_num"));
		ValidateUtils.isTrue(faceResults.getFaceNum() > BigDecimal.ZERO.intValue(), MessageLocale.EMPTY_CODE, "没有检测到人脸");
		JSONArray face_list = result.getJSONArray("face_list");
		JSONObject face = face_list.getJSONObject(0);
		faceResults.setFaceToken(face.getString("face_token"));
		if(face.getJSONObject("location") != null){
			faceResults.setLeft(face.getJSONObject("location").getDouble("left"));
			faceResults.setTop(face.getJSONObject("location").getDouble("top"));
			faceResults.setWidth(face.getJSONObject("location").getDouble("width"));
			faceResults.setHeight(face.getJSONObject("location").getDouble("height"));
			faceResults.setRotation(face.getJSONObject("location").getInteger("rotation"));
		}
		faceResults.setFaceProbability(face.getDouble("face_probability"));
		if(face.getJSONObject("angle") != null){
			faceResults.setAngelYaw(face.getJSONObject("angle").getDouble("yaw"));
			faceResults.setAngelPitch(face.getJSONObject("angle").getDouble("pitch"));
			faceResults.setAngelRoll(face.getJSONObject("angle").getDouble("roll"));
		}
		faceResults.setAge(face.getDouble("age"));
		faceResults.setBeauty(face.getInteger("beauty"));
		if(face.getJSONObject("expression") != null){
			faceResults.setExpressionType(face.getJSONObject("expression").getString("type"));
			faceResults.setExpressionProbability(face.getJSONObject("expression").getDouble("probability"));
		}
		if(face.getJSONObject("face_shape") != null){
			faceResults.setFaceShapeType(face.getJSONObject("face_shape").getString("type"));
			faceResults.setFaceShapeProbability(face.getJSONObject("face_shape").getDouble("probability"));
		}
		if(face.getJSONObject("gender") != null){
			faceResults.setGenderType(face.getJSONObject("gender").getString("type"));
			faceResults.setGenderProbability(face.getJSONObject("gender").getDouble("probability"));
		}
		if(face.getJSONObject("glasses") != null){
			faceResults.setGlassesType(face.getJSONObject("glasses").getString("type"));
			faceResults.setGlassesProbability(face.getJSONObject("glasses").getDouble("probability"));
		}
		if(face.getJSONObject("eye_status") != null){
			faceResults.setEyeStatusLeftEye(face.getJSONObject("eye_status").getDouble("left_eye"));
			faceResults.setEyeStatusRightEye(face.getJSONObject("eye_status").getDouble("right_eye"));
		}
		if(face.getJSONObject("emotion") != null){
			faceResults.setEmotionType(face.getJSONObject("emotion").getString("type"));
			faceResults.setEmotionProbability(face.getJSONObject("emotion").getDouble("probability"));
		}
		if(face.getJSONObject("race") != null){
			faceResults.setRaceType(face.getJSONObject("race").getString("type"));
			faceResults.setRaceProbability(face.getJSONObject("race").getDouble("probability"));
		}
		if(face.getJSONObject("face_type") != null){
			faceResults.setFaceType(face.getJSONObject("face_type").getString("type"));
			faceResults.setFaceTypeProbability(face.getJSONObject("face_type").getDouble("probability"));
		}
		if(face.getJSONObject("quality") != null){
			faceResults.setQualityLeftEye(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("left_eye"));
			faceResults.setQualityRightEye(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("right_eye"));
			faceResults.setQualityNose(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("nose"));
			faceResults.setQualityMouth(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("mouth"));
			faceResults.setQualityLeftCheek(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("left_cheek"));
			faceResults.setQualityRightCheek(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("right_cheek"));
			faceResults.setQualityChin(face.getJSONObject("quality").getJSONObject("occlusion").getDouble("chin_contour"));
			faceResults.setQualityBlur(face.getJSONObject("quality").getDouble("blur"));
			faceResults.setQualityIllumination(face.getJSONObject("quality").getDouble("illumination"));
			faceResults.setQualityCompleteness(face.getJSONObject("quality").getInteger("completeness"));
		}
		return faceResults;
	}
	
	@Override
	public JSONObject ocrIdcard(OcrIdcard ocrIdcard){
		Map<String, String> urlParams = Maps.newHashMap();
		urlParams.put("poolId", "11e0b0c9c75411e6a38d0242ac110034");
		String result = httpUtil.sendPost(FaceConfigUrl.POST_OCR_IDCARD, JSONObject.parseObject(JSONObject.toJSONString(ocrIdcard)), urlParams, true);
		logger.debug("baidu ocr_idcard request result:{}", result);
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		return jsonResult;
	}
	
}
