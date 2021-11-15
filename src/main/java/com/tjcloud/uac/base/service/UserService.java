package com.tjcloud.uac.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.auth.base.entity.AuthUser;
import com.tjcloud.core.exception.BusinessException;
import com.tjcloud.core.exception.ServiceException;
import com.tjcloud.core.service.AbstractService;
import com.tjcloud.uac.api.vo.UserMobileVO;
import com.tjcloud.uac.base.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 租户APP用户表(uac_user)
 * @author auto bin.yin 2016.05.10
 */
public interface UserService extends AbstractService<User, String> {
	Integer getUserCount(Map<String, Object> params);

	User findByAuthId(String authId);

	void createUser(User user);

	void createUserByEac(User user);

	User createUacUser(String authId, String name, String gender, String channel);

	void updateMobile(UserMobileVO userMobileVO);

	void createUserByMobile(String mobile);
	
	/**
	 * 使用运动豆支付
	 * @param userId
	 * @param amount
	 * @return
	 * @throws ServiceException
	 */
	boolean payYunDong(String userId, Long amount) throws ServiceException;
	
	/**
	 * 运动豆充值
	 * @param userId
	 * @param amount
	 * @return
	 * @throws ServiceException
	 */
	boolean addYunDongValue(String userId,Long amount) throws ServiceException;
	
	/**
	 * 会员卡支付
	 * @param userId
	 * @param tenantId
	 * @param cardNo
	 * @param amount
	 * @return
	 * @throws ServiceException
	 */
	boolean payMemberCard(String userId,String tenantId,String cardNo, Long amount) throws ServiceException;
	
	/**
	 * 会员卡充值
	 * @param userId
	 * @param tenantId
	 * @param cardNo
	 * @param amount
	 * @return
	 * @throws ServiceException
	 */
	boolean addMemberCardValue(String userId,String tenantId,String cardNo, Long amount) throws ServiceException;
	
	/**
	 * 根据authId 查询当前登录用户信息
	 * @param authId
	 * @return
	 * @throws ServiceException
	 */
	Map<String, Object> getUserStadiumItemRoles(String authId) throws ServiceException;
	
	/**
	 * 根据会员卡ID获取会员卡
	 * @param cardId
	 * @return
	 * @throws ServiceException
	 */
	JSONObject getByCardId(String cardId) throws ServiceException;

	User createByOldUserId(User user);
	
	JSONObject getMemberCardByCardNo(String tenantId, String cardNo);
	
	JSONObject getMemberCardByCardNo(String tenantId, String cardNo, String stadiumId);
	
	String getCardCategoryIdBSYX(String tenantId, String categoryName) throws BusinessException ;

	List<User> getUsers(List<String> ids);
	
	/**
	 * @Description:管理员重置密码
	 * @return JSONObject
	 * @author: lihz
	 * @time:2017年9月6日 下午6:39:56
	 */
	JSONObject changePassword(String userId, String password);
	
	User newCreateUser(AuthUser authUser);
	/**
	 * @Description:手机号和渠道创建新用户
	 * @return User
	 * @author: lihz
	 * @time:2018年1月3日 下午4:37:48
	 */
	User createUserByMobileAndChannel(String mobile, String channel);

	List<Map<String, Object>> getUserRoles(String userId);

	List<User> findByRoleParam(Map<String, Object> params);
	List<User> findByRole(String roleCode, String tenantId);
	List<User> findByRoles(String[] roleCodes, String tenantId);
	/**
	 * @Description:通过手机号查询签到用户
	 * @return User
	 * @author: lihz
	 * @time:2018年3月28日 上午11:20:52
	 */
	User selectRoleByPhone(String tenantId, String phone, List<String> roleIds);

	User getByPhone(String phone, String tenantId);
}
