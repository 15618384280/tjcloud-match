package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.MatchRqCode;
import com.tjcloud.match.base.service.MatchRqCodeService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/matchs/rqcode")
public class MatchRqCodeFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(MatchRqCodeFacade.class);

	@Autowired
	private MatchRqCodeService matchRqCodeService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<MatchRqCode> dataList = getPagination(request, matchRqCodeService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		MatchRqCode matchRqCode = matchRqCodeService.get(id);
		return ResponseResult.getResponse().setData(matchRqCode);
	}

	@PostMapping
	public ResponseResult create(@RequestBody MatchRqCode matchRqCode) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchRqCode));

		ValidateUtils.notNull(matchRqCode, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(matchRqCode.getId(), MessageLocale.NOT_EMPTY);
		MatchRqCode data = matchRqCodeService.create(matchRqCode);
		return ResponseResult.getResponse().setData(data);
	}

	@PutMapping
	public ResponseResult modify(@RequestBody MatchRqCode matchRqCode) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchRqCode));

		ValidateUtils.notNull(matchRqCode, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(matchRqCode.getId(), MessageLocale.NOT_EMPTY);
		int count = matchRqCodeService.modify(matchRqCode);
		
		return ResponseResult.getResponse().setData(count);
	}

	@DeleteMapping("{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
}
