package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceInfo;
import com.tjcloud.face.base.service.FaceInfoService;
import com.tjcloud.face.base.vo.FacesetAddVO;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/faces/info")
public class FaceInfoFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceInfoFacade.class);

	@Autowired
	private FaceInfoService faceInfoService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FaceInfo> dataList = getPagination(request, faceInfoService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FaceInfo faceInfo = faceInfoService.get(id);
		return ResponseResult.getResponse().setData(faceInfo);
	}

	@PostMapping
	public ResponseResult create(@RequestBody FacesetAddVO facesetAddVO) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(facesetAddVO));
		ValidateUtils.notNull(facesetAddVO, MessageLocale.NOT_NULL);
		FaceInfo data = faceInfoService.createFaceInfo(facesetAddVO);
		return ResponseResult.getResponse().setData(data);
	}

	@SuppressWarnings("static-access")
	@PostMapping("/remove/{groupId:\\w+}/{userId:\\w+}")
	public ResponseResult remove(@PathVariable("groupId") String groupId, @PathVariable("userId") String userId) throws BusinessException {
		logger.debug("~~~~~ delete param groupId = ({}), userId = ({})", groupId, userId);
		faceInfoService.deleteFaceInfo(groupId, userId);
		return ResponseResult.getResponse().ok();
	}
	
//	public static void main(String[] args) {
//		String text = "{\"image\":\"https://tools-1yd.1yd.me/test/upload/1544696360957_WechatIMG343.jpeg\",\"groupId\":\"58e0b0c9c75411e6a38d0242ac110034\",\"imageType\":\"URL\",\"userId\":\"c0e914a5203911e8aed70242ac11004d\"}";
//		FacesetAddVO facesetAddVO = JSONObject.parseObject(text, FacesetAddVO.class);
//		System.out.println(JSONObject.toJSONString(facesetAddVO));
//	}
}
