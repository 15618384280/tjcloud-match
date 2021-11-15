package com.tjcloud.face.base.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.api.enums.FaceErrorCode;
import com.tjcloud.face.api.utils.FaceConfigUrl;
import com.tjcloud.face.api.utils.FaceJsoup;
import com.tjcloud.face.base.dao.FaceInfoDao;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.entity.FaceInfo;
import com.tjcloud.face.base.service.FaceGroupService;
import com.tjcloud.face.base.service.FaceInfoService;
import com.tjcloud.face.base.service.FacePoolService;
import com.tjcloud.face.base.vo.FacesetAddVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("faceInfoService")
public class FaceInfoServiceImpl extends AbstractIbatisServiceImpl<FaceInfoDao, FaceInfo, String> implements FaceInfoService {
	
	@Autowired
	private FaceJsoup faceJsoup;
	@Autowired
	private FacePoolService facePoolService;
	@Autowired
	private FaceGroupService faceGroupService;
	
	@Override
	public FaceInfo createFaceInfo(FacesetAddVO facesetAddVO){
		logger.debug("~~~~~ createFaceInfo FacesetAddVO = {}", JSONObject.toJSONString(facesetAddVO));
		ValidateUtils.notNull(facesetAddVO, MessageLocale.EMPTY_CODE, "facesetAddVO is null");
		FaceInfo faceInfo = null;
		String groupId = facesetAddVO.getGroupId();
		String userId = facesetAddVO.getUserId();
		ValidateUtils.notEmpty(groupId, MessageLocale.EMPTY_CODE, "groupId is null");
		ValidateUtils.notEmpty(userId, MessageLocale.EMPTY_CODE, "userId is null");
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(groupId);
		ValidateUtils.notNull(faceGroup, MessageLocale.EMPTY_CODE, "分组来源不能为空");

		// 检查是否需清除人脸库userId历史记录
		if(facesetAddVO.getClearFlag() != null && facesetAddVO.getClearFlag().booleanValue()){
			try{
				deleteFaceInfo(groupId, userId);
			}catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
		
		Map<String, String> params = Maps.newHashMap();
		params.put(FaceConfigUrl.APP_POOLID, faceGroup.getPoolId());
		String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_USER_ADD, JSONObject.toJSONString(facesetAddVO), params, true);
		logger.debug("baidu Interface request result:{}", result);
		ValidateUtils.notNull(result, MessageLocale.EMPTY_CODE, "人脸注册失败");
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
			JSONObject resultJson = (JSONObject) jsonResult.get("result");
			faceInfo = new FaceInfo();
			faceInfo.setImage(facesetAddVO.getImage());
			faceInfo.setImageType(facesetAddVO.getImageType());
			faceInfo.setGroupId(facesetAddVO.getGroupId());
			faceInfo.setUserId(facesetAddVO.getUserId());
			faceInfo.setUserInfo(facesetAddVO.getUserInfo());
			faceInfo.setQualityControl(facesetAddVO.getQualityControl());
			faceInfo.setLivenessControl(facesetAddVO.getLivenessControl());
			faceInfo.setLogId(jsonResult.getString("log_id"));
			faceInfo.setFaceToken(resultJson.getString("face_token"));
			JSONObject location = (JSONObject) resultJson.get("location");
			faceInfo.setLeft(location.getInteger("left"));
			faceInfo.setTop(location.getInteger("top"));
			faceInfo.setWidth(location.getInteger("width"));
			faceInfo.setHeight(location.getInteger("height"));
			faceInfo.setRotation(location.getString("rotation"));
			save(faceInfo);
		}else if (FaceErrorCode.ACCESS_TOKEN_INVALID.getCode().equals(jsonResult.getString("error_code"))){
			facePoolService.getAccessToken(faceGroup.getPoolId());
		}else{
			throw new BusinessException(MessageLocale.EMPTY_CODE, FaceErrorCode.getMessage(jsonResult.getString("error_code")));
		}
		return faceInfo;
	}
	
	@Override
	public void deleteFaceInfo(String groupId, String userId){
		ValidateUtils.notNull(userId, MessageLocale.EMPTY_CODE, "参数不能为空");
		FaceGroup faceGroup = faceGroupService.getFaceGroupByBaiduGroupId(groupId);
		ValidateUtils.notNull(faceGroup, MessageLocale.EMPTY_CODE, "分组来源不能为空");
		Map<String, String> params = Maps.newHashMap();
		params.put(FaceConfigUrl.APP_POOLID, faceGroup.getPoolId());
		// 百度删除人脸
		Map<String, String> bodyParams = Maps.newHashMap();
		bodyParams.put("group_id", groupId);
		bodyParams.put("user_id", userId);
		String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_USER_DELETE, JSONObject.toJSONString(bodyParams), params, true);
		ValidateUtils.notNull(result, MessageLocale.EMPTY_CODE, "百度删除用户失败");
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
			Map<String, Object> faceInfoParams = Maps.newHashMap();
			faceInfoParams.put("groupId", groupId);
			faceInfoParams.put("userId", userId);
			List<FaceInfo> faceInfos = findBy(faceInfoParams);
			for (FaceInfo faceInfo : faceInfos) {
				faceInfo.setDisabled(true);
				save(faceInfo);
			}
		}
	}
}
