package com.tjcloud.order.api.enums;

/**
 * 第三方归属:1-携程
 * 2-阿里
 * 3-上海体育局
 * 4-京东体育
 */
public enum EscrowOrderEnums {
	
		CTRIP ("携程", 1),
		ALISPORTS ("阿里体育", 2),
		SPORTSBUREAU("上海体育局",3),
		JDSPORTS("京东体育",4),
		MAPSPORTS("健身地图",5),
		YPMAPSPORTS("杨浦健身地图",6),
		JDMAPSPORTS("嘉定健身地图",7),
		OLDPLATFORM("老平台", 9);
		
		private final String text;
		private final int status;

		private EscrowOrderEnums(String text, int status)
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
			for (EscrowOrderEnums e : EscrowOrderEnums.values())
			{
				if (e.getStatus() == status)
				{
					return e.getText();
				}
			}
			return "";
		}
}
