package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆项目钥匙(stadium_keytoken)
 * @author auto bin.yin 2018.01.24
 */
public class StadiumKeytoken extends AbstractEntity {
	private static final long serialVersionUID = 1516781818567L;

	private String tenantId; 			//所属商户,关键字段
	private String stadiumId; 			//所属场馆,关键字段
	private String stadiumName; 		//场馆名
	private String stadiumItemId; 		//子场馆ID
	private String stadiumItemName; 	//子场馆名称
	private String codeNo; 				//钥匙编号
	private String keyNo; 				//钥匙序列号
	private Integer status; 			//钥匙状态（0-待使用，1-已进场，2-未刷卡，3-已出场）

	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
	public String getCodeNo() {
		return codeNo;
	}
	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}
	public String getKeyNo() {
		return this.keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}