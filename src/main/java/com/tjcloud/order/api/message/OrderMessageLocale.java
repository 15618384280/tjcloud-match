package com.tjcloud.order.api.message;

public abstract class OrderMessageLocale {
	//1080100-1080199
	public static final int ORDER_BOOKING_SUCCESS                        = 1080100; //订单预订中，请等待处理
	public static final int ORDER_BOOKING_FAILED                         = 1080101; //订单预订失败，请重新选择
	public static final int ORDER_IS_NULL                         		 = 1080102; //订单不能为空
	public static final int ORDER_DETAILS_IS_NULL						 = 1080103; //订单明细不能为空
	public static final int ORDER_ILLEGAL_PARAMETER						 = 1080104; //非法参数，请重新选择
	
	public static final int ORDER_FAIL_NOT_CANCEL						 = 1080105; //订单预定失败不能取消
	public static final int ORDER_PENDING_NOT_CANCEL					 = 1080106; //待处理订单不能取消
	public static final int ORDER_CLOSE_NOT_CANCEL						 = 1080107; //订单已关闭，不能重复取消
	public static final int ORDER_FULL_REFUND_NOT_CANCEL				 = 1080108; //订单已全额退款，不能取消
	public static final int ORDER_TYPE_IS_ERROR				 			 = 1080109; //订单类型错误，系统不能处理
	public static final int ORDER_CANCEL_IS_FAIL			 			 = 1080110; //订单取消失败
	public static final int ORDER_REFUND_STATUS_NOT_CANCEL			 	 = 1080111; //已退款订单明细不能取消
	public static final int ORDER_REFUNDING_STATUS_NOT_CANCEL			 = 1080112; //退款中订单明细不能取消
	public static final int ORDER_MEAL_STATUS_NOT_CANCEL			 	 = 1080113; //已改签订单明细不能取消
	public static final int ORDER_CLOSE_STATUS_NOT_CANCEL			 	 = 1080114; //已关闭订单明细不能取消
	public static final int ORDER_EXCEPTION_DATA_NOT_CANCEL			 	 = 1080115; //订单异常数据不能取消
	
	public static final int ORDER_IS_NOT_PAYABLE			 	 		 = 1080116; //订单不是待支付状态
	public static final int ORDER_PAYMENT_TYPE_NOT_EXISTED			 	 = 1080117; //订单支付类型不存在
	public static final int ORDER_NOT_REPEAT_PAY			 	 		 = 1080118; //订单不能重复支付
	public static final int ORDER_TENPAY_FAILED			 	 		 	 = 1080119; //微信支付失败，请选择其它支付方式
	public static final int ORDER_TENPAY_TYPE_ERROR			 	 		 = 1080120; //微信交易类型错误
	public static final int ORDER_ALIPAY_FAILED			 	 		 	 = 1080121; //支付宝支付失败，请选择其它支付方式
	public static final int ORDER_PAYMENT_CALLBACK_TYPE_NOT_EXISTED		 = 1080122; //订单支付回调类型不存在
	public static final int ORDER_ALIPAY_CALLBACK_FAILED			 	 = 1080123; //订单支付宝支付回调失败
	public static final int ORDER_FIELD_PRICE_FAILED			 	 	 = 1080124; //获取资源价格失败
	public static final int ORDER_REFUND_EXCEPTION			 	 		 = 1080125; //订单退款异常
	public static final int ORDER_COUPON_AMOUNT_IS_NEGATIVE			 	 = 1080126; //订单红包金额为负数
	public static final int ORDER_REFUNDABLE_AMOUNT_IS_NEGATIVE			 = 1080127; //订单红包金额为负数
	public static final int ORDERS_DID_NOT_PAY_SUCCESS_NOT_REFUNDED		 = 1080128; //订单没有支付成功不能退款
	public static final int ORDERS_LONG_RULES_NOT_NULL	 				 = 1080129; //订单长订规则不能为空
	public static final int ORDERS_LONG_RULES_ITEM_NOT_NULL		 		 = 1080130; //订单长订规则明细不能为空
	public static final int ORDERS_DETAIL_FIELD_NOT_NULL		 		 = 1080131; //场地预定明细不能为空
	
	
	public static final int ORDER_YUNDONGPAY_FAILED			 	 		 = 1080132; //运动豆支付失败，请选择其它支付方式
	public static final int ORDER_YUNDONGREFUND_FAILED			 	     = 1080133; //运动豆退款失败，请选择其它支付方式
	public static final int ORDERS_SPORTS_RECHARGE_NOT_CANCELED			 = 1080134; //运动豆充值订单不能取消
	public static final int ORDERS_SPORTS_RECHARGE_NOT_REFUND			 = 1080135; //运动豆充值订单不能退款
	
	public static final int ORDER_MEMBERCARD_PAY_FAILED			 	 	 = 1080136; //会员卡支付失败，请选择其它支付方式
	public static final int MEMBER_CARD_NOT_NULL			 	 	     = 1080137; //会员卡号不能为空
	public static final int ORDER_MEMBERCARD_REFUND_FAILED			 	 = 1080138; //会员卡退款失败，请选择其它支付方式
	public static final int ORDER_TYPE_NOT_EXISTED			 			 = 1080139; //订单类型不存在
	public static final int ORDER_OF_OTHERS_NOT_CANCEL			 		 = 1080140; //不能取消他人订单
	public static final int ORDER_NOT_PERMISSION_CANCEL			 		 = 1080141; //没有权限取消订单
	public static final int ORDER_RESERVE_FAIL			 		 		 = 1080142; //下单失败，请重新下单
	public static final int ORDER_RESERVE_PENDING			 		 	 = 1080143; //订单处理中，请稍候支付
	public static final int ORDER_INTERSECTION_OF_TIME					 = 1080144; //订单时间有交集
	public static final int ORDER_RESOURCE_DATE_NOT_NULL				 = 1080145; //订单日期不能为空
	public static final int ORDERS_LONG_RULES_NOT_CANCELED			 	 = 1080146; //长订订单不能取消
	public static final int ORDERS_LONG_RULES_NOT_REFUND			     = 1080147; //长订订单不能退款
	public static final int ORDERS_LONG_RULES_NOT_PAYBACK			     = 1080148; //长订订单不能支付回调
	public static final int MEMBER_CATEGORY_ID_NOT_NULL			 	 	 = 1080149; //会员ID不能为空
	public static final int ORDER_FIELD_OF_OCCUPIED					 	 = 1080150; //哎呀...手慢了，场地被别人抢走了！
	public static final int ORDER_TENPAY_CALLBACK_FAILED			 	 = 1080151; //订单微信支付回调失败
	public static final int ORDERS_CARD_RECHARGE_NOT_NULL		 		 = 1080152; //会员卡充值明细不能为空
	public static final int ORDERS_CARD_INFO_NULL		 		 		 = 1080153; //会员卡信息为空
	public static final int ORDER_CASH_FAILED			 	 		 	 = 1080154; //线下支付失败
	public static final int ORDER_INFO_IS_EMPTY                          = 1080155; //订单信息不存在
	public static final int ORDERS_USER_HAVE_NO_PAY		 		 		 = 1080156; //有未支付订单，不能下单
	public static final int ORDER_OF_OTHERS_NOT_CONFIRM			 		 = 1080157; //不能确认其他场馆订单
	public static final int ORDER_NOT_FIND_STADIUM_ITEM			 		 = 1080158; //未找到场地信息
	public static final int ORDER_NOT_HAVE_CANCEL_TIME			 		 = 1080159; //已过退订时间
	public static final int ORDER_CHANNEL_NOT_EXISTED			 		 = 1080160; //订单来源渠道不存在
	public static final int ORDER_NOT_PERMISSION_CANCEL_YYD			 	 = 1080161; //您无权操作平台订单
	public static final int FIELD_RESOURCE_IS_NULL					 	 = 1080162; //本场馆当前不可预定{}订单
	public static final int FIELD_CANNOT_ORDER						 	 = 1080163; //{},{}-{} 不可预订
	public static final int MEMBERCARD_INFO_ERROR						 = 1080164; //获取会员卡信息失败
	public static final int LONG_ORDER_RULE_ISEXIST						 = 1080165; //{},{}-{}已被长订
	public static final int LONG_ORDER_RULE_ISNULL						 = 1080166;	//获取订单信息异常
	public static final int LONG_ORDER_EXCEPTION_ISNULL					 = 1080167;	//请补全微调信息
	public static final int LONG_ORDER_EXCEPTION_TYPE_ERROR				 = 1080168;	//请选择调整类型
	public static final int LONG_ORDER_NO_RECORD	  					 = 1080169;	//{},{},{}-{} 未检测到此长订信息
	public static final int LONG_ORDER_EXCEPTION_ISNOT_EXIST			 = 1080170;	//微调信息不存在，请重新选择	
	public static final int LONG_ORDER_EXCEPTION_IS_EXIST			     = 1080171;	//微调信息已存在，请重新选择
	public static final int MEMBERCARD_BALANCE_PAY_FAILED			     = 1080172;	//会员卡余额不足
	public static final int TICKET_ORDER_ENTRANCE_CODE_IS_EMPTY			 = 1080173;	//请输入入场码
	public static final int TICKET_ORDER_ENTRANCE_CODE_IS_ERROR			 = 1080174;	//无效的入场码
	public static final int TICKET_IS_ENTRANCE          				 = 1080175;	//存在已入场的票劵退订失败
	public static final int ORDER_ALIPAY_TYPE_ERROR			 	 		 = 1080176; //支付宝交易类型错误
	public static final int NOT_FOUND_ESCROW_ORDER						 = 1080177; //找不到第三方订单
	public static final int ESCROW_TYPE_IS_NULL				 			 = 1080178; //第三方类型为空
	public static final int ESCROW_ORDER_NO_IS_NULL						 = 1080179; //第三方订单号为空
	public static final int STADIUM_IS_OUTLINE							 = 1080180; //场馆已下线
	public static final int STADIUM_CHANNEL_IS_OUTLINE					 = 1080181; //该场馆已在本平台下线
	public static final int STADIUM_NOT_EXIST							 = 1080182; //场馆信息有误，请联系管理员。
	public static final int STADIUM_REPAIR_MANY_IMES					 = 1080183; //报修多次，等待维修
	
	//1080200-1080299
	public static final int STADIUM_ACCOUNT_NOT_EXIST					 = 1080200; //场馆帐号不存在
	public static final int TENANT_ACCOUNT_NOT_EXIST					 = 1080201; //租户帐号不存在
	public static final int STADIUM_ID_NOT_NULL					 		 = 1080202; //场馆ID不为空
	public static final int TENANT_ID_NOT_NULL						     = 1080203; //获取租户信息失败
	public static final int AMOUNT_MUST_GREATER_THAN_ZERO				 = 1080204; //金额必须大于零
	//1080300-1080399
	public static final int PARAM_ABSENT_ERROR					 		 = 1080300; //缺省参数错误
    public static final int ORDER_REPORT_NO_DATA					     = 1080301; //没有数据
    public static final int NO_SUPERADMIN_PERMISSIONS                    = 1080302; //不是超级管理员权限
    
    public static final int ORDERS_GOODS_NOT_NULL		 		 		 = 1080401; //商品不能为空
	public static final int ORDERS_GOODS_NOT_CANCELED			 		 = 1080402; //商品销售订单不能取消
	public static final int ORDERS_GOODS_NOT_REFUND						 = 1080403; //商品销售订单不能退款
	
	public static final int ORDERS_BALANCE_INSUFFICIENT					 = 1080405; //余额不够，退款失败
	public static final int INVOICE_BALANCE_INSUFFICIENT				 = 1080406; //可开发票金额不足，申请失败
	public static final int STOP_BANLANCE_PAY				 			 = 1080407; //非常抱歉！系统升级，运动豆相关功能即将上线，敬请谅解。
	public static final int STOP_INVOICE_PAY				 			 = 1080408; //非常抱歉！系统升级，发票相关功能即将上线，敬请谅解。
	public static final int TICKET_SOLD_OUT				 			 	 = 1080409; //票劵已售完
	public static final int ORDER_RECHARGE_ERROR				 		 = 1080410; //操作失败！请重试！
	
	public static final int ALIPAY_BALANCE_INSUFFICIENT					 = 1080415; //支付宝余额不够，退款失败
	public static final int APP1YDTENPAY_BALANCE_INSUFFICIENT			 = 1080416; //要运动APP微信账户余额不够，退款失败
	public static final int WX1YDTENPAY_BALANCE_INSUFFICIENT			 = 1080417; //要运动公众号微信账户余额不够，退款失败
	public static final int ZJGAPP_BALANCE_INSUFFICIENT			 		 = 1080418; //张家港APP微信账户余额不够，退款失败
	public static final int TX1YD_BALANCE_INSUFFICIENT			 		 = 1080419; //天翔公众号微信账户余额不够，退款失败
}
