package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

public class StadiumConfig extends AbstractEntity{


	private static final long serialVersionUID = 5856714767600499407L;
	private String objectId;  			//所属场馆id
	private String siteId;    			//核验站点ID
	private String checkUsrIdCard;  	//核验点检查人员身份证号码或核验点设备编码
	private String checkUsrName;  		//核验点检查人员姓名或核验点设备名称
	private String useAddr;     		//使用区划社区编码
	private String useType;  			//使用场景类型（场景类型编码）

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getCheckUsrIdCard() {
		return checkUsrIdCard;
	}

	public void setCheckUsrIdCard(String checkUsrIdCard) {
		this.checkUsrIdCard = checkUsrIdCard;
	}

	public String getCheckUsrName() {
		return checkUsrName;
	}

	public void setCheckUsrName(String checkUsrName) {
		this.checkUsrName = checkUsrName;
	}

	public String getUseAddr() {
		return useAddr;
	}

	public void setUseAddr(String useAddr) {
		this.useAddr = useAddr;
	}

	public String getUseType() {
		return useType;
	}

	public void setUseType(String useType) {
		this.useType = useType;
	}
}
