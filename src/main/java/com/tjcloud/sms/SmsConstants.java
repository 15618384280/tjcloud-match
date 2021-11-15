package com.tjcloud.sms;

public abstract class SmsConstants {
	public static final String SMS_CHANNEL_DEFAULT       = "TAOBAO";
	public static final String SMS_FORMAT_SIGN           = "【%s】";

	public class Channel {
		public static final String SMS_CHANNEL_TAOBAO    = "TAOBAO";
		public static final String SMS_CHANNEL_CCP       = "CCP";
	}

	public class TAOBAO {
		//正式环境	http://gw.api.taobao.com/router/rest	https://eco.taobao.com/router/rest
		//沙箱环境	http://gw.api.tbsandbox.com/router/rest	https://gw.api.tbsandbox.com/router/rest
		public static final String SMS_TAOBAO_API_URL    = "https://eco.taobao.com/router/rest";
		public static final String SMS_TAOBAO_APP_KEY    = "23416705";
		public static final String SMS_TAOBAO_APP_SECRET = "c8923b4c231ff7c7441c5a180e31d33f";
	}

	public class CCP {
		public static final String SMS_CCP_HOST          = "app.cloopen.com"; //test "sandboxapp.cloopen.com";
		public static final String SMS_CCP_PORT          = "8883";
		public static final String SMS_CCP_SID           = "aaf98f89506fc2f0015092a5ed91229d";
		public static final String SMS_CCP_TOKEN         = "c44471a5c34f49d4bdd5cf125fbe3c9a";
		public static final String SMS_CCP_APPID         = "aaf98f89524954cc0152535666e811d8";
		public static final String SMS_CCP_SUCCESS_CODE  = "000000";
	}
}
