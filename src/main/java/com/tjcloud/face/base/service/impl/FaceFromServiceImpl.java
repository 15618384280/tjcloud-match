package com.tjcloud.face.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.face.api.enums.FaceErrorCode;
import com.tjcloud.face.api.enums.FaceFromType;
import com.tjcloud.face.api.utils.FaceConfigUrl;
import com.tjcloud.face.api.utils.FaceJsoup;
import com.tjcloud.face.base.dao.FaceFromDao;
import com.tjcloud.face.base.entity.FaceFrom;
import com.tjcloud.face.base.service.FaceFromService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("faceFromService")
public class FaceFromServiceImpl extends AbstractIbatisServiceImpl<FaceFromDao, FaceFrom, String> implements FaceFromService {
	
	@Autowired
	private FaceJsoup faceJsoup;
	
	@Override
	public FaceFrom createFaceFrom(FaceFrom faceFrom){
		Map<String, String> params = Maps.newHashMap();
		Map<String, String> bodyParams = Maps.newHashMap();
		ValidateUtils.notNull(faceFrom.getType(), MessageLocale.EMPTY_CODE, "人脸库类型不能为空");
		ValidateUtils.notNull(faceFrom.getDoorId(), MessageLocale.EMPTY_CODE, "闸机ID不能为空");
		ValidateUtils.notNull(faceFrom.getDoorExit(), MessageLocale.EMPTY_CODE, "闸机进出方向不能为空");
		Map<String, Object> faceFromParams = Maps.newHashMap();
		faceFromParams.put("type", faceFrom.getType());
		faceFromParams.put("doorId", faceFrom.getDoorId());
		faceFromParams.put("doorExit", faceFrom.getDoorExit());
		if(FaceFromType.FROM_TENANT.getStatus() == faceFrom.getType()){
			ValidateUtils.notEmpty(faceFrom.getTenantId(), MessageLocale.EMPTY_CODE, "租户ID不能为空");
			faceFromParams.put("tenantId", faceFrom.getTenantId());
			params.put("groupId", faceFrom.getTenantId());
			bodyParams.put("group_id", faceFrom.getTenantId());
		}else if(FaceFromType.FROM_STADIUM.getStatus() == faceFrom.getType()){
			ValidateUtils.notEmpty(faceFrom.getStadiumId(), MessageLocale.EMPTY_CODE, "场馆ID不能为空");
			faceFromParams.put("stadiumId", faceFrom.getStadiumId());
			params.put("groupId", faceFrom.getStadiumId());
			bodyParams.put("group_id", faceFrom.getStadiumId());
		}else if(FaceFromType.FROM_AREA.getStatus() == faceFrom.getType()){
			ValidateUtils.notEmpty(faceFrom.getAreaCode(), MessageLocale.EMPTY_CODE, "区域代码不能为空");
			faceFromParams.put("areaCode", faceFrom.getAreaCode());
			params.put("groupId", faceFrom.getAreaCode());
			bodyParams.put("group_id", faceFrom.getAreaCode());
		}
		FaceFrom faceFromEmtity = findOne(faceFromParams);
		if(ObjectUtils.isEmpty(faceFromEmtity)){
			faceFromParams.put("doorExit", null);
			if(ObjectUtils.isEmpty(findOne(faceFromParams))){
				String result = faceJsoup.doPost(FaceConfigUrl.POST_FACESET_GROUP, JSONObject.toJSONString(bodyParams), params, true);
				ValidateUtils.notNull(result, MessageLocale.EMPTY_CODE, "百度创建分组失败");
				JSONObject jsonResult = JSONObject.parseObject(result, JSONObject.class);
				if(FaceErrorCode.OPERATION_IS_SUCCESSFUL.getCode().equals(jsonResult.getString("error_code"))){
					save(faceFrom);
				}else{
					throw new BusinessException(MessageLocale.EMPTY_CODE, "百度创建分组失败");
				}
			}else{
				save(faceFrom);
			}
		}else{
			faceFrom.setId(faceFromEmtity.getId());
			save(faceFrom);
		}
		return faceFrom;
	}
}
