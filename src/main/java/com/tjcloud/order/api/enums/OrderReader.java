package com.tjcloud.order.api.enums;

/**
 * 订单状态: 0-232进A,1-232出B,2-485A,3-485B
 * @author TJ_zhoupf
 *
 */
public enum OrderReader {
	
		ZERO("232进A", 0),
		ONE("232出B", 1),
		TWO ("485A", 2),
		THREE("485B", 3),;
		
		private final String text;
		private final int status;

		private OrderReader(String text, int status)
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
			for (OrderReader e : OrderReader.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
