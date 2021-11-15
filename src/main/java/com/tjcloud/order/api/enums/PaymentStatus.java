package com.tjcloud.order.api.enums;

/**
 * 订单状态: 1-未支付、2-已支付、3-退款,4-退款中,5-已改签,6-已关闭,7-已完成
 * @author TJ_zhoupf
 *
 */
public enum PaymentStatus {
	
		PENDING("待处理", 0),
		PAYABLE("未支付", 1),
		PAID("已支付", 2),
		REFUND("已退款", 3),
		REFUNDING("退款中", 4),
		MEAL("已改签", 5),
		CLOSE("已关闭", 6),
		FINISH("已完成", 7),;
		
		private final String text;
		private final int status;

		private PaymentStatus(String text, int status)
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
			for (PaymentStatus e : PaymentStatus.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
