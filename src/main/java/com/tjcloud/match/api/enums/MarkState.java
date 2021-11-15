package com.tjcloud.match.api.enums;

/**
 * 用户地标状态（0-未点亮,1-已点亮）
 * @author lucheng
 *
 */
public enum MarkState {

		MARK_STATE_NO ("未点亮", false),
		MARK_STATE_YES ("已点亮", true);

		private final String text;
		private final Boolean status;

		private MarkState(String text, Boolean status)
		{
			this.text = text;
			this.status = status;
		}

		public static String getText(Boolean status)
		{
			for (MarkState e : MarkState.values())
			{
				if (e.getStatus().equals(status))
				{
					return e.getText();
				}
			}
			return "";
		}

		public String getText()
		{
			return text;
		}

		public Boolean getStatus()
		{
			return status;
		}
}
