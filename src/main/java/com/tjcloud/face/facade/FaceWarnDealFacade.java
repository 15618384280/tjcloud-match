package com.tjcloud.face.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.api.enums.FaceWarnState;
import com.tjcloud.face.base.entity.FaceWarn;
import com.tjcloud.face.base.entity.FaceWarnDeal;
import com.tjcloud.face.base.service.FaceWarnDealService;
import com.tjcloud.face.base.service.FaceWarnService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/faces/warndeal")
public class FaceWarnDealFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(FaceWarnDealFacade.class);

	@Autowired
	private FaceWarnDealService faceWarnDealService;

	@Autowired
	private FaceWarnService faceWarnService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<FaceWarnDeal> dataList = getPagination(request, faceWarnDealService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		FaceWarnDeal faceWarnDeal = faceWarnDealService.get(id);
		return ResponseResult.getResponse().setData(faceWarnDeal);
	}

	@PostMapping
	public ResponseResult create(@RequestBody FaceWarnDeal faceWarnDeal) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceWarnDeal));

		ValidateUtils.notNull(faceWarnDeal, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(faceWarnDeal.getWarnId(), MessageLocale.NOT_EMPTY);

		FaceWarnDeal fwd = null;
		Map<String, Object> params = new HashMap();
		params.put("warnId", faceWarnDeal.getWarnId());
		List<FaceWarnDeal> fwdList = faceWarnDealService.findBy(params);

		if(fwdList.size() == 0){
			fwd = faceWarnDealService.create(faceWarnDeal);
			faceWarnDeal = fwd;
		}
		else{
			fwd = fwdList.get(0);
			faceWarnDeal.setId(fwd.getId());
			int count = faceWarnDealService.modify(faceWarnDeal);
		}

		params.clear();
		params.put("id", faceWarnDeal.getWarnId());
		List<FaceWarn> fwList = faceWarnService.findBy(params);
		if(fwList.size()>0){
			FaceWarn fw = fwList.get(0);
			fw.setState(FaceWarnState.Processing.ordinal());
			faceWarnService.modify(fw);
		}

		return ResponseResult.getResponse().setData(faceWarnDeal);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody FaceWarnDeal faceWarnDeal) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceWarnDeal));

		ValidateUtils.notNull(faceWarnDeal, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(faceWarnDeal.getId(), MessageLocale.NOT_EMPTY);
		int count = faceWarnDealService.modify(faceWarnDeal);
		
		return ResponseResult.getResponse().setData(count);
	}

	@DeleteMapping("/{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
}
