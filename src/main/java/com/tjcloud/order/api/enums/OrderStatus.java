package com.tjcloud.order.api.enums;

/**
 * 订单状态: 0-预定失败,1-待处理,2-待支付,3-已支付,4-已关闭,5-部分退款,6-全额退款
 * @author TJ_zhoupf
 *
 */
public enum OrderStatus {
	
		FAIL("下单失败", 0),
		PENDING("待处理", 1),
		PAYABLE ("待支付", 2),
		PAID("已支付", 3),
		CLOSE("已关闭", 4),
		PART_REFUND ("部分退款", 5),
		FULL_REFUND ("全额退款", 6),;
		
		private final String text;
		private final int status;

		private OrderStatus(String text, int status)
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
			for (OrderStatus e : OrderStatus.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
