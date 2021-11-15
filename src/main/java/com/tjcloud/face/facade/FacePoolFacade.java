package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FacePool;
import com.tjcloud.face.base.service.FacePoolService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/faces/pool")
public class FacePoolFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FacePoolFacade.class);

	@Autowired
	private FacePoolService facePoolService;
	
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FacePool> dataList = getPagination(request, facePoolService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FacePool facePool = facePoolService.get(id);
		return ResponseResult.getResponse().setData(facePool);
	}

	@PostMapping
	public ResponseResult create(@RequestBody FacePool facePool) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(facePool));

		ValidateUtils.notNull(facePool, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(facePool.getId(), MessageLocale.NOT_EMPTY);
		FacePool data = facePoolService.create(facePool);
		return ResponseResult.getResponse().setData(data);
	}

	@PostMapping("/remove/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
	
	@AllowAnonymous
	@PostMapping("/token/{poolId:\\w+}")
	public ResponseResult getToken(@PathVariable("poolId") String poolId) {
		return ResponseResult.getResponse().setData(facePoolService.getAccessToken(poolId));
	}
}
