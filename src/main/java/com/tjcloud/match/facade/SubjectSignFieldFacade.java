package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.SignFieldState;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;
import com.tjcloud.match.base.entity.SignFieldTable;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.entity.SignRecordFieldTable;
import com.tjcloud.match.base.entity.SubjectSignField;
import com.tjcloud.match.base.service.*;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/subjects/sign/field")
public class SubjectSignFieldFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(SubjectSignFieldFacade.class);

    @Autowired
    private SubjectSignFieldService subjectSignFieldService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private SignFieldTableService signFieldTableService;
    @Autowired
    private SignRecordFieldTableService signRecordFieldTableService;
    @Autowired
    private TenantUserService tenantUserService;
    @Autowired
    private MatchSubjectService matchSubjectService;

    @AllowAnonymous
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Map<String, Object> param = getParameterMap(request);
        logger.debug("~~~~~ get param id = ({})", JSONObject.toJSONString(param));
        List<SubjectSignField> dataList = subjectSignFieldService.findBy(param);
        return ResponseResult.getResponse().setData(dataList);
    }


    /**
     * 获取科目自定义报名集合
     *
     * @param subjectId
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @GetMapping("/{subjectId:\\w+}")
    public ResponseResult get(@PathVariable("subjectId") String subjectId) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", subjectId);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("subjectId", subjectId);
        List<SubjectSignField> dataList = subjectSignFieldService.findBy(param);
        return ResponseResult.getResponse().setData(dataList);
    }
    
    /**
     * 获取科目报名填写字段集合
     *
     * @param subjectId
     * @return
     * @throws BusinessException
     */
    @AllowAnonymous
    @GetMapping("/{subjectId:\\w+}/write")
    public ResponseResult getWrite(@PathVariable("subjectId") String subjectId) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", subjectId);

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("subjectId", subjectId);
        param.put("stateList", new Integer[]{SignFieldState.SIGN_FIELD_STATE_SHOW.getStatus(),SignFieldState.SIGN_FIELD_STATE_REQUIRED.getStatus()});
        List<SubjectSignField> dataList = subjectSignFieldService.findBy(param);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * 新增、修改科目自定义报名
     *
     * @param subjectSignField
     * @param request
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseResult create(@RequestBody SubjectSignField subjectSignField, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(subjectSignField));

        ValidateUtils.notNull(subjectSignField, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(subjectSignField.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        if (ObjectUtils.isEmpty(tenantUser)) {
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        }

        if (ObjectUtils.isEmpty(matchSubjectService.get(subjectSignField.getSubjectId()))) {
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
        }

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("subjectId", subjectSignField.getSubjectId());
        param.put("controlKey", SignRecordFieldUtils.convertControlKey(subjectSignField.getComment()));
        SubjectSignField subjectSignFieldEmpty = subjectSignFieldService.findOne(param);

        boolean isAdd = ObjectUtils.isEmpty(subjectSignFieldEmpty) // 根据controlKey没查到
                && (StringUtils.isEmpty(subjectSignField.getId()) // 没传ID
                || ObjectUtils.isEmpty(subjectSignFieldEmpty = subjectSignFieldService.get(subjectSignField.getId())));// 传了ID但不存在数据

        if (isAdd) {
        	//排序号
        	Map<String, Object> paramSortNo = new HashMap<String, Object>();
            param.put("subjectId", subjectSignField.getSubjectId());
        	subjectSignField.setSortNo(Integer.parseInt(subjectSignFieldService.getMaxSubjectSignFieldSortNo(paramSortNo)));
            return ResponseResult.getResponse().setData(subjectSignFieldService.create(subjectSignField));
        } else if (subjectSignFieldEmpty.getEditable() == 0) {
            // 如果是四个必填项，不能修改显示状态
            ValidateUtils.isTrue(!SignRecordFieldUtils.isBasicSignField(subjectSignFieldEmpty.getControlKey()), MatchMessageLocale.SIGN_FIELD_EDITABLE);
            // 如果是系统定义字段，不可编辑，只能修改显示状态
            subjectSignFieldEmpty.setState(subjectSignField.getState());
            subjectSignFieldService.modify(subjectSignFieldEmpty);
        } else {
            String subjectSignFieldStr = JSONObject.toJSONString(subjectSignField);
            Map<String, Object> subjectSignFieldMap = JSONObject.parseObject(subjectSignFieldStr, HashMap.class);
            String subjectSignFieldEmptyStr = JSONObject.toJSONString(subjectSignFieldEmpty);
            Map<String, Object> subjectSignFieldEmptyMap = JSONObject.parseObject(subjectSignFieldEmptyStr, HashMap.class);
            subjectSignFieldEmptyMap.putAll(subjectSignFieldMap);
            subjectSignFieldEmpty = JSONObject.parseObject(JSONObject.toJSONString(subjectSignFieldEmptyMap), subjectSignFieldEmpty.getClass());
            subjectSignFieldService.modify(subjectSignFieldEmpty);
        }
        return ResponseResult.getResponse().setData(subjectSignFieldService.get(subjectSignFieldEmpty.getId()));
    }

    /**
     * 新增、修改多条自定义报名字段
     *
     * @param subjectSignFields
     * @param request
     * @return
     * @throws BusinessException
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/signFields")
    public ResponseResult modifySignFields(@RequestBody List<SubjectSignField> subjectSignFields, HttpServletRequest request) throws BusinessException {
        ValidateUtils.notEmpty(subjectSignFields, MessageLocale.NOT_EMPTY);
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(subjectSignFields));
        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);

        if (ObjectUtils.isEmpty(tenantUser)) {
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        }
        String subjectId = subjectSignFields.get(0).getSubjectId();
        if (ObjectUtils.isEmpty(matchSubjectService.get(subjectId))) {
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
        }

        Map<String, Object> param = new HashMap<>();
        for (SubjectSignField subjectSignField : subjectSignFields) {
            // 批量修改时校验科目id
            if (!StringUtils.isEmpty(subjectSignField.getSubjectId()) && !subjectSignField.getSubjectId().equals(subjectId)) {
                if (ObjectUtils.isEmpty(matchSubjectService.get(subjectSignField.getSubjectId()))) {
                    subjectSignField.setSubjectId(subjectId);
                } else {
                    subjectId = subjectSignField.getSubjectId();
                }
            }

            param.put("subjectId", subjectId);
            param.put("controlKey", SignRecordFieldUtils.convertControlKey(subjectSignField.getComment()));
            SubjectSignField subjectSignFieldEmpty = subjectSignFieldService.findOne(param);

            boolean isAdd = ObjectUtils.isEmpty(subjectSignFieldEmpty) // 根据controlKey没查到
                    && (StringUtils.isEmpty(subjectSignField.getId()) // 没传ID
                    || ObjectUtils.isEmpty(subjectSignFieldEmpty = subjectSignFieldService.get(subjectSignField.getId())));// 传了ID但不存在数据

            if (isAdd) {
            	//排序号
            	Map<String, Object> paramSortNo = new HashMap<String, Object>();
                param.put("subjectId", subjectSignField.getSubjectId());
            	subjectSignField.setSortNo(Integer.parseInt(subjectSignFieldService.getMaxSubjectSignFieldSortNo(paramSortNo)));
                subjectSignFieldService.create(subjectSignField);
            } else if (subjectSignFieldEmpty.getEditable() == 0) {
                // 如果是系统定义字段，不可编辑，只能修改显示状态

                // 如果是四个必填项，不能修改，跳过
                if (SignRecordFieldUtils.isBasicSignField(subjectSignFieldEmpty.getControlKey())) continue;
                // 不是必填项，则只能修改显示状态
                subjectSignFieldEmpty.setState(subjectSignField.getState());
                subjectSignFieldService.modify(subjectSignFieldEmpty);
            } else {
                String subjectSignFieldStr = JSONObject.toJSONString(subjectSignField);
                Map<String, Object> subjectSignFieldMap = JSONObject.parseObject(subjectSignFieldStr, HashMap.class);
                String subjectSignFieldEmptyStr = JSONObject.toJSONString(subjectSignFieldEmpty);
                Map<String, Object> subjectSignFieldEmptyMap = JSONObject.parseObject(subjectSignFieldEmptyStr, HashMap.class);
                subjectSignFieldEmptyMap.putAll(subjectSignFieldMap);
                subjectSignFieldEmpty = JSONObject.parseObject(JSONObject.toJSONString(subjectSignFieldEmptyMap), subjectSignFieldEmpty.getClass());
                subjectSignFieldService.modify(subjectSignFieldEmpty);
            }
        }

        param.remove("controlKey");
        List<SubjectSignField> fieldTables = subjectSignFieldService.findBy(param);
        return ResponseResult.getResponse().setData(fieldTables);
    }

    @Transactional
    @DeleteMapping("{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        SubjectSignField subjectSignField = subjectSignFieldService.get(id);
        ValidateUtils.notNull(subjectSignField, MatchMessageLocale.PARAM_IS_ERROR);

        String authId = getCurrentAuthId(request);
        TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
        if (ObjectUtils.isEmpty(tenantUser)) {
            return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
        }
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("tenantId", tenantUser.getTenantId());
        param.put("controlKey", subjectSignField.getControlKey());
        SignFieldTable one = signFieldTableService.findOne(param);
        ValidateUtils.isTrue(ObjectUtils.isEmpty(one), MatchMessageLocale.SIGN_FIELD_DONTDEL); // 系统定义的报名字段不可删除

        String subjectId = subjectSignField.getSubjectId();
        Map<String, Object> param1 = new HashMap<String, Object>();
        param1.put("subjectId", subjectId);
        List<SignRecord> signRecords = signRecordService.findBy(param1);
        for (SignRecord signRecord : signRecords) {
            String recordId = signRecord.getId();
            Map<String, Object> param2 = new HashMap<String, Object>();
            param2.put("recordId", recordId);
            param2.put("controlKey", subjectSignField.getControlKey());
            List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(param2);
            signRecordFieldTables.forEach(signRecordFieldTable -> signRecordFieldTableService.remove(signRecordFieldTable.getId()));
        }
        subjectSignFieldService.remove(id);
        return ResponseResult.ok();
    }
}
