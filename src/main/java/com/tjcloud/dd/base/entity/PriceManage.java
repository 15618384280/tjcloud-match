package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class PriceManage extends AbstractEntity{

	private static final long serialVersionUID = -7607324063726547576L;
	
	private Integer channel;  //支付方式 0-运动豆  1-微信  2-支付宝  3-场馆卡
	private Integer type;   //费用类型 1-平台服务费  
	private Integer price;  //价格
	
	
	public Integer getChannel() {
		return channel;
	}
	public void setChannel(Integer channel) {
		this.channel = channel;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	

}
