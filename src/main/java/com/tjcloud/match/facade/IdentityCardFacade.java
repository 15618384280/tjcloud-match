package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.IdentityCard;
import com.tjcloud.match.base.service.IdentityCardService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/identitys")
public class IdentityCardFacade extends AbstractFacade {
	private static final Logger logger = LoggerFactory.getLogger(IdentityCardFacade.class);

	@Autowired
	private IdentityCardService identityCardService;

	@GetMapping
	public ResponseResult query(HttpServletRequest request) throws BusinessException {
		Pagination<IdentityCard> dataList = getPagination(request, identityCardService);
		return ResponseResult.getResponse().setData(dataList);
	}

	@GetMapping("/{id:\\w+}")
	public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
		logger.debug("~~~~~ get param id = ({})", id);

		IdentityCard identityCard = identityCardService.get(id);
		return ResponseResult.getResponse().setData(identityCard);
	}

	@PostMapping
	public ResponseResult create(@RequestBody IdentityCard identityCard) throws BusinessException {
		logger.debug("~~~~~ post param = {}", JSON.toJSONString(identityCard));
		ValidateUtils.notNull(identityCard, MessageLocale.NOT_NULL);
		ValidateUtils.notEmpty(identityCard.getIdcard(), MessageLocale.EMPTY_CODE, "身份证号码不能为空");
		ValidateUtils.notEmpty(identityCard.getName(), MessageLocale.EMPTY_CODE, "姓名不能为空");
		IdentityCard data = identityCardService.verifyIdcardv(identityCard.getIdcard(), identityCard.getName());
		return ResponseResult.getResponse().setData(data);
	}


}
