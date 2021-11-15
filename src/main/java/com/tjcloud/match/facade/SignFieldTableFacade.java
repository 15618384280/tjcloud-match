package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.enums.TenantUserType;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;
import com.tjcloud.match.base.entity.SignFieldTable;
import com.tjcloud.match.base.service.SignFieldTableService;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/signs/field/table")
public class SignFieldTableFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(SignFieldTableFacade.class);

	@Autowired
	private SignFieldTableService signFieldTableService;
	@Autowired
	private TenantUserService tenantUserService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Map<String,Object> param = getParameterMap(request);
		List<SignFieldTable> dataList = signFieldTableService.findBy(param);
		return ResponseResult.getResponse().setData(dataList);
	}

	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseResult create(@RequestBody SignFieldTable signFieldTable, HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(signFieldTable));

		ValidateUtils.notNull(signFieldTable, MessageLocale.NOT_NULL);
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}else{
			//如果是租户的管理员则参数必须传入租户ID
			if(TenantUserType.TENANT_USER.getText().equals(TenantUserType.getText(tenantUser.getUserType()))){
				signFieldTable.setTenantId(tenantUser.getTenantId());
			}
		}
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("tenantId", signFieldTable.getTenantId());
		param.put("controlKey", SignRecordFieldUtils.convertControlKey(signFieldTable.getComment()));
		SignFieldTable signFieldTableEmpty = signFieldTableService.findOne(param);
		if(ObjectUtils.isEmpty(signFieldTableEmpty)){
			 signFieldTable = signFieldTableService.create(signFieldTable);
		}else{
			String signFieldTableStr = JSONObject.toJSONString(signFieldTable);
			Map<String,Object> signFieldTableMap = JSONObject.parseObject(signFieldTableStr, HashMap.class);
			String signFieldTableEmptyStr = JSONObject.toJSONString(signFieldTableEmpty);
			Map<String,Object> signFieldTableEmptyMap = JSONObject.parseObject(signFieldTableEmptyStr, HashMap.class);
			signFieldTableEmptyMap.putAll(signFieldTableMap);
			signFieldTableEmpty = JSONObject.parseObject(JSONObject.toJSONString(signFieldTableEmptyMap), signFieldTableEmpty.getClass());
			signFieldTableService.modify(signFieldTableEmpty);
			signFieldTable = signFieldTableEmpty;
		}
		
		return ResponseResult.getResponse().setData(signFieldTable);
	}

	/**
	 * 测试时初始化数据使用的接口
	 * @param signFieldTables
	 * @param request
	 * @return
	 * @throws BusinessException
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/signFields")
	public ResponseResult modifySignFields(@RequestBody List<SignFieldTable> signFieldTables, HttpServletRequest request) throws BusinessException {
		ValidateUtils.notNull(signFieldTables, MessageLocale.NOT_NULL);
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(signFieldTables));
		String authId = getCurrentAuthId(request);
		TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);

		if(ObjectUtils.isEmpty(tenantUser)){
			return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
		}
		String tenantId = tenantUser.getTenantId();

		Map<String,Object> param = new HashMap<>();
		param.put("tenantId", tenantId);

		for (SignFieldTable signFieldTable:signFieldTables){
			if (StringUtils.isEmpty(signFieldTable.getComment())) continue;
			signFieldTable.setTenantId(tenantId);
			param.put("controlKey", SignRecordFieldUtils.convertControlKey(signFieldTable.getComment()));
			SignFieldTable signFieldTableEmpty = signFieldTableService.findOne(param);
			if(ObjectUtils.isEmpty(signFieldTableEmpty)){
				signFieldTableService.create(signFieldTable);
			}else{
				String signFieldTableStr = JSONObject.toJSONString(signFieldTable);
				Map<String,Object> signFieldTableMap = JSONObject.parseObject(signFieldTableStr, HashMap.class);
				String signFieldTableEmptyStr = JSONObject.toJSONString(signFieldTableEmpty);
				Map<String,Object> signFieldTableEmptyMap = JSONObject.parseObject(signFieldTableEmptyStr, HashMap.class);
				signFieldTableEmptyMap.putAll(signFieldTableMap);
				signFieldTableEmpty = JSONObject.parseObject(JSONObject.toJSONString(signFieldTableEmptyMap), signFieldTableEmpty.getClass());
				signFieldTableService.modify(signFieldTableEmpty);
			}
		}

		Map<String,Object> paramAll = new HashMap<>();
		paramAll.put("tenantId", tenantId);
		List<SignFieldTable> fieldTables = signFieldTableService.findBy(paramAll);
		return ResponseResult.getResponse().setData(fieldTables);
	}



	@PutMapping("{id:\\w+}")
	public ResponseResult modify(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ put param = {}", id);

		signFieldTableService.remove(id);
		
		return ResponseResult.ok();
	}
}
