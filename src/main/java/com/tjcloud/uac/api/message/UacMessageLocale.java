package com.tjcloud.uac.api.message;

/**
 * 1050100-1050999
 * @author apple
 */
public abstract class UacMessageLocale {
	// 1050100-1050199 ctrl+shift+u 大小写转换
	public static final int HOLIDAY_DATE_CONFLICT                         = 1050100; // 日期时间有冲突
	public static final int HOLIDAY_DATETYPE_NOT_NULL                     = 1050101; // 日期类型不能为空
	public static final int RESOURSE_IS_NULL                              = 1050102; // 资源为空
	public static final int HOLIDAY_ID_NOT_NULL                           = 1050103; // 日期ID不为空
	public static final int CODE_IS_NOT_RIGHT                             = 1050104; // 注册验证码错误
	public static final int MOBILE_EXIST                                  = 1050105; // 注册手机号重复
	public static final int TREE_IS_NULL                                  = 1050106; // 菜单树没有数据
	public static final int TENANT_USER_ID_IS_NULL                        = 1050107; // 用户id不能为空
	public static final int ROLE_ID_IS_NULL                               = 1050108; // 角色ID不能为空
	public static final int RECHARGE_CARD_GROUP_NUMBER_NOT_NULL           = 1050109; // 卡数量不能为空
	public static final int RECHARGE_CARD_GROUP_NUMBER_PERAMOUNT_NOT_NULL = 1050110; // 卡金额不能为空
	public static final int RECHARGE_CARD_GROUP_ID_NOT_NULL               = 1050111; // 卡组ID不能为空
	public static final int RECHARGE_CARD_ID_NOT_NULL                     = 1050112; // 卡ID不能为空
	public static final int PLATFORM_CANNOT_CREATE_TENANTUSER             = 1050113; // 平台用户不能创建商户用户
	public static final int RECHARGE_CARD_GROUP_STARTTIME_NOT_NULL        = 1050114; // 卡组开始时间不能为空
	public static final int RECHARGE_CARD_GROUP_ENDTIME_NOT_NULL          = 1050115; // 卡组结束时间不能为空
	public static final int RECHARGE_CARD_STARTTIME_NOT_NULL              = 1050116; // 卡开始时间不能为空
	public static final int RECHARGE_CARD_ENDTIME_NOT_NULL                = 1050117; // 卡结束时间不能为空
	public static final int LOAD_RESOURCE_BY_AUTH_ID_FAILED               = 1050118; // 资源同步失败
	public static final int MOBILE_IS_NULL								  = 1050119; // 资源同步失败
	public static final int TENANT_ID_IS_NULL							  = 1050120; // 租户id不能为空
    public static final int CAS_USERNAME_NOT_NULL                         = 1050121; // CAS用户名不能为空
    public static final int CAS_PASSWORD_NOT_NULL                         = 1050122; // CAS密码不能为空
    public static final int ROLE_OPERATION_IS_EMPTY                       = 1050123;

	// 1050200-1050299
	public static final int LACK_OF_BALANCE_OF_SPORTS_BEANS               = 1050200; // 运动豆余额不足
	public static final int AUTH_ID_IS_NULL                               = 1050201; // authId为空
	public static final int TENANT_USER_CANNOT_CREATE_PLATFORM_USER       = 1050202; // 租户用户无法创建平台用户
	public static final int NO_TENANT_USER                                = 1050203; // 无此管理权限

	public static final int ONLY_ADMIN_CAN_MODIFY_HIMSELF                 = 1050204; // 无权限修改管理员
	public static final int NO_ACCESS_MODIFY_ROLE		                  = 1050205; // 没有权限修改该角色
	public static final int ALREADY_HAS_TENANT_USER   			          = 1050206; // 该用户已经创建过租户用户
	public static final int ALREADY_HAS_PLATFORM_USER   	              = 1050207; // 该用户已经创建过平台用户
	public static final int NO_PERMISSIONS   	              		      = 1050208; // 您没有此操作权限
	public static final int ROLE_TYPE_IS_NULL   	              		  = 1050209; // 当前用户角色无角色，请联系管理员
	public static final int MSG_HAS_PUSH   	              		          = 1050210; // 信息已推送，无法修改
	public static final int MSG_TYPE  	              		          	  = 1050211; // 请选择推送类型：全局推送还是精准推送
	public static final int NO_TEMPLATE                		          	  = 1050212; // 对不起，没有相匹配的模板数据！
	public static final int NO_MESSAGE                		          	  = 1050213; // 请选择模板或者填写推送信息！
	public static final int NO_PUSH_TIME                		          = 1050214; // 请填写定时推送的时间
	public static final int NO_PUSH_RECIVER                		          = 1050215; // 请勾选推送人！
	public static final int MOBILE_HAS_EXIST                		      = 1050216; //当前修改的手机号已经存在！
	public static final int OPENID_IS_EMPTY                		          = 1050217; //openId为空
	public static final int AUTH_IS_NULL                		          = 1050218; //此openId下没有用户
	public static final int TENANT_ADMIN_CANNOT_DEL           		      = 1050219; //租户管理员不能删除
	public static final int USER_NOT_PIPEI                     		      = 1050220; //用户不匹配，无法绑定！
	public static final int ID_IS_NULL                       		      = 1050221; //ID为空
	public static final int INVOICE_ARRRESS_IS_NULL                       = 1050222; //发票邮寄地址为空
	public static final int INVOICE_TITLE_IS_NULL           		      = 1050223; //发票抬头信息为空
	public static final int INVOICE_AMOUNT_IS_NULL           		      = 1050224; //发票金额为空
	public static final int INVOICE_AMOUNT_MORE_THAN           		      = 1050225; //发票金额应大于100
	public static final int INVOICE_HAS_SEND                 		      = 1050226; //已寄送不可撤销
	public static final int FREQUENCYS_SIZE_IS_NULL       		          = 1050227; //寄送频率
	public static final int DELETE_USER_NOT_ALLOW       		          = 1050228; //无权删除自己，请联系管理员。
	public static final int FIND_USER_ERROR			       		          = 1050229; //用户信息异常，请联系管理员。
	public static final int FIND_USER_INFO_IS_NULL			       		  = 1050230; //无此用户信息
	public static final int FIND_MOBILE_IS_NULL			       		 	  = 1050231; //请输入手机号
	// 1050300-1050399 // 此号段请勿使用

	// 1050400-1050499 // 此号段请勿使用
}
