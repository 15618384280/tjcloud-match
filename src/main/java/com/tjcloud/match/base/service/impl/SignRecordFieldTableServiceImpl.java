package com.tjcloud.match.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.base.dao.SignRecordFieldTableDao;
import com.tjcloud.match.base.entity.SignRecordFieldTable;
import com.tjcloud.match.base.service.SignRecordFieldTableService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("signRecordFieldTableService")
public class SignRecordFieldTableServiceImpl extends AbstractIbatisServiceImpl<SignRecordFieldTableDao, SignRecordFieldTable, String> implements SignRecordFieldTableService {

    /**
     * 保存、新增 SignRecordFieldTable
     *
     * @param signRecordFieldTable
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public SignRecordFieldTable updateSignRecordField(SignRecordFieldTable signRecordFieldTable) {
        SignRecordFieldTable signRecordFieldTableEmpty = null;
        if(StringUtils.isNotEmpty(signRecordFieldTable.getRecordId())){
        	Map<String, Object> params = Maps.newHashMap();
        	params.put("recordId", signRecordFieldTable.getRecordId());
        	params.put("controlKey", signRecordFieldTable.getControlKey());
        	signRecordFieldTableEmpty = findOne(params);
        }
        if (StringUtils.isEmpty(signRecordFieldTable.getId()) && ObjectUtils.isEmpty(signRecordFieldTableEmpty)) { // 新增

            ValidateUtils.notEmpty(signRecordFieldTable.getRecordId(), MatchMessageLocale.SIGN_FIELD_MISSING);
            ValidateUtils.notEmpty(signRecordFieldTable.getComment(), MatchMessageLocale.SIGN_FIELD_MISSING);
            return create(signRecordFieldTable);
        } else {
            String signRecordStr = JSONObject.toJSONString(signRecordFieldTable);
            Map<String, Object> signRecordMap = JSONObject.parseObject(signRecordStr, HashMap.class);
            String signRecordEmptyStr = JSONObject.toJSONString(signRecordFieldTableEmpty);
            Map<String, Object> signRecordEmptyMap = JSONObject.parseObject(signRecordEmptyStr, HashMap.class);
            signRecordEmptyMap.putAll(signRecordMap);
            signRecordFieldTableEmpty = JSONObject.parseObject(JSONObject.toJSONString(signRecordEmptyMap), signRecordFieldTableEmpty.getClass());
            modify(signRecordFieldTableEmpty);
        }
        return get(signRecordFieldTable.getId());
    }

    @Override
    public int deleteByRecordId(String recordId) {
        return getDao().deleteByRecordId(recordId);
    }
}
