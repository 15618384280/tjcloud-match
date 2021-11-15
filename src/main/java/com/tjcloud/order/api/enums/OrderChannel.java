package com.tjcloud.order.api.enums;

import com.tjcloud.core.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 订单来源:1-WEB、2-租户后台、3-大众点评、4-口碑、5-IOS、6-Android，7-上海银行，8-微信，9-宝山羽协，10-手机，11-其他
 * @author TJ_zhoupf
 *
 */
public enum OrderChannel {
	WEB("WEB", 1),
	TENANT("租户后台", 2),
	DIANPING("大众点评", 3),
	KOUBEI("口碑", 4),
	IOS("IOS", 5),
	ANDROID("Android", 6),
	SH_BANK("上海银行", 7),
	WEIXIN("微信", 8),
	BS_BADMINTON("宝山羽协", 9),
	MOBILE_PHONE("手机", 10),
	OTHER("其他", 11),
	V2WEB("V2网页", 12),
	CTRIP("携程", 13),
	BAIDU_NUOMI("百度糯米", 14),
	PLATFORM_ADMIN("平台管理员", 15),
	WEIXIN_APP("微信小程序", 16),
	CODE_PAY("扫码支付", 17),
	ALI_SPORTS("阿里体育", 18),
	SCHOOL_PROGRAM("学校开放小程序", 19),
	JD_SPORTS("京东体育", 20),
	HF_SPORTS_MINI("运动合肥小程序", 21),
	HF_SPORTS_APP("运动合肥App", 22),
	SF("商飞", 23),
	XM_ANDROID("运动厦门Android", 24),
	XM_IOS("运动厦门IOS", 25),
	XM_MINI("运动厦门小程序", 26),

	MAP_SPORTS("健身地图", 27),
	MAP_SPORTS_YWTB_WX_MP("健身地图-一网通办微信小程序", 271),
	MAP_SPORTS_YWTB_ZHF_MP("健身地图-一网通办支付宝小程序", 272),
	MAP_SPORTS_YWTB_APP("健身地图-一网通办APP", 273),

	BANGLE_MACHINE("手环机",28),
	YP_MAP_MINI("杨浦健身地图",29),
	YD_EXCHANGE("移动积分兑换运动豆",30),
	JD_MAP_MINI("嘉定健身地图",31),
	ZFB_SPORTS("阿里体育", 32);

	private static final OrderChannel[] MAP_SPORTS_CHANNELS = new OrderChannel[]{
			MAP_SPORTS,
			MAP_SPORTS_YWTB_WX_MP,
			MAP_SPORTS_YWTB_ZHF_MP,
			MAP_SPORTS_YWTB_APP
	};

	private final String text;
	private final int status;

	private OrderChannel(String text, int status) {
		this.text = text;
		this.status = status;
	}
	public String getText() {
		return text;
	}
	public int getStatus() {
		return status;
	}
	public static String getText(Integer status) {
		if (status != null) {
			for (OrderChannel e : OrderChannel.values()) {
				if (e.getStatus() == status) {
					return e.getText();
				}
			}
		}
		return "";
	}
	public static Integer getStatus(String text) {
		if (StringUtils.isNotEmpty(text)) {
			for (OrderChannel e : OrderChannel.values()) {
				if (text.equals(e.getText())) {
					return e.getStatus();
				}
			}
		}
		return 0;
	}

	public static boolean isMapSports(int channelStatus) {
		for (OrderChannel channel : MAP_SPORTS_CHANNELS) {
			if (channel.getStatus() == channelStatus) {
				return true;
			}
		}
		return false;
	}
	public static boolean isMapSports(String channelStatus) {
		if (StringUtils.isEmpty(channelStatus)) {
			return false;
		}
		for (OrderChannel channel : MAP_SPORTS_CHANNELS) {
			if ((channel.getStatus() + "").equals(channelStatus)) {
				return true;
			}
		}
		return false;
	}

	public static List<Integer> getMapChannels() {
		return Arrays.stream(MAP_SPORTS_CHANNELS).map(OrderChannel::getStatus).collect(Collectors.toList());
	}

}
