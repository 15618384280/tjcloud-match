package com.tjcloud.order.api.enums;

/**
 * 退款状态,1-退款中,2-退款成功,3-退款失败
 * @author TJ_zhoupf
 *
 */
public enum RefundStatus {
	
		REFUND("退款中", 1),
		REFUND_SUCCESS("退款成功", 2),
		REFUND_FAIL("退款失败", 3),;
		
		private final String text;
		private final int status;

		private RefundStatus(String text, int status)
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
			for (RefundStatus e : RefundStatus.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
