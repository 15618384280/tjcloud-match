package com.tjcloud.match.facade;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.message.MessageLocale;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.response.ResponseResult;
import com.tjcloud.core.utils.ValidateUtils;
import com.tjcloud.match.base.entity.MatchSlogan;
import com.tjcloud.match.base.service.MatchSloganService;
import com.tjcloud.web.facade.AbstractFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/matchSlogan")
public class MatchSloganFacade extends AbstractFacade {
    private static final Logger logger = LoggerFactory.getLogger(MatchSloganFacade.class);

    /**
     * 服务对象
     */
    @Autowired
    private MatchSloganService matchSloganService;

    /**
     * 分页查询列表
     * @param request
     */
    @GetMapping
    public ResponseResult query(HttpServletRequest request) throws BusinessException {
        Pagination<MatchSlogan> dataList = getPagination(request, matchSloganService);
        return ResponseResult.getResponse().setData(dataList);
    }

    /**
     * 搜索列表
     * @param json
     */
    @PostMapping("/search")
    public ResponseResult query(@RequestBody JSONObject json, HttpServletRequest request) throws BusinessException {
        json.put("disabled", false);
        List<MatchSlogan> dataList = matchSloganService .findBy(json);
        return ResponseResult.ok().setData(dataList);
    }

    /**
     * 通过主键查询单条数据
     * @param id 主键
     */
    @GetMapping("{id:\\w+}")
    public ResponseResult get(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ get param id = ({})", id);

        MatchSlogan matchSlogan = matchSloganService .get(id);
        return ResponseResult.getResponse().setData(matchSlogan);
    }

    /**
     * 创建
     * @param matchSlogan
     */
    @PostMapping
    public ResponseResult create(@RequestBody MatchSlogan matchSlogan) throws BusinessException {
        logger.debug("~~~~~ post param = {}", JSON.toJSONString(matchSlogan));

        ValidateUtils.notNull(matchSlogan, MessageLocale.NOT_NULL);
        MatchSlogan data = matchSloganService .create(matchSlogan);
        return ResponseResult.getResponse().setData(data);
    }

    /**
     * 修改
     * @param matchSlogan
     */
    @PutMapping
    public ResponseResult modify(@RequestBody MatchSlogan matchSlogan) throws BusinessException {
        logger.debug("~~~~~ put param = {}", JSON.toJSONString(matchSlogan));

        ValidateUtils.notNull(matchSlogan, MessageLocale.NOT_NULL);
        ValidateUtils.notEmpty(matchSlogan .getId(), MessageLocale.NOT_EMPTY);
        int count = matchSloganService. modify(matchSlogan);

        return ResponseResult.getResponse().setData(count);
    }

    /**
     * 通过主键删除单条数据
     * @param id 主键
     */
    @DeleteMapping("/{id:\\w+}")
    public ResponseResult remove(@PathVariable("id") String id) throws BusinessException {
        logger.debug("~~~~~ delete param id = ({})", id);
        MatchSlogan data = new MatchSlogan();
        data. setId(id);
        data. setDisabled(true);
        return ResponseResult.getResponse().setData(matchSloganService .remove(id));
    }
}
