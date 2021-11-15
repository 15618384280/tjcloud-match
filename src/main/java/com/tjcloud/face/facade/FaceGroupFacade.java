package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceGroup;
import com.tjcloud.face.base.service.FaceGroupService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/faces/group")
public class FaceGroupFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceGroupFacade.class);

	@Autowired
	private FaceGroupService faceGroupService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FaceGroup> dataList = getPagination(request, faceGroupService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FaceGroup faceGroup = faceGroupService.get(id);
		return ResponseResult.getResponse().setData(faceGroup);
	}
	
	@PostMapping
	public ResponseResult create(@RequestBody FaceGroup faceGroup) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceGroup));

		ValidateUtils.notNull(faceGroup, MessageLocale.NOT_NULL);
		FaceGroup data = faceGroupService.createFaceGroup(faceGroup);
		return ResponseResult.getResponse().setData(data);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody FaceGroup faceGroup) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceGroup));

		ValidateUtils.notNull(faceGroup, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(faceGroup.getId(), MessageLocale.NOT_EMPTY);
		int count = faceGroupService.modify(faceGroup);
		
		return ResponseResult.getResponse().setData(count);
	}

	@SuppressWarnings("static-access")
	@DeleteMapping("/{baiduGroupId:\\w+}")
	public ResponseResult remove(@PathVariable("baiduGroupId") String baiduGroupId) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", baiduGroupId);
		faceGroupService.deleteFaceGroup(baiduGroupId);
		return ResponseResult.getResponse().ok();
	}
}
