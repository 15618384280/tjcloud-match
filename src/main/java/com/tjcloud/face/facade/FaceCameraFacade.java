package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceCamera;
import com.tjcloud.face.base.service.FaceCameraService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/faces/camera")
public class FaceCameraFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceCameraFacade.class);

	@Autowired
	private FaceCameraService faceCameraService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FaceCamera> dataList = getPagination(request, faceCameraService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FaceCamera faceCamera = faceCameraService.get(id);
		return ResponseResult.getResponse().setData(faceCamera);
	}

	@PostMapping
	public ResponseResult create(@RequestBody FaceCamera faceCamera) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceCamera));

		ValidateUtils.notNull(faceCamera, MessageLocale.NOT_NULL);
		//ValidateUtils.notEmpty(faceCamera.getId(), MessageLocale.NOT_EMPTY);
		FaceCamera data = faceCameraService.create(faceCamera);
		return ResponseResult.getResponse().setData(data);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody FaceCamera faceCamera) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceCamera));

		ValidateUtils.notNull(faceCamera, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(faceCamera.getId(), MessageLocale.NOT_EMPTY);
		int count = faceCameraService.modify(faceCamera);
		
		return ResponseResult.getResponse().setData(count);
	}

	@DeleteMapping("/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
}
