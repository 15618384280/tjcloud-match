package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 第三方渠道费率配置表(dd_channel_rate)
 * @author auto bin.yin 2018.02.01
 */
public class ChannelRate extends AbstractEntity {
	private static final long serialVersionUID = 1517463816772L;

	private String channelName; //渠道名称
	private Integer channel; //渠道
	private String rate; //费率

	public String getChannelName() {
		return this.channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public Integer getChannel() {
		return this.channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public String getRate() {
		return this.rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
}