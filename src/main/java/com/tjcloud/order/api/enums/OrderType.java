package com.tjcloud.order.api.enums;

/**
 * 订单类型: 1-场地预定、2-票券、3-赛事、4-教练、5-场馆长定、6-运动豆充值、7-会员卡充值、8-商品销售、9-第三方对接支付、
 * 10-培训、11-发票、12-共享场馆订单，13-扫码支付订单，14-游泳订单，15-会员卡工本费
 * 
 * @author TJ_zhoupf
 *
 */
public enum OrderType {
	
		STADIUM("场地预定", 1),
		TICKET("票券", 2),
		MATCH("赛事", 3),
		COACH("教练", 4),
		STADIUM_LONG("场馆长定", 5),
		YUNDOU_RECHARGE("运动豆充值", 6),
		CARD_RECHARGE("会员卡充值", 7),
		GOODS_SALE("商品销售", 8),
		ESCROW_ORDER_PAY("第三方对接支付", 9),
		TRAIN("培训", 10),
		INVOICE("发票",11),
		SHARE("共享场馆订单",12),
		CODE_PAY("扫码支付订单",13),
		TICKET_SWIM("游泳订单", 14),
		CARD_FEE("会员卡工本费", 15),
		STADIUM_CARD_ONLINE("线上场馆卡充值", 19),
		SHARE_TIMING("共享场馆计时订单",25),
		OTHER_INCOME("其他", 0);

		private final String text;
		private final int status;

		private OrderType(String text, int status)
		{
			this.text = text;
			this.status = status;
		}

		public String getText()
		{
			return text;
		}

		public int getStatus()
		{
			return status;
		}

		public static String getText(int status)
		{
			for (OrderType e : OrderType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
