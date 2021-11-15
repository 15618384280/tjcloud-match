package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.api.service.FaceApiService;
import com.tjcloud.face.base.vo.FaceDetectBody;
import com.tjcloud.face.base.vo.ImageAttr;
import com.tjcloud.face.base.vo.ImageSearch;
import com.tjcloud.face.base.vo.OcrIdcard;
import com.tjcloud.face.utils.ImageUtils;
import com.tjcloud.face.utils.QrCodeUtils;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/faces/api")
public class FaceApiFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceApiFacade.class);

	@Autowired
	private FaceApiService faceApiService;

	@PostMapping("/match/{groupId:\\w+}")
	public ResponseResult faceMatch(@PathVariable("groupId") String groupId, @RequestBody List<ImageAttr> images) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(images));
		ValidateUtils.notNull(images, MessageLocale.NOT_NULL);
		Boolean data = faceApiService.faceMatch(images, groupId, 70);
		return ResponseResult.getResponse().setData(data);
	}
	
	@PostMapping("/search/{groupId:\\w+}")
	public ResponseResult faceSearch(@PathVariable("groupId") String groupId, @RequestBody ImageSearch images) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(images));
		ValidateUtils.notNull(images, MessageLocale.NOT_NULL);
		JSONObject data = faceApiService.faceSearch(images, groupId);
		return ResponseResult.getResponse().setData(data);
	}
	
	@PostMapping("/search/image/userid")
	public ResponseResult faceSearchImage(@RequestBody ImageSearch images) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(images));
		ValidateUtils.notNull(images, MessageLocale.NOT_NULL);
		List<String> data = faceApiService.faceSearchImage(images);
		return ResponseResult.getResponse().setData(data);
	}
	
	@AllowAnonymous
	@PostMapping("/detect/{poolId:\\w+}")
	public ResponseResult faceDetect(@PathVariable("poolId") String poolId, @RequestBody FaceDetectBody faceDetectBody) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceDetectBody));
		ValidateUtils.notNull(faceDetectBody, MessageLocale.NOT_NULL);
		return ResponseResult.getResponse().setData(faceApiService.faceDetect(faceDetectBody, poolId));
	}
	
	@AllowAnonymous
	@PostMapping("/check/search/{poolId:\\w+}")
	public ResponseResult checkFaceSearch(@PathVariable("poolId") String poolId, @RequestBody FaceDetectBody faceDetectBody) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceDetectBody));
		ValidateUtils.notNull(faceDetectBody, MessageLocale.NOT_NULL);
		return ResponseResult.getResponse().setData(faceApiService.checkSwinFaceSearch(faceDetectBody, poolId));
	}
	
	@AllowAnonymous
	@PostMapping("/check/openschool/{poolId:\\w+}")
	public ResponseResult checkOpenSchoolSearch(@PathVariable("poolId") String poolId, @RequestBody FaceDetectBody faceDetectBody) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceDetectBody));
		ValidateUtils.notNull(faceDetectBody, MessageLocale.NOT_NULL);
		return ResponseResult.getResponse().setData(faceApiService.checkOpenSchoolSearch(faceDetectBody, poolId));
	}
	
	@AllowAnonymous
	@PostMapping("/show/qrcode")
	public ResponseResult showQRcode(@RequestBody JSONObject params ,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ @@PostMapping param = {}", params.toJSONString());
		ValidateUtils.notEmpty(params.getString("contents"), MessageLocale.EMPTY_CODE, "生成二维码内容不能为空");
		ValidateUtils.notEmpty(params.getString("width"), MessageLocale.EMPTY_CODE, "生成二维码宽度不能为空");
		ValidateUtils.notEmpty(params.getString("height"), MessageLocale.EMPTY_CODE, "生成二维码高度不能为空");
		return ResponseResult.getResponse().setData(QrCodeUtils.creatRrCode(params.getString("contents"), params.getIntValue("width"), params.getIntValue("height")));
	}
	
	@AllowAnonymous
	@PostMapping("/ocr/idcard")
	public ResponseResult ocrIdcard(@RequestBody OcrIdcard ocrIdcard ,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ @PostMapping ocrIdcard param = {}", JSONObject.toJSONString(ocrIdcard));
		ValidateUtils.notEmpty(ocrIdcard.getImages(), MessageLocale.EMPTY_CODE, "图像数据不能为空");
		return ResponseResult.getResponse().setData(faceApiService.ocrIdcard(ocrIdcard));
	}
	
	@AllowAnonymous
	@PostMapping("/ocr/idcard/url")
	public ResponseResult ocrIdcard(@RequestBody JSONObject json ,HttpServletRequest request) throws BusinessException {
		logger.debug("~~~~~ @PostMapping json param = {}", json.toJSONString());
		ValidateUtils.notEmpty(json.getString("images"), MessageLocale.EMPTY_CODE, "图像地址不能为空");
		OcrIdcard ocrIdcard = new OcrIdcard();
		ocrIdcard.setImages(ImageUtils.getBase64ByImgUrl(json.getString("images")));
		ValidateUtils.notEmpty(ocrIdcard.getImages(), MessageLocale.EMPTY_CODE, "图像数据不能为空");
		return ResponseResult.getResponse().setData(faceApiService.ocrIdcard(ocrIdcard));
	}

}
