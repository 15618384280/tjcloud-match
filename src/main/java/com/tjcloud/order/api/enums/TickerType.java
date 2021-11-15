package com.tjcloud.order.api.enums;

/**
 * 券类型: 0-凭票、1-计时付费、2-计次
 * 
 * @author TJ_zhoupf
 *
 */
public enum TickerType {
	
		TICKER("凭票", 0),
		TIME("计时付费", 1),
		COUNT("计次", 2);

		private final String text;
		private final int status;

		private TickerType(String text, int status)
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
			for (TickerType e : TickerType.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
