package com.tjcloud.face.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.face.api.service.FaceApiService;
import com.tjcloud.face.base.entity.FaceWarn;
import com.tjcloud.face.base.service.FaceWarnService;
import com.tjcloud.face.base.vo.ImageSearch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author LuCheng
 * @Description 定时任务
 * @Date 2019-09-03 15:41
 **/

public class FaceSearch {
    private static final Logger logger = LoggerFactory.getLogger(FaceSearch.class);
    public static final String groupId = "3118923d718811e98c750242ac11004d";

    @Autowired
    private FaceWarnService faceWarnService;
    @Autowired
    private FaceApiService faceApiService;

//    @Scheduled(cron = "0 0/1 * * * ?")
    public void collectDaily() {
        // 从教育局服务器获取到人脸识别图片
        ImageSearch images = new ImageSearch();
        images.setImageType("url");
        images.setImages("https://release-1yd.1yd.me/2d505c39795b4de584664cf721ddd4bb.png");
        logger.debug("~~~~~ images = {}", JSON.toJSONString(images));

        // 调用百度API识别人脸照片
        JSONObject jsonObject = faceApiService.faceSearch(images, groupId);
        logger.debug("~~~~~  jsonObject = {}", JSON.toJSONString(jsonObject));
        // 如果识别成功则存入越界表
        if (jsonObject.getBoolean("success")) {
            jsonObject.get("userInfo");
            FaceWarn faceWarn = new FaceWarn();
            faceWarn.setWarnTime(System.currentTimeMillis());
            faceWarnService.create(faceWarn);
        }
    }
}
