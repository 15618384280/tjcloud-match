package com.tjcloud.face.facade;


import com.alibaba.fastjson.JSON;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.face.base.entity.FaceWarnLoc;
import com.tjcloud.face.base.service.FaceWarnLocService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/faces/warnloc")
public class FaceWarnLocFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(FaceWarnLocFacade.class);

    @Autowired
    private FaceWarnLocService faceWarnLocService;

    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<FaceWarnLoc> dataList = getPagination(request, faceWarnLocService);
        return ResponseResult.getResponse().setData(dataList);
    }

    @GetMapping("/{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        FaceWarnLoc faceWarn = faceWarnLocService.get(id);
        return ResponseResult.getResponse().setData(faceWarn);
    }

    @PostMapping
    public ResponseResult create(@RequestBody FaceWarnLoc faceWarn) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(faceWarn));

        ValidateUtils.notNull(faceWarn, MessageLocale.NOT_NULL);
        //ValidateUtils.notEmpty(faceWarn.getId(), MessageLocale.NOT_EMPTY);
        FaceWarnLoc data = faceWarnLocService.create(faceWarn);
        return ResponseResult.getResponse().setData(data);
    }

    @PutMapping
    public ResponseResult modify(@RequestBody FaceWarnLoc faceWarn) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(faceWarn));

        ValidateUtils.notNull(faceWarn, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(faceWarn.getId(), MessageLocale.NOT_EMPTY);
        int count = faceWarnLocService.modify(faceWarn);

        return ResponseResult.getResponse().setData(count);
    }

    @DeleteMapping("/{id:\\w+}")
    public void remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
    }
}
