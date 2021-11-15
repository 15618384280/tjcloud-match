package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目(stadium_door_heartbeatlog)
 * @author auto bin.yin 2017.11.30
 */
public class StadiumDoorHeartbeatlog extends AbstractEntity {
	private static final long serialVersionUID = 1512028586323L;

	private String doorId; 			//所属商户,关键字段
	private String serialIp; 		//设备IP地址
	private String serialNo; 		//设备的序列号
	private String serialId; 		//设备的自定义标识符，请在WEB界面设置。
	private String method; 			//接口方式
	private String status; 			//当前门状态, 16进制值Bit5 出继电器输出;   Bit4 进继电器输出;Bit1 出门状态-门磁和继电器都关则表示关;当前门状态, 16进制值Bit5 出继电器输出;   Bit4 进继电器输出;Bit1 出门状态-门磁和继电器都关则表示关;Bit0 进门状态-门磁和继电器都关则表示关;
	private String key; 			//发送的键值,服务器需要原值返回
	private String input; 			//输入状态16进制值Bit11 复位按钮Bit10 防拆Bit6-9 扩展输入1-4,Bit5 火警输入Bit4 报警输入Bit2-3 门磁1-2Bit0-1 按钮1-2
	private Long nowTime; 			//心跳时间
	private Long now; 				//当前设备时间：前面的14个字节按格式：yyyyMMddHHmmss后面的2个字节为星期，星期从星期日起，星期日为01
	private String T1; 				//温度计1
	private String H1; 				//湿度计1
	private String T2; 				//温度计2
	private String H2; 				//湿度计2
	private String index; 			//随机值

	public String getDoorId() {
		return this.doorId;
	}
	public void setDoorId(String doorId) {
		this.doorId = doorId;
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
		return method;
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
	public String getT1() {
		return this.T1;
	}
	public void setT1(String T1) {
		this.T1 = T1;
	}
	public String getH1() {
		return this.H1;
	}
	public void setH1(String H1) {
		this.H1 = H1;
	}
	public String getT2() {
		return this.T2;
	}
	public void setT2(String T2) {
		this.T2 = T2;
	}
	public String getH2() {
		return this.H2;
	}
	public void setH2(String H2) {
		this.H2 = H2;
	}
	public String getIndex() {
		return this.index;
	}
	public void setIndex(String Index) {
		this.index = Index;
	}
}