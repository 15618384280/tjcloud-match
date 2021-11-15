package com.tjcloud.match.api.message;

public abstract class MatchMessageLocale {
	//2010100-2010199
	public static final int TENANT_IS_NULL                         		 = 2010100; //租户不能为空
	public static final int MATCH_IS_ERROR                         		 = 2010101; //赛事ID错误
	public static final int PARAM_IS_ERROR                         		 = 2010102; //参数错误
	public static final int SUBJECT_IS_ERROR                         	 = 2010103; //科目ID错误
	public static final int TEAM_IS_ERROR                         	     = 2010104; //团队ID错误
	public static final int PLAYERS_IS_ERROR                         	 = 2010105; //选手ID错误
	public static final int SIGN_RECORD_IS_ERROR                         = 2010106; //参赛记录ID错误
	public static final int DATA_EMPTY                         		 	 = 2010107; //记录为空
	public static final int EXCEL_MODEL_IS_ERROR						 = 2010108; //EXCEL模板错误
    public static final int EXCEL_INFO_IS_ERROR 						 = 2010109; //EXCEL信息错误
    public static final int SIGN_FIELD_MISSING 							 = 2010110; //缺少{}报名字段
    public static final int SIGN_FIELD_EDITABLE							 = 2010111; //报名字段不可编辑
    public static final int SIGN_FIELD_DONTDEL							 = 2010112; //系统定义的报名字段不可删除
    public static final int SUBJECT_TYPE_EDITABLE						 = 2010113; //赛制类型不能修改
	public static final int ORDER_ALIPAY_CALLBACK_FAILED			 	 = 2010114; //订单支付宝支付回调失败
	public static final int ORDER_TENPAY_CALLBACK_FAILED			 	 = 2010115; //订单微信支付回调失败
	public static final int ORDER_PAYMENT_TYPE_NOT_EXISTED			 	 = 2010116; //订单支付类型不存在
	public static final int ORDER_TENPAY_FAILED			 	 		 	 = 2010117; //微信支付失败，请选择其它支付方式
	public static final int ORDER_ALIPAY_FAILED			 	 		 	 = 2010118; //支付宝支付失败，请选择其它支付方式
    public static final int QUERY_PARAM_IS_NULL						 	 = 2010119; //查询条件不能为空
    public static final int SUBJECT_SIGN_PLUMP 							 = 2010120; //报名已满
    public static final int SUBJECT_NOT_TEAM 							 = 2010121; //不是团体赛

	public static final int MATCH_SIGN_CANT_CANCEL         			     = 2010122; //订单不能取消
	public static final int MATCH_SIGN_CANT_DELETE         			     = 2010123; //报名记录不能删除
	public static final int TEAM_SIGN_CANT_DELETE         			     = 2010124; //报名团队不能删除
	public static final int CAPTAIN_CANT_DELETE         			     = 2010125; //只能删除团队时删除队长
	public static final int MATCH_IS_SIGNING         			    	 = 2010126; //您已经报名该赛事
	public static final int TEAM_NAME_EMPTY         			         = 2010127; //团队名称为空
	public static final int TEAM_IS_SIGNING         			    	 = 2010128; //团队名已存在
	public static final int MEMBER_IS_DUPLICATE         			     = 2010129; //队员重复
	public static final int LESS_THAN_ENROLLMENT         			     = 2010130; //小于已报名人数

}
