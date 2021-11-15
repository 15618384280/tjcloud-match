package com.tjcloud.face.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.api.enums.FaceErrorCode;
import com.tjcloud.face.api.utils.FaceConfigUrl;
import com.tjcloud.face.api.utils.FaceJsoup;
import com.tjcloud.face.base.dao.FaceGroupDao;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.service.FaceGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service("faceGroupService")
public class FaceGroupServiceImpl extends AbstractIbatisServiceImpl<FaceGroupDao, FaceGroup, String> implements FaceGroupService {
	
	@Autowired
	private FaceJsoup faceJsoup;
	
	@Transactional
	@Override
	public FaceGroup createFaceGroup(FaceGroup faceGroup){
		ValidateUtils.notNull(faceGroup.getPoolId(), MessageLocale.EMPTY_CODE, "百度创建分组失败");
		ValidateUtils.notNull(faceGroup.getBaiduGroupId(), MessageLocale.EMPTY_CODE, "百度创建分组失败");
		Map<String, String> params = Maps.newHashMap();
		params.put(FaceConfigUrl.APP_POOLID, faceGroup.getPoolId());
		FaceGroup faceGroupEntity = getFaceGroupByBaiduGroupId(faceGroup.getBaiduGroupId());
		if(faceGroupEntity == null){
			Map<String, String> bodyParams = Maps.newHashMap();
			bodyParams.put("group_id", faceGroup.getBaiduGroupId());
			String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_GROUP, JSONObject.toJSONString(bodyParams), params, true);
			ValidateUtils.notNull(result, MessageLocale.EMPTY_CODE, "百度创建分组失败");
			JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
			if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
				faceGroup.setLogid(jsonResult.getString("log_id"));
			}
			faceGroup = save(faceGroup);
		}else{
			faceGroup.setId(faceGroupEntity.getId());
			faceGroup = save(faceGroup);
		}
		return faceGroup;
	}
	
	@Override
	public FaceGroup getFaceGroupByName(String poolId, String groupName){
		Map<String, Object> params = Maps.newHashMap();
		params.put("poolId", poolId);
		params.put("groupName", groupName);
		return findOne(params);
	}
	
	@Override
	public FaceGroup getFaceGroupByBaiduGroupId(String baiduGroupId){
		Map<String, Object> params = Maps.newHashMap();
		params.put("baiduGroupId", baiduGroupId);
		return findOne(params);
	}
	
	@Override
	public FaceGroup deleteFaceGroup(String baiduGroupId){
		ValidateUtils.notNull(baiduGroupId, MessageLocale.EMPTY_CODE, "参数不能为空");
		FaceGroup faceGroup = getFaceGroupByBaiduGroupId(baiduGroupId);
		Map<String, String> params = Maps.newHashMap();
		params.put(FaceConfigUrl.APP_POOLID, faceGroup.getPoolId());
		// 百度删除分组
		Map<String, String> bodyParams = Maps.newHashMap();
		bodyParams.put("group_id", faceGroup.getBaiduGroupId());
		String result = faceJsoup.doPost(FaceConfigUrl.POST_DELETE_FACESET_GROUP, JSONObject.toJSONString(bodyParams), params, true);
		ValidateUtils.notNull(result, MessageLocale.EMPTY_CODE, "百度删除分组失败");
		JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
		if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
			faceGroup.setDisabled(true);
			save(faceGroup);
		}
		return faceGroup;
	}
	
}
