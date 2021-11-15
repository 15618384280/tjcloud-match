package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceFrom;
import com.tjcloud.face.base.service.FaceFromService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/faces/from")
public class FaceFromFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceFromFacade.class);

	@Autowired
	private FaceFromService faceFromService;

	@AllowAnonymous
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FaceFrom> dataList = getPagination(request, faceFromService);
		return ResponseResult.getResponse().setData(dataList);
	}
	
	@GetMapping("/pc")
	public ResponseResult query(HttpServletRequest request, HttpServletResponse response) throws BusinessException {
		Pagination<FaceFrom> dataList = getPagination(request, faceFromService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/by/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FaceFrom faceFrom = faceFromService.get(id);
		return ResponseResult.getResponse().setData(faceFrom);
	}

	@PostMapping
	public ResponseResult create(@RequestBody FaceFrom faceFrom) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceFrom));

		ValidateUtils.notNull(faceFrom, MessageLocale.NOT_NULL);
		FaceFrom data = faceFromService.createFaceFrom(faceFrom);
		return ResponseResult.getResponse().setData(data);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody FaceFrom faceFrom) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceFrom));

		ValidateUtils.notNull(faceFrom, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(faceFrom.getId(), MessageLocale.NOT_EMPTY);
		int count = faceFromService.modify(faceFrom);
		
		return ResponseResult.getResponse().setData(count);
	}

	@DeleteMapping("/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
}
