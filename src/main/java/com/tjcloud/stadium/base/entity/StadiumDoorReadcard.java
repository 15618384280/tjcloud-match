package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目(stadium_door_readcard)
 * @author auto bin.yin 2018.04.19
 */
public class StadiumDoorReadcard extends AbstractEntity {
	private static final long serialVersionUID = 1524127819337L;

	private String doorId; //所属商户,关键字段
	private String card; //读卡ID
	private Integer reader; //串口
	private String type; //数据类型
	private String serialIp; //设备IP地址
	private String serialNo; //设备的序列号
	private String serialId; //设备的自定义标识符，请在WEB界面设置。
	private String method; //
	private String status; //当前门状态, 16进制值
	private String key; //发送的键值,服务器需要原值返回
	private String input; //输入状态16进制值
	private Long nowTime; //心跳时间
	private Long now; //当前设备时间：前面的14个字节按格式：yyyyMMddHHmmss 后面的2个字节为星期，星期从星期日起，星期日为01
	private String index; //随机值

	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
	}
	public String getCard() {
		return this.card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public Integer getReader() {
		return this.reader;
	}
	public void setReader(Integer reader) {
		this.reader = reader;
	}
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getMethod() {
		return this.method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return this.key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getInput() {
		return this.input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public Long getNowTime() {
		return this.nowTime;
	}
	public void setNowTime(Long nowTime) {
		this.nowTime = nowTime;
	}
	public Long getNow() {
		return this.now;
	}
	public void setNow(Long now) {
		this.now = now;
	}
	public String getIndex() {
		return this.index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
}