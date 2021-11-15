package com.tjcloud.face.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.auth.base.entity.AuthUser;
import com.tjcloud.auth.base.service.AuthUserService;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.utils.DateUtils;
import com.tjcloud.core.utils.StringUtils;
import com.tjcloud.core.utils.crypto.Cryption;
import com.tjcloud.data.mybatis.service.impl.AbstractIbatisServiceImpl;
import com.tjcloud.data.redis.service.RedisCache;
import com.tjcloud.face.base.dao.FaceWarnDao;
import com.tjcloud.face.base.entity.FaceCamera;
import com.tjcloud.face.base.entity.FaceWarn;
import com.tjcloud.face.base.entity.FaceWarnLoc;
import com.tjcloud.face.base.service.FaceCameraService;
import com.tjcloud.face.base.service.FaceWarnLocService;
import com.tjcloud.face.base.service.FaceWarnService;
import com.tjcloud.push.service.SmsPushService;
import com.tjcloud.stadium.api.vo.StadiumItemVO;
import com.tjcloud.stadium.base.entity.Stadium;
import com.tjcloud.stadium.base.service.StadiumItemService;
import com.tjcloud.stadium.base.service.StadiumService;
import com.tjcloud.uac.base.entity.TenantUser;
import com.tjcloud.uac.base.service.TenantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("faceWarnService")
public class FaceWarnServiceImpl extends AbstractIbatisServiceImpl<FaceWarnDao, FaceWarn, String> implements FaceWarnService {
    private static final String PUSH_MASTER = "942b6458e88fd090ead58376";
    private static final String PUSH_APPKEY = "3a5b394e720c177f0352f3f1";

    @Autowired
    private FaceWarnLocService faceWarnLocService;
    @Autowired
    private FaceCameraService faceCameraService;
    @Autowired
    private StadiumService stadiumService;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private StadiumItemService stadiumItemService;
    @Autowired
    private FaceWarnService faceWarnService;
    @Autowired
    private TenantUserService tenantUserService;

    @Autowired
    private AuthUserService authUserService;
    @Autowired
    private SmsPushService smsPushService;

    public List<JSONObject> findWithLoc(Map<String, Object> params) {
        return getDao().findWithLoc(params);
    }

    @Override
    public Pagination<JSONObject> queryFaceWarnListPage(PageParam page, Map<String, Object> params) {
        return this.getDao().queryFaceWarnListPage(page, params);
    }

    @Override
    public List<JSONObject> queryFaceWarnDeal(Map<String, Object> params) {
        return getDao().queryFaceWarnDeal(params);
    }

    @Override
    public boolean saveData(Map<String, Object> params) {
            //黑盒子id
            String device_id = params.get("device_id").toString();
            //摄像机id
            String camera_id = params.get("camera_id").toString();
            //摄像头地点名称
            String camera_name = params.get("camera_name").toString();
            //抓拍场景图
            String imageUrl = params.get("imageUrl").toString();
            //识别时间
            String ai_time = params.get("ai_time").toString();

            Map<String,Object> param = Maps.newHashMap();
            param.put("locIp", device_id);

            List<FaceWarnLoc> fwList = faceWarnLocService.findBy(param);
            if(fwList.size() == 0) {
                throw new BusinessException(MessageLocale.EMPTY_CODE, "请联系管理员提供监控地址");
            }

            FaceWarnLoc fwloc = fwList.get(0);
            String stadiumId = fwloc.getStadiumId();

            logger.debug("##### stadiumId: {} name: {}", stadiumId, fwloc.getName());

            param.clear();
            param.put("deviceCode", camera_id);
            param.put("stadiumId", stadiumId);
            List<FaceCamera> fcList = faceCameraService.findBy(param);
            if(fcList.size() == 0) {
                FaceCamera newFc = new FaceCamera();
                newFc.setStadiumId(stadiumId);
                newFc.setDeviceCode(camera_id);
                newFc.setCameraName(camera_name);
                newFc.setDescribeLocation(camera_name);
                Stadium st = stadiumService.get(stadiumId);
                if(st != null){
                    newFc.setLongitude(st.getLongitude());
                    newFc.setLatitude(st.getLatitude());
                    newFc.setStadiumName(fwloc.getName());
                }
                faceCameraService.create(newFc);
                newFc = faceCameraService.findOne(param);
                fcList.add(newFc);
                //logger.debug("##### newFc.getId(): {} dc: {}", newFc.getId(), newFc.getDeviceCode());
            }

            FaceCamera fc = fcList.get(0);
            String cameraId = fc.getId();

            logger.debug("##### cameraId: {} deviceCode: {} StadiumItemId: {}", cameraId, fc.getDeviceCode(), fc.getStadiumItemId());

//            String itemId = fc.getStadiumItemId();

            String redisKey = "tj_ft_"+device_id+camera_id;
            String redisVal = redisCache.get(redisKey);
            //logger.debug("redisVal = "+redisVal);
            JSONObject redisObj = new JSONObject();
            StadiumItemVO stadiumItemVO = null;
            if(StringUtils.isEmpty(redisVal) == false) {
                redisObj = JSONObject.parseObject(redisVal);
//                stadiumItemVO = JSONObject.toJavaObject(redisObj.getJSONObject("stadiumItemVO"), StadiumItemVO.class);
            }


//        boolean notAlertTime = true;
//        long capLongVal = Long.valueOf(System.currentTimeMillis())*1000;
//        DateTime dateTime = new DateTime(capLongVal);
//        if(StringUtils.isEmpty(itemId) == false){
//            if(stadiumItemVO != null){
//                StadiumItemOpeningTimeVO voAlways = stadiumItemVO.getStadiumItemOpeningTimeVOAlways();
//                List<StadiumItemOpeningTimeDayVO> timeVOList = voAlways.getStadiumItemOpeningTimeDayVOList();
//                for(StadiumItemOpeningTimeDayVO timeVO : timeVOList){
//                    if(timeVO.getDayOfWeek() == dateTime.getDayOfWeek()){
//                        List<StadiumItemOpeningTimeDateVO> dayVOList = timeVO.getStadiumItemOpeningTimeDateVOList();
//                        for(StadiumItemOpeningTimeDateVO dayVO:dayVOList){
//                            String start = dayVO.getBeginTime();
//                            String end = dayVO.getEndTime();
//                            String capNow = DateUtils.formatDate(capLongVal, "HH:mm");
//                            if(start.compareTo(capNow)<=0 && capNow.compareTo(end) <=0 ){
//                                notAlertTime = false;
//                            }
//                            logger.debug("uuu capNow: {} start: {} end: {} notAlertTime = {}", capNow, start, end, notAlertTime);
//                        }//for day
//                    } // if week
//                }//for time
//            }
//        }//if
//        if(notAlertTime == true){
//            return;
//        }

            FaceWarn faceWarn = new FaceWarn();
            faceWarn.setWarnUrl(imageUrl);
            faceWarn.setWarnTime(DateUtils.toLongDateTime(ai_time)/1000);
            faceWarn.setCameraId(fc.getId());
            faceWarn.setSchoolUrl(device_id);
            faceWarn.setStdId(stadiumId);

            faceWarnService.create(faceWarn);
            if(StringUtils.isEmpty(redisVal) == true){
                Stadium st = stadiumService.get(stadiumId);
                if(st == null || StringUtils.isEmpty(st.getTenantUserId()))
                    throw new BusinessException(MessageLocale.EMPTY_CODE, "请在场馆设置租户用户");

                logger.debug("##### getTelephone: {}", st.getTelephone());

                //*
                logger.debug("##### getTenantUserId: {} ", st.getTenantUserId());

                TenantUser tu = tenantUserService.get(st.getTenantUserId());
                if(tu == null || StringUtils.isEmpty(tu.getAuthId()))
                    throw new BusinessException(MessageLocale.EMPTY_CODE, "请设置租户用户");

                logger.debug("##### getAuthId(): {} ", tu.getAuthId());

                AuthUser authUser = authUserService.get(tu.getAuthId());
                if(authUser == null || StringUtils.isEmpty(authUser.getUsername()))
                    throw new BusinessException(MessageLocale.EMPTY_CODE, "请设置用户信息");

                logger.debug("##### getUsername(): {} ", authUser.getUsername());

                redisObj.put("username", authUser.getUsername());
                redisCache.set(redisKey, redisObj.toJSONString());
                //*/
            }


            JSONObject json = new JSONObject();
            String title = "校园陌生人脸事件";
            String content = "您好，有陌生人进入监控区域，详情请登录APP查看";
            String receiver = redisObj.getString("username");
            json.put("pushMaster", PUSH_MASTER);
            json.put("pushAppKey", PUSH_APPKEY);
            json.put("buzKey", StringUtils.getUUID());
            json.put("buzType",StringUtils.getUUID());

            boolean ret = smsPushService.pushSms("0", title, Cryption.md5Hex(receiver).toLowerCase(), content, json);

            logger.debug("##### smsPushService params {} ret = {}", json.toJSONString(), ret);

            return ret;

        }

}
