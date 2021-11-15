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
     * 查询科目团队
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
     * 分页查询科目团队
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
	// 结合场馆的分页
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
     * 修改团队
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

        subjectTeam.setSubjectId(null); // 不能修改科目
        subjectTeam.setSubjectName(null); // 不能修改科目
        subjectTeam.setOrderNo(null); // 不能修改订单
        subjectTeam.setPayment(null); // 不能修改支付状态
        subjectTeam.setExpenses(null); // 不能修改费用
        subjectTeam.setPayment(null); // 不能修改费用
        subjectTeam.setPaymentTime(null); // 不能修改费用
        subjectTeam.setPaymentType(null); // 不能修改费用
        subjectTeam.setExpenses(null); // 不能修改费用
        // TODO: 2017/6/8 修改团队队长信息，同时需要修改队长有关记录
//        String captainName = subjectTeam.getCaptainName();// 队长姓名
//        Integer sex = subjectTeam.getSex();// 队长性别
//        String phone = subjectTeam.getPhone();// 队长手机号
//        String certificateNo = subjectTeam.getCertificateNo();// 队长证件号

        subjectTeamService.modify(subjectTeam);
        return ResponseResult.getResponse().setData(subjectTeamService.get(subjectTeam.getId()));
    }

    /**
     * 根据团队ID查看成员
     * @param signRecord
     * @param request
     * @return
     */
    @PostMapping("/{teamId:\\w+}/member")
    public ResponseResult getTeamMember(@PathVariable("teamId") String teamId, HttpServletRequest request) {
	    	return ResponseResult.getResponse().setData(signRecordService.getTeamMember(teamId));
    }
    
    /**
     * 成员自己加入团队
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
     * 新增队长，同时创建团队
     * @param signRecord
     * @param request
     * @return
     */
    @PostMapping("/newTeam/user")
    public ResponseResult newTeamUser(@RequestBody SignRecordVO<SignRecordFieldTable> signRecord, HttpServletRequest request) {
        return newTeam(signRecord,request);
    }

    /**
     * 新增队长，同时创建团队
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

        if (matchSubject.getType() != SubjectType.TEAM.getType()) { // 科目不是团体赛，不能新增队长
            throw new BusinessException(MatchMessageLocale.SUBJECT_IS_ERROR);
        }
        signRecord.setMemberType(1);// 队长
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
     * 删除团队 未支付/免费报名
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
                //删除报名记录，tenantId必须和此科目一致
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
        // 未支付或支付金额小于0才能删除
        ValidateUtils.isTrue(subjectTeam.getPayment()== PaymentStatus.PAYABLE.getStatus() || subjectTeam.getExpenses() <= 0, MatchMessageLocale.TEAM_SIGN_CANT_DELETE);
        HashMap<String, Object> param = Maps.newHashMap();
        param.put("joinUserId",id);
        List<SignRecord> signRecords = signRecordService.findBy(param);// 团队成员
        for (SignRecord signRecord: signRecords){
            signRecordApiService.deleteSignRecord(signRecord.getId()); // 删除团队成员记录及自定义报名字段
        }
        subjectTeamService.remove(id); // 删除团队
        // 赛事、科目报名数量
        signRecordApiService.resetSignCount(matchSubjectService.get(subjectTeam.getSubjectId()));
        return ResponseResult.ok();
    }
        /**
         * 导出团队报名选手
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
        ValidateUtils.notEmpty(subjectId, MatchMessageLocale.SUBJECT_IS_ERROR); // 必须传subjectId，每个subject的自定义字段可能不同，不能导出matchId所有记录
        MatchSubject matchSubject = matchSubjectService.get(subjectId);
        ValidateUtils.notNull(matchSubject, MatchMessageLocale.SUBJECT_IS_ERROR); // 必须传subjectId，每个subject的自定义字段可能不同，不能导出matchId所有记录
        ValidateUtils.isTrue(matchSubject.getType()==SubjectType.TEAM.getType(), MatchMessageLocale.SUBJECT_NOT_TEAM); // 不是团体赛

        List<SubjectTeam> dataList;
        if (pageNo == null) { // 导出所有
            dataList = subjectTeamService.findBy(param);
        } else { // 分页导出
            PageParam page = new PageParam(pageNo, pageSize);
            dataList = subjectTeamService.queryPage(page, param).getDataList();
        }
        ValidateUtils.isTrue(dataList.size() > 0, MatchMessageLocale.DATA_EMPTY);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> paramMap = Maps.newHashMap();
        HashMap<String, Object> params = Maps.newHashMap();

        int no = 0;
        for (SubjectTeam team : dataList) { // 所有团队
            params.put("joinUserId", team.getId());
            List<SignRecord> signRecords = signRecordService.findBy(params);
            if (signRecords.size() ==0 ) continue;
            for (SignRecord signRecord : signRecords) { // 所有团队成员
                Map<String, Object> jsonObject = new JSONObject();

                if (team.getCertificateNo().equals(signRecord.getCertificateNo())){// 队长
                    jsonObject.put("no", ++no); // 序号
                    jsonObject.put("subjectName", team.getSubjectName()); // 科目名称
                    jsonObject.put("teamName", team.getTeamName()); // 团队名称
                    jsonObject.put("teamId", team.getId()); // 团队Id

                    jsonObject.put("achievement", team.getAchievement()); // 成绩
                    jsonObject.put("orderNo", team.getOrderNo()); // 成绩
                    jsonObject.put("payment", PaymentStatus.getText(team.getPayment())); // 支付状态
                    jsonObject.put("expenses",team.getExpenses()/100.00); // 报名费
                }
                jsonObject.put("review", SignRecordReviewStatus.getText(signRecord.getReview())); // 审核状态

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
        relation.add(new Tuple<>("no", "序号"));
        relation.add(new Tuple<>("subjectName", "科目名称"));
        relation.add(new Tuple<>("teamName", "团队名称"));
        relation.add(new Tuple<>("teamId", "团队Id"));

        // 科目定义的报名字段
        List<Tuple<String, String>> fieldRelation = new ArrayList<>();// 自定义字段
        Map<String, Object> signFieldParam = Maps.newHashMap();
        signFieldParam.put("subjectId", subjectId);
        List<SubjectSignField> subjectSignFields = subjectSignFieldService.findBy(signFieldParam);
        subjectSignFields.forEach(new Consumer<SubjectSignField>() {
            @Override
            public void accept(SubjectSignField subjectSignField) {
                // 如果 状态为显示
                if (subjectSignField.getState() != 0) {
                    fieldRelation.add(new Tuple<>(subjectSignField.getControlKey(), subjectSignField.getComment()));
                }
            }
        });
        relation.addAll(fieldRelation);
        relation.add(new Tuple<>("review", "审核状态"));
        relation.add(new Tuple<>("achievement", "成绩"));
        relation.add(new Tuple<>("orderNo", "订单号(OrderNo)"));
        relation.add(new Tuple<>("payment", "支付状态"));
        relation.add(new Tuple<>("expenses", "金额"));

        logger.debug(JSONObject.toJSONString(relation));
        logger.debug(JSONObject.toJSONString(fieldRelation));

        try {
            ExcelUtils.excelExport(list, relation, matchSubject.getSubject() + "科目报名选手列表", response);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BusinessException(MatchMessageLocale.EXCEL_INFO_IS_ERROR);
        }
        return ResponseResult.ok();
    }
}
