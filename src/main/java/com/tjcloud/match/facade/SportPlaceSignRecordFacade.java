package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.NumberUtils;
import com.tjcloud.core.utils.ObjectUtils;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.dd.base.entity.Dictionary;
import com.tjcloud.dd.base.service.DictionaryService;
import com.tjcloud.match.base.entity.MatchSlogan;
import com.tjcloud.match.base.entity.SignRecord;
import com.tjcloud.match.base.entity.SportPlaceSignRecord;
import com.tjcloud.match.base.service.MatchSloganService;
import com.tjcloud.match.base.service.SignRecordService;
import com.tjcloud.match.base.service.SportPlaceSignRecordService;
import com.tjcloud.pubsport.entity.SportsPlace;
import com.tjcloud.pubsport.service.SportsPlaceService;
import com.tjcloud.uac.api.message.UserMessageLocale;
import com.tjcloud.uac.base.entity.User;
import com.tjcloud.uac.base.service.UserService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 健身苑点打卡记录表(SportPlaceSignRecord)表控制层
 *
 * @author makejava 2021-06-24 16:47:49
 */
@RestController
@RequestMapping("/sportPlace/signRecord")
public class SportPlaceSignRecordFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(SportPlaceSignRecordFacade.class);
    /**
     * 服务对象
     */
    @Autowired
    private SportPlaceSignRecordService sportPlaceSignRecordService;
    @Autowired
    private UserService userService;
    @Autowired
    private SignRecordService signRecordService;
    @Autowired
    private SportsPlaceService sportsPlaceService;
    @Autowired
    private DictionaryService dictionaryService;
    @Autowired
    private MatchSloganService matchSloganService;


    /**
     * 分页查询列表
     * @param request
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<SportPlaceSignRecord> dataList = getPagination(request, sportPlaceSignRecordService);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * 搜索列表
     * @param json
     */
    @PostMapping("/search")
    public ResponseResult query(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        json.put("disabled", false);
        List<SportPlaceSignRecord> dataList = sportPlaceSignRecordService .findBy(json);
        return ResponseResult.ok().setData(dataList);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     */
    @GetMapping("{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        SportPlaceSignRecord sportPlaceSignRecord = sportPlaceSignRecordService .get(id);
        return ResponseResult.getResponse().setData(sportPlaceSignRecord);
    }

    /**
     * 创建
     * @param sportPlaceSignRecord
     */
    @PostMapping
    public ResponseResult create(@RequestBody SportPlaceSignRecord sportPlaceSignRecord,HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(sportPlaceSignRecord));
        String authId = getCurrentAuthId(request);
        ValidateUtils.notEmpty(authId, UserMessageLocale.USER_NOT_ENTER);
        User user = userService.findByAuthId(authId);
        ValidateUtils.notNull(sportPlaceSignRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(sportPlaceSignRecord.getUserLongitude(), MessageLocale.EMPTY_CODE, "经纬度为空,请打开手机定位");
        ValidateUtils.notEmpty(sportPlaceSignRecord.getUserLatitude(), MessageLocale.EMPTY_CODE, "经纬度为空,请打开手机定位");
        ValidateUtils.notEmpty(sportPlaceSignRecord.getPlaceId(), MessageLocale.EMPTY_CODE, "签到点位不能为空");
        ValidateUtils.notEmpty(sportPlaceSignRecord.getSignRecordId(), MessageLocale.EMPTY_CODE, "赛事报名不能为空");
        //是否报名
        String signRecordId = sportPlaceSignRecord.getSignRecordId();
        SignRecord signRecord = signRecordService.get(signRecordId);
        if (ObjectUtils.isEmpty(signRecord)){
            throw new BusinessException(MessageLocale.EMPTY_CODE,"赛事未报名，请报名参加后再打卡");
        }
        //是否打卡
        Map<String,Object> param = Maps.newHashMap();
        param.put("signRecordId",sportPlaceSignRecord.getSignRecordId());
        param.put("signerId",signRecord.getUserId());
        param.put("startTime", DateUtils.toLong(DateUtils.getCurrentDate()));
        param.put("endTime",DateUtils.toLong(DateUtils.getCurrentDate())+24*60*60*1000);
        List<SportPlaceSignRecord> sportPlaceSignRecords = sportPlaceSignRecordService.findBy(param);
        if (!ObjectUtils.isEmpty(sportPlaceSignRecords)&&sportPlaceSignRecords.size()>0){
            throw new BusinessException(MessageLocale.EMPTY_CODE,"今日已打卡，请明日再打");
        }
        //打卡是否在距离内
        SportsPlace place = sportsPlaceService.get(sportPlaceSignRecord.getPlaceId());
        ValidateUtils.notNull(place, MessageLocale.NOT_NULL);
        double distance = getDistance(NumberUtils.toDouble(place.getLongitude()), NumberUtils.toDouble(place.getLatitude()), NumberUtils.toDouble(sportPlaceSignRecord.getUserLongitude()), NumberUtils.toDouble(sportPlaceSignRecord.getUserLatitude()));

        Map<String, Object> dicparam = Maps.newHashMap();
        dicparam.put("key", "matchSign_distance");
        List<Dictionary> dicList = dictionaryService.findBy(dicparam);
        if (ObjectUtils.isEmpty(dicList)){
            throw new BusinessException(MessageLocale.EMPTY_CODE,"请管理员设置签到距离");
        }
        double target = NumberUtils.toDouble(dicList.get(0).getValue());
        if (!canCheck(distance, target)) {
            throw new BusinessException(MessageLocale.EMPTY_CODE,"当前位置不能打卡,请到就近的公共体育设施附近打卡");
        }

        sportPlaceSignRecord.setPlaceName(place.getName());
        sportPlaceSignRecord.setSignerId(signRecord.getUserId());
        sportPlaceSignRecord.setSignerName(signRecord.getName());
        sportPlaceSignRecord.setSignerMobile(signRecord.getPhone());
        sportPlaceSignRecord.setSigninTime(DateUtils.toFullString(System.currentTimeMillis()));
        Map<String,Object> params = Maps.newHashMap();
        List<MatchSlogan> matchSlogans = matchSloganService.findBy(params);
        int random = 1;
        if (!ObjectUtils.isEmpty(matchSlogans)){
            random =  (int)(1+Math.random()*matchSlogans.size());

        }else {
            throw new BusinessException(MessageLocale.EMPTY_CODE,"请管理员设置标题");
        }
        SportPlaceSignRecord data = sportPlaceSignRecordService .create(sportPlaceSignRecord);

        data.setSloganName(matchSlogans.get(random-1).getSloganName());
        return ResponseResult.getResponse().setData(data);
    }

    /**
     * 修改
     * @param sportPlaceSignRecord
     */
    @PutMapping
    public ResponseResult modify(@RequestBody SportPlaceSignRecord sportPlaceSignRecord) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(sportPlaceSignRecord));

        ValidateUtils.notNull(sportPlaceSignRecord, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(sportPlaceSignRecord .getId(), MessageLocale.NOT_EMPTY);
        int count = sportPlaceSignRecordService. modify(sportPlaceSignRecord);

        return ResponseResult.getResponse().setData(count);
    }

    /**
     * 通过主键删除单条数据
     * @param id 主键
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        SportPlaceSignRecord data = new SportPlaceSignRecord();
        data. setId(id);
        data. setDisabled(true);
        return ResponseResult.getResponse().setData(sportPlaceSignRecordService .remove(id));
    }

    /**
     * 搜索列表
     * @param json
     */
    @AllowAnonymous
    @PostMapping("/query/signRecord")
    public ResponseResult querySignRecordBySportsPlace(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        String userId = json.getString("userId");
        ValidateUtils.notEmpty(userId, UserMessageLocale.USER_NOT_ENTER);
        User user = userService.get(userId);
        String matchId = json.getString("matchId");
        ValidateUtils.notEmpty(matchId, MessageLocale.EMPTY_CODE, "matchId不能为空");
        String subjectId = json.getString("subjectId");
        ValidateUtils.notEmpty(subjectId, MessageLocale.EMPTY_CODE, "科目ID不能为空");
        Map<String,Object> params  = Maps.newHashMap();
        params.put("matchId",matchId);
        params.put("subjectId",subjectId);
        params.put("userId",user.getId());
        params.put("disabled", false);
        SignRecord signRecord = null;
        List<SignRecord> signRecords = signRecordService.findBy(params);
        if (!ObjectUtils.isEmpty(signRecords)&&signRecords.size()>0){
             signRecord = signRecords.get(0);
        }else {
            throw new BusinessException(MessageLocale.EMPTY_CODE, "未参加该赛事报名,请先报名");
        }
        Map<String,Object> param  = Maps.newHashMap();
        param.put("signRecordId",signRecord.getId());
        param.put("signerId",signRecord.getUserId());
        long count =  sportPlaceSignRecordService.findALLCountGroupByEveryDay(param);
        Map<String,Object> map  = Maps.newHashMap();
        map.put("signRecord",signRecord);
        map.put("count",count);
        SportPlaceSignRecord sportPlaceSignRecord = sportPlaceSignRecordService.findEndOne(param);
        if (!ObjectUtils.isEmpty(sportPlaceSignRecord)){
            map.put("signinEndTime",sportPlaceSignRecord.getSigninTime());
        }
        Map<String,Object> paramNow  = Maps.newHashMap();
        paramNow.put("signRecordId",signRecord.getId());
        paramNow.put("signerId",signRecord.getUserId());
        paramNow.put("startTime", DateUtils.toLong(DateUtils.getCurrentDate()));
        paramNow.put("endTime",DateUtils.toLong(DateUtils.getCurrentDate())+24*60*60*1000);
        SportPlaceSignRecord sportPlaceSignRecordNow = sportPlaceSignRecordService.findOne(paramNow);
        if (!ObjectUtils.isEmpty(sportPlaceSignRecordNow)){
            map.put("signIn",true);
        }else {
            map.put("signIn",false);
        }
        return ResponseResult.ok().setData(map);
    }

    /**
     * 今日签到
     * @param json
     */
    @PostMapping("/query/signRecord/nowDay")
    public ResponseResult querySignRecord(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {

        String signRecordId = json.getString("signRecordId");
        ValidateUtils.notEmpty(signRecordId, MessageLocale.EMPTY_CODE, "赛事报名不能为空");
        SignRecord signRecord = signRecordService.get(signRecordId);
        if (ObjectUtils.isEmpty(signRecord)){
            throw new BusinessException(MessageLocale.EMPTY_CODE, "未参加该赛事报名,请先报名");
        }
        Map<String,Object> param  = Maps.newHashMap();
        param.put("signRecordId",signRecord.getId());
        param.put("signerId",signRecord.getUserId());
        param.put("startTime", DateUtils.toLong(DateUtils.getCurrentDate()));
        param.put("endTime",DateUtils.toLong(DateUtils.getCurrentDate())+24*60*60*1000);
        SportPlaceSignRecord sportPlaceSignRecord = sportPlaceSignRecordService.findOne(param);
        if (ObjectUtils.isEmpty(sportPlaceSignRecord)){
            throw new BusinessException(MessageLocale.EMPTY_CODE, "今日未打卡，请先打卡");
        }
        Map<String,Object> params = Maps.newHashMap();
        List<MatchSlogan> matchSlogans = matchSloganService.findBy(params);
        if (!ObjectUtils.isEmpty(matchSlogans)){
            int random = (int)(1+Math.random()*matchSlogans.size());
            sportPlaceSignRecord.setSloganName(matchSlogans.get(random-1).getSloganName());
        }else {
            throw new BusinessException(MessageLocale.EMPTY_CODE,"请管理员设置标题");
        }
        return ResponseResult.ok().setData(sportPlaceSignRecord);
    }

    private static double getDistance(double long1, double lat1, double long2, double lat2) {
        double a, b, R;
        R = 6378137; // 地球半径
        lat1 = lat1 * Math.PI / 180.0;
        lat2 = lat2 * Math.PI / 180.0;
        a = lat1 - lat2;
        b = (long1 - long2) * Math.PI / 180.0;
        double d;
        double sa2, sb2;
        sa2 = Math.sin(a / 2.0);
        sb2 = Math.sin(b / 2.0);
        d = 2 * R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1) * Math.cos(lat2) * sb2 * sb2));
        return NumberUtils.roundDouble(d, 2);
    }

    private Boolean canCheck(double source, double target) {
        Boolean res = false;
        BigDecimal data1 = new BigDecimal(source);
        BigDecimal data2 = new BigDecimal(target);
        if (data1.compareTo(data2) <= 0) {
            res = true;
        }
        return res;
    }
}
