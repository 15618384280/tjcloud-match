package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.SignRecordFieldTable;
import com.tjcloud.match.base.service.SignRecordFieldTableService;
import com.tjcloud.web.annotation.AllowAnonymous;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/match/signs")
public class SignRecordFieldTableFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(SignRecordFieldTableFacade.class);

	@Autowired
	private SignRecordFieldTableService signRecordFieldTableService;

	@AllowAnonymous
	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<SignRecordFieldTable> dataList = getPagination(request, signRecordFieldTableService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@AllowAnonymous
	@GetMapping("{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		SignRecordFieldTable signRecordFieldTable = signRecordFieldTableService.get(id);
		return ResponseResult.getResponse().setData(signRecordFieldTable);
	}

	@AllowAnonymous
	@PostMapping
	public ResponseResult create(@RequestBody SignRecordFieldTable signRecordFieldTable) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(signRecordFieldTable));

		ValidateUtils.notNull(signRecordFieldTable, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(signRecordFieldTable.getId(), MessageLocale.NOT_EMPTY);
		SignRecordFieldTable data = signRecordFieldTableService.create(signRecordFieldTable);
		return ResponseResult.getResponse().setData(data);
	}

	@AllowAnonymous
	@PutMapping
	public ResponseResult modify(@RequestBody SignRecordFieldTable signRecordFieldTable) throws BusinessException {
		logger.debug("~~~~~ put param = {}", JSON.toJSONString(signRecordFieldTable));

		ValidateUtils.notNull(signRecordFieldTable, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(signRecordFieldTable.getId(), MessageLocale.NOT_EMPTY);
		int count = signRecordFieldTableService.modify(signRecordFieldTable);
		
		return ResponseResult.getResponse().setData(count);
	}

	@AllowAnonymous
	@DeleteMapping("{id:\\w+}")
	public void remove(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ delete param id = ({})", id);
	}
}
