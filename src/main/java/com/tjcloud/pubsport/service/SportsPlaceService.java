package com.tjcloud.pubsport.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.page.PageParam;
import com.tjcloud.core.page.Pagination;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.dd.base.entity.City;
import com.tjcloud.pubsport.entity.SportsPlace;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 健身场所(ps_sports_place)
 * @author auto bin.yin 2018.02.22
 */
public interface SportsPlaceService extends AbstractService<SportsPlace, String> {
	List<String> findPlaceByPatrolman(String patrolman, String tenantId);
	List<String> findPlaceByRepairman(String repairman, String tenantId);

	JSONObject countPlaceAndMaterial(Map<String, Object> params);
	List<JSONObject> countPlaceGroupByType(Map<String, Object> params);

	List<JSONObject> searchSportsPlaceMap(Map<String, Object> params);

	List<JSONObject> findOpenList(Map<String, Object> params);

	Long findCount(Long createdTimeStart, Long createdTimeEnd, String tenantId);
	Long findCount(Map<String, Object> params);
	Long countByTenantId(String tenantId);

	List<JSONObject> findPlaceCities();
	List<JSONObject> findPlaceCities(String cityCode);
	List<JSONObject> findPlaceCityTrees();
	List<JSONObject> findPlaceCityTrees(String cityCode);
	List<JSONObject> findPlaceCityTrees(List<String> cityCodes);
	public JSONObject exportSportsPlace(JSONObject jsonObject);

	/**
	 * 公共体育设施导入
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public JSONObject   importSportsPlace(Map<String, Object> params) throws IOException;

	/**
	 * 指定导入公共体育设施数据
	 * @param params
	 * @return
	 * @throws IOException
	 */
	public JSONObject   zdImportSportsPlace(Map<String, Object> params) throws IOException;

	/**
	 * 社区体育设施数据汇总（设施名，数量）
	 * @param params
	 * @return
	 */
	List<JSONObject> searchSportsPlaceData(Map<String, Object> params);

	/**
	 * 分区体育设施数据汇总（面积，数量）
	 * @param params
	 * @return
	 */

	List<JSONObject> searchSubregionalSportsPlace(Map<String, Object> params);

	Pagination<JSONObject> searchEquipmentStatus(PageParam page, Map<String, Object> params);

    List<String> searchEquipmentRepairNumber(List<Integer> repairStatusList, Map<String, Object> params);

	List<JSONObject> searchEquipmentStatusBy(PageParam page, Map<String, Object> params);

	List<JSONObject> searchEquipmentStatusNum(Map<String, Object> params);

	JSONObject countByTypeId(Map<String, Object> params);

    List<JSONObject> limitFiveYearSpm(JSONObject params);

    List<JSONObject> queryAllAcreageByProjectType(JSONObject params);

	List<JSONObject> queryBeyondSpm(JSONObject params);

    long findScanCodeNum(JSONObject params);

    List<JSONObject> queryTextureTypes(Map<String, Object> params);

	Long queryNotNormalPlaceNum(Map<String, Object> params);

    List<JSONObject> querySportsGroupByTypeId(Map<String, Object> params);

	List<City> findPlaceCityGroupByStreet(Map<String, Object> param);

    List<SportsPlace> list(Map<String, Object> param);
}
