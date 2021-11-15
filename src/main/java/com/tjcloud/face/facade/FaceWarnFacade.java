package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceWarn;
import com.tjcloud.face.base.service.FaceWarnService;
import com.tjcloud.face.utils.TopicProducer;
import com.tjcloud.fastdfs.api.FSConstants;
import com.tjcloud.fastdfs.api.service.FastDFSService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/faces/warn")
public class FaceWarnFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(FaceWarnFacade.class);

    @Autowired
    private FaceWarnService faceWarnService;
    @Autowired
    private FastDFSService fastDFSService;

    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<FaceWarn> dataList = getPagination(request, faceWarnService);
        return ResponseResult.getResponse().setData(dataList);
    }

    @GetMapping("/{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        FaceWarn faceWarn = faceWarnService.get(id);
        return ResponseResult.getResponse().setData(faceWarn);
    }

    @GetMapping("/withloc")
    public ResponseResult queryMap(HttpServletRequest request) throws BusinessException {
        Map<String, Object> params = getParameterMap(request);
        params.put("disabled", 0);
        logger.debug("~~~~~ get wloc params = ({})", JSONObject.toJSONString(params));

        List<JSONObject> dataList = faceWarnService.findWithLoc(params);
        return ResponseResult.ok().setData(dataList);
    }

    @PostMapping
    public ResponseResult create(@RequestBody FaceWarn faceWarn) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceWarn));

        ValidateUtils.notNull(faceWarn, MessageLocale.NOT_NULL);
        //ValidateUtils.notEmpty(faceWarn.getId(), MessageLocale.NOT_EMPTY);
        FaceWarn data = faceWarnService.create(faceWarn);
        return ResponseResult.getResponse().setData(data);
    }

    @PutMapping
    public ResponseResult modify(@RequestBody FaceWarn faceWarn) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceWarn));

        ValidateUtils.notNull(faceWarn, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(faceWarn.getId(), MessageLocale.NOT_EMPTY);
        int count = faceWarnService.modify(faceWarn);

        return ResponseResult.getResponse().setData(count);
    }

    @DeleteMapping("/{id:\\w+}")
    public void remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
    }

    @AllowAnonymous
    @PostMapping("/simadd")
    public ResponseResult createUserByWechat(@RequestBody JSONObject bizContent, HttpServletRequest request) throws BusinessException {
        logger.debug("~~~~~ simadd5 param = {}", JSON.toJSONString(bizContent));
        String capUrl = bizContent.getString("capUrl");
        ValidateUtils.notEmpty(capUrl, MessageLocale.NOT_EMPTY);

        final String QUEUE_NAME = "mq.schoolattendance.edualarm.msg.topic";

        //String capUrl = "https://release-1yd.1yd.me/2d505c39795b4de584664cf721ddd4bb.png";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("method", "schoolattendance.event.notify");
        jsonObject.put("id", 1);
        JSONObject dataObj = new JSONObject();
        dataObj.put("inOutType", "1");
        dataObj.put("gender", "1");
        dataObj.put("capturePictureUrl", capUrl);
        dataObj.put("panoramaPictureUrl", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4208776403,2028714505&fm=26&gp=0.jpg");
        dataObj.put("captureDate", System.currentTimeMillis());
        dataObj.put("channelId", "C02");
        JSONObject infoObj = new JSONObject();
        infoObj.put("type", "2");
        infoObj.put("data", dataObj);
        jsonObject.put("info", infoObj);

        TopicProducer producer = TopicProducer.getInstance();
        String sr = "send mq failed";
        try {
            sr = producer.producer(
                    //faceMsg1 + System.currentTimeMillis() + faceMsg2
                    jsonObject.toJSONString()
            );
        } catch (Exception ex) {
            logger.debug("simadd5 ex = " + ex.getMessage());
        }
        return ResponseResult.ok().setData(sr);
    }


    @AllowAnonymous
    @PostMapping("/push")
    public ResponseResult createUserByPush(@RequestParam("image_file") CommonsMultipartFile file, HttpServletRequest request) throws BusinessException {
        Map<String, Object> params = getParameterMap(request);
        logger.debug("~~~~~ push param = {}", JSONObject.toJSONString(params));

        String imageUrl = getUploadImageUrl(file);
        params.put("imageUrl", imageUrl);
        boolean b = faceWarnService.saveData(params);
        Map<String, Object> map = Maps.newHashMap();
        if (b){
            map.put("retCode", "0");
            map.put("msg", "succ");
        }else {
            map.put("msg", "error ");
        }
        return ResponseResult.ok().setData(map);
    }

    private String getUploadImageUrl(CommonsMultipartFile file) {
        byte[] buffer = null;
        try {
            DiskFileItem fi = (DiskFileItem) file.getFileItem();
            File f = fi.getStoreLocation();
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            logger.error("#### upload ERROR!FileNotFoundException :{}", e.getMessage());
        } catch (IOException e) {
            logger.error("#### upload ERROR!,{}", e.getMessage());
        }
        //产线空间地址
//		ResponseResult uploadImage = fastDFSService.uploadImage(buffer, System.currentTimeMillis() + file.getName(), FSConstants.QINIU_BUCKET_NAME_DEFAULT);
		//测试空间地址
		ResponseResult uploadImage = fastDFSService.uploadImage(buffer, System.currentTimeMillis() + file.getName(), FSConstants.QINIU_BUCKET_NAME_RELEASE);
		logger.info("uploadImage = {}", JSONObject.toJSONString(uploadImage.getData()));
		String s = JSONObject.toJSONString(uploadImage.getData());
		JSONObject jsonObject = JSONObject.parseObject(s);
		return jsonObject.getString("imageUrl");
	}
}
