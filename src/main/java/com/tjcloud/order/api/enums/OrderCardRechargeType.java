package com.tjcloud.order.api.enums;

/**
 * 订单充值卡类型: 1-充值卡,2-次卡
 * @author TJ_zhoupf
 *
 */
public enum OrderCardRechargeType {
	
		RECHARGE_CARD("充值卡", 1),
		TIMES_CARD("次卡", 2);
		
		private final String text;
		private final int status;

		private OrderCardRechargeType(String text, int status)
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
			for (OrderCardRechargeType e : OrderCardRechargeType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
