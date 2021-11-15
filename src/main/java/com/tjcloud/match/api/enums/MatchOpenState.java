package com.tjcloud.match.api.enums;

/**
 * 公开状态（0-平台和线下都可见,1-仅线下可见）
 * @author TJ_zhoupf
 *
 */
public enum MatchOpenState {
	
		PLATFORM_SHOW ("平台和线下都可见", 0),
		LINE_SHOW ("仅线下可见", 1),
		PLATFORM_SHOW_SELF ("自己平台和线下都可见", 2),;
		
		private final String text;
		private final int status;

		private MatchOpenState(String text, int status)
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
			for (MatchOpenState e : MatchOpenState.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
