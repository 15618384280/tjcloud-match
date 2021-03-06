package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.api.enums.PaymentStatus;
import com.tjcloud.match.api.enums.SignRecordReviewStatus;
import com.tjcloud.match.api.enums.SubjectType;
import com.tjcloud.match.api.message.MatchMessageLocale;
import com.tjcloud.match.api.service.SignRecordApiService;
import com.tjcloud.match.api.utils.Tuple;
import com.tjcloud.match.base.entity.*;
import com.tjcloud.match.base.service.*;
import com.tjcloud.match.base.vo.SignRecordVO;
import com.tjcloud.match.base.vo.SubjectTeamVO;
import com.tjcloud.match.utils.ExcelUtils;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.TenantUserService;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.QueryParam;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@RestController
@RequestMapping("/subjects/team")
public class SubjectTeamFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(SubjectTeamFacade.class);

    @Autowired
    private SubjectTeamService subjectTeamService;
    @Autowired
    private MatchSubjectService matchSubjectService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private SignRecordApiService signRecordApiService;
    @Autowired
    private SignRecordFieldTableService signRecordFieldTableService;
    @Autowired
    private SubjectSignFieldService subjectSignFieldService;
    @Autowired
    private UserService userService;
    @Autowired
    private TenantUserService tenantUserService;

    /**
     * ??????????????????
     *
     * @param request
     * @return
     * @throws BusinessException
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Map<String, Object> param = getParameterMap(request);
        List<SubjectTeam> dataList = subjectTeamService.findBy(param);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * ????????????????????????
     *
     * @param request
     * @return
     * @throws BusinessException
     * @throws UnsupportedEncodingException
     */
	@GetMapping("/page")
    public ResponseResult queryPage(HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        PageParam page = this.getPageParam(request);
        JSONObject param = this.getJSONObject(request);
        logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
        if(!StringUtils.isEmpty(param.getString("subjectIdList"))){
        	param.put("subjectIdList", JSONObject.parseArray("["+URLDecoder.decode(param.getString("subjectIdList"),"UTF-8")+"]"));
        }
        Pagination<SubjectTeam> dataList = subjectTeamService.queryPage(page, param);
        return ResponseResult.getResponse().setData(dataList);
    }
	// ?????????????????????
	@GetMapping("/queryOrder")
    public ResponseResult queryOrder(HttpServletRequest request) throws BusinessException, UnsupportedEncodingException {
        PageParam page = this.getPageParam(request);
        JSONObject param = this.getJSONObject(request);
        logger.debug("~~~~~ put pageParam = {}, param = {}", JSON.toJSONString(page), param);
        if(!StringUtils.isEmpty(param.getString("subjectIdList"))){
        	param.put("subjectIdList", JSONObject.parseArray("["+URLDecoder.decode(param.getString("subjectIdList"),"UTF-8")+"]"));
        }
        Pagination<SubjectTeamVO> dataList = subjectTeamService.queryOrderList(page, param);
        return ResponseResult.getResponse().setData(dataList);
    }

    @AllowAnonymous
    @GetMapping("/{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        SubjectTeam subjectTeam = subjectTeamService.get(id);
        return ResponseResult.getResponse().setData(subjectTeam);
    }

    /**
     * ????????????
     * @param subjectTeam
     * @return
     * @throws BusinessException
     */
    @PutMapping
    public ResponseResult modify(@RequestBody SubjectTeam subjectTeam) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(subjectTeam));

        ValidateUtils.notNull(subjectTeam, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(subjectTeam.getId(), MatchMessageLocale.TEAM_IS_ERROR);
        SubjectTeam subjectTeamEmpty = subjectTeamService.get(subjectTeam.getId());
        ValidateUtils.notNull(subjectTeamEmpty, MatchMessageLocale.TEAM_IS_ERROR);

        subjectTeam.setSubjectId(null); // ??????????????????
        subjectTeam.setSubjectName(null); // ??????????????????
        subjectTeam.setOrderNo(null); // ??????????????????
        subjectTeam.setPayment(null); // ????????????????????????
        subjectTeam.setExpenses(null); // ??????????????????
        subjectTeam.setPayment(null); // ??????????????????
        subjectTeam.setPaymentTime(null); // ??????????????????
        subjectTeam.setPaymentType(null); // ??????????????????
        subjectTeam.setExpenses(null); // ??????????????????
        // TODO: 2017/6/8 ???????????????????????????????????????????????????????????????
//        String captainName = subjectTeam.getCaptainName();// ????????????
//        Integer sex = subjectTeam.getSex();// ????????????
//        String phone = subjectTeam.getPhone();// ???????????????
//        String certificateNo = subjectTeam.getCertificateNo();// ???????????????

        subjectTeamService.modify(subjectTeam);
        return ResponseResult.getResponse().setData(subjectTeamService.get(subjectTeam.getId()));
    }

    /**
     * ????????????ID????????????
     * @param signRecord
     * @param request
     * @return
     */
    @PostMapping("/{teamId:\\w+}/member")
    public ResponseResult getTeamMember(@PathVariable("teamId") String teamId, HttpServletRequest request) {
	    	return ResponseResult.getResponse().setData(signRecordService.getTeamMember(teamId));
    }
    
    /**
     * ????????????????????????
     * @param signRecord
     * @param request
     * @return
     */
    @PostMapping("/addteam/{teamId:\\w+}/member")
    public ResponseResult addTeamMember(@PathVariable("teamId") String teamId, @RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) {
		HashMap<String, Object> result = Maps.newHashMap();
        result.put("captainInfo", signRecordApiService.addTeamMember(teamId, signRecord));
        result.put("teamInfo", subjectTeamService.get(teamId));
        return ResponseResult.getResponse().setData(result);
    }
    
    /**
     * ?????????????????????????????????
     * @param signRecord
     * @param request
     * @return
     */
    @PostMapping("/newTeam/user")
    public ResponseResult newTeamUser(@RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) {
        return newTeam(signRecord,request);
    }

    /**
     * ?????????????????????????????????
     * @param signRecord
     * @param request
     * @return
     */
    @AllowAnonymous
    @PostMapping("/newTeam")
    public ResponseResult newTeam(@RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecord));
        ValidateUtils.notNull(signRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(signRecord.getSubjectId(), MatchMessageLocale.SUBJECT_IS_ERROR);
        ValidateUtils.notEmpty(signRecord.getTeamName(), MatchMessageLocale.TEAM_NAME_EMPTY);
        MatchSubject matchSubject = matchSubjectService.get(signRecord.getSubjectId());
        if (ObjectUtils.isEmpty(matchSubject))
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);

        if (matchSubject.getType() != SubjectType.TEAM.getType()) { // ??????????????????????????????????????????
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
        }
        signRecord.setMemberType(1);// ??????
        signRecord.setSubjectName(matchSubject.getSubject());
        signRecord.setMatchId(matchSubject.getMatchId());
        signRecord.setExpenses(matchSubject.getExpenses());
        signRecord.setMatchName(matchSubject.getMatchName());
        signRecord.setTenantId(matchSubject.getTenantId());
        String authId = getCurrentAuthId(request);
        if (!StringUtils.isEmpty(authId)) {
            User user = userService.findByAuthId(authId);
            if (!ObjectUtils.isEmpty(user)) {
                signRecord.setUserId(user.getId());
            }
        }
        signRecord = signRecordApiService.saveSignRecord(signRecord);
        SubjectTeam subjectTeam = subjectTeamService.get(signRecord.getJoinUserId());
        HashMap<String, Object> result = Maps.newHashMap();
        result.put("captainInfo",signRecord);
        result.put("teamInfo",subjectTeam);
        return ResponseResult.getResponse().setData(result);
    }

    /**
     * ???????????? ?????????/????????????
     * @param id
     * @param request
     * @return
     * @throws BusinessException
     */
    @Transactional
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id, HttpServletRequest request) throws BusinessException {
        ValidateUtils.notEmpty(id, MatchMessageLocale.SIGN_RECORD_IS_ERROR);
        SubjectTeam subjectTeam = subjectTeamService.get(id);
        ValidateUtils.notNull(subjectTeam, MatchMessageLocale.TEAM_IS_ERROR);
        String authId = getCurrentAuthId(request);
        if (!StringUtils.isEmpty(authId)) {
            TenantUser tenantUser = tenantUserService.findTenantUserByAuthId(authId);
            if (ObjectUtils.isEmpty(tenantUser)) {
                return ResponseResult.getResponse(UserMessageLocale.USER_NOT_ENTER);
            } else {
                //?????????????????????tenantId????????????????????????
                String subjectId = subjectTeam.getSubjectId();
                if (StringUtils.isNotEmpty(subjectId)){
                    MatchSubject matchSubject = matchSubjectService.get(subjectId);
                    if (matchSubject != null){
                        String tenantId = matchSubject.getTenantId();
                        ValidateUtils.isTrue(StringUtils.equals(tenantId, tenantUser.getTenantId()), MessageLocale.INVALID_ACCESS_TOKEN_ALLOW_TO_THE_URI);
                    }
                }
            }
        }
        // ??????????????????????????????0????????????
        ValidateUtils.isTrue(subjectTeam.getPayment()== PaymentStatus.PAYABLE.getStatus() || subjectTeam.getExpenses() <= 0, MatchMessageLocale.TEAM_SIGN_CANT_DELETE);
        HashMap<String, Object> param = Maps.newHashMap();
        param.put("joinUserId",id);
        List<SignRecord> signRecords = signRecordService.findBy(param);// ????????????
        for (SignRecord signRecord: signRecords){
            signRecordApiService.deleteSignRecord(signRecord.getId()); // ????????????????????????????????????????????????
        }
        subjectTeamService.remove(id); // ????????????
        // ???????????????????????????
        signRecordApiService.resetSignCount(matchSubjectService.get(subjectTeam.getSubjectId()));
        return ResponseResult.ok();
    }
        /**
         * ????????????????????????
         *
         * @param request
         * @return
         * @throws BusinessException
         */
    @GetMapping("/exportSignExcel")
    public ResponseResult exportSignExcel(HttpServletRequest request, HttpServletResponse response,
                                      @QueryParam("pageNo")Integer pageNo,
                                      @QueryParam("pageSize")Integer pageSize) throws BusinessException {
        JSONObject param = getJSONObject(request);
        String subjectId = param.getString("subjectId");
        ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR); // ?????????subjectId?????????subject?????????????????????????????????????????????matchId????????????
        ValidateUtils.isTrue(matchSubject.getType()==SubjectType.TEAM.getType(), MatchMessageLocale.SUBJECT_NOT_TEAM); // ???????????????

        List<SubjectTeam> dataList;
        if (pageNo == null) { // ????????????
            dataList = subjectTeamService.findBy(param);
        } else { // ????????????
            PageParam page = new PageParam(pageNo, pageSize);
            dataList = subjectTeamService.queryPage(page, param).getDataList();
        }
        ValidateUtils.isTrue(dataList.size() > 0, MatchMessageLocale.DATA_EMPTY);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> paramMap = Maps.newHashMap();
        HashMap<String, Object> params = Maps.newHashMap();

        int no = 0;
        for (SubjectTeam team : dataList) { // ????????????
            params.put("joinUserId", team.getId());
            List<SignRecord> signRecords = signRecordService.findBy(params);
            if (signRecords.size() ==0 ) continue;
            for (SignRecord signRecord : signRecords) { // ??????????????????
                Map<String, Object> jsonObject = new JSONObject();

                if (team.getCertificateNo().equals(signRecord.getCertificateNo())){// ??????
                    jsonObject.put("no", ++no); // ??????
                    jsonObject.put("subjectName", team.getSubjectName()); // ????????????
                    jsonObject.put("teamName", team.getTeamName()); // ????????????
                    jsonObject.put("teamId", team.getId()); // ??????Id

                    jsonObject.put("achievement", team.getAchievement()); // ??????
                    jsonObject.put("orderNo", team.getOrderNo()); // ??????
                    jsonObject.put("payment", PaymentStatus.getText(team.getPayment())); // ????????????
                    jsonObject.put("expenses",team.getExpenses()/100.00); // ?????????
                }
                jsonObject.put("review", SignRecordReviewStatus.getText(signRecord.getReview())); // ????????????

                paramMap.put("recordId", signRecord.getId());
                List<SignRecordFieldTable> signRecordFieldTables = signRecordFieldTableService.findBy(paramMap);
                for (SignRecordFieldTable signRecordFieldTable : signRecordFieldTables) {
                    String controlKey = signRecordFieldTable.getControlKey();
                    String value = signRecordFieldTable.getValue();
                    jsonObject.put(controlKey, value);
                }
                list.add(jsonObject);
            }
        }

        List<Tuple<String, String>> relation = new ArrayList<>();
        relation.add(new Tuple<>("no", "??????"));
        relation.add(new Tuple<>("subjectName", "????????????"));
        relation.add(new Tuple<>("teamName", "????????????"));
        relation.add(new Tuple<>("teamId", "??????Id"));

        // ???????????????????????????
        List<Tuple<String, String>> fieldRelation = new ArrayList<>();// ???????????????
        Map<String, Object> signFieldParam = Maps.newHashMap();
        signFieldParam.put("subjectId", subjectId);
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        subjectSignFields.forEach(new Consumer<SubjectSignField>() {
            @Override
            public void accept(SubjectSignField subjectSignField) {
                // ?????? ???????????????
                if (subjectSignField.getState() != 0) {
                    fieldRelation.add(new Tuple<>(subjectSignField.getControlKey(), subjectSignField.getComment()));
                }
            }
        });
        relation.addAll(fieldRelation);
        relation.add(new Tuple<>("review", "????????????"));
        relation.add(new Tuple<>("achievement", "??????"));
        relation.add(new Tuple<>("orderNo", "?????????(OrderNo)"));
        relation.add(new Tuple<>("payment", "????????????"));
        relation.add(new Tuple<>("expenses", "??????"));

        logger.debug(JSONObject.toJSONString(relation));
        logger.debug(JSONObject.toJSONString(fieldRelation));

        try {
            ExcelUtils.excelExport(list, relation, matchSubject.getSubject() + "????????????????????????", response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.EXCEL_INFO_IS_ERROR);
        }
        return ResponseResult.ok();
    }
}
