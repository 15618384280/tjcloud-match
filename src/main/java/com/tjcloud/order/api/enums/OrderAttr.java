package com.tjcloud.order.api.enums;

/**
 * 订单归属:1-要运动、2-租户
 * @author TJ_zhoupf
 *
 */
public enum OrderAttr {
	
		YYD ("要运动", 1),
		TENANT ("租户", 2),;
		
		private final String text;
		private final int status;

		private OrderAttr(String text, int status)
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
			for (OrderAttr e : OrderAttr.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
