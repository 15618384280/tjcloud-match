package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.core.utils.DateUtils;

/**
 * 场馆项目(stadium_keytoken_record)
 * @author auto bin.yin 2018.01.24
 */
public class StadiumKeytokenRecord extends AbstractEntity {
	private static final long serialVersionUID = 1516781818859L;

	private String orderId; 				//订单ID
	private String orderNo; 				//订单号
	private String cardNo; 					//会员卡号
	private String codeNo; 					//钥匙编号
	private String keyTokenNo; 				//钥匙ID
	private String stadiumId; 				//场馆ID
	private String stadiumName; 			//场馆名称
	private String stadiumItemId; 			//子场馆ID
	private String stadiumItemName; 		//子场馆名称
	private String serialIp; 				//设备IP地址
	private String serialNo; 				//设备的序列号
	private String serialId; 				//设备的自定义标识符，请在WEB界面设置。
	private Boolean reader; 				//0-进，1-出
	private Long playingTime;				//刷卡时间
	private String status; 					//当前门状态, 
	private Boolean cancel; 				//是否取消刷卡记录

	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getCardNo() {
		return this.cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getKeyTokenNo() {
		return this.keyTokenNo;
	}
	public void setKeyTokenNo(String keyTokenNo) {
		this.keyTokenNo = keyTokenNo;
	}
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return this.stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemId() {
		return this.stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return this.stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getSerialIp() {
		return this.serialIp;
	}
	public void setSerialIp(String serialIp) {
		this.serialIp = serialIp;
	}
	public String getSerialNo() {
		return this.serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	public String getSerialId() {
		return this.serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public Boolean getReader() {
		return reader;
	}
	public void setReader(Boolean reader) {
		this.reader = reader;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getReaderText() {
		return (reader) ? "出闸" : "入闸";
	}
	public String getCreatedTimeText() {
		return DateUtils.toString(super.getCreatedTime(), "yyyy-MM-dd HH:mm");
	}
	public String getPlayingTimeText() {
		return DateUtils.toString(getPlayingTime(), "yyyy-MM-dd HH:mm");
	}
	public Long getPlayingTime() {
		return playingTime;
	}
	public void setPlayingTime(Long playingTime) {
		this.playingTime = playingTime;
	}
	public Boolean getCancel() {
		return cancel;
	}
	public String getCancelText() {
		return (cancel) ? "失效" : "有效";
	}
	public void setCancel(Boolean cancel) {
		this.cancel = cancel;
	}
	
}