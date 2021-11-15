package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (ps_sports_log)场所器材操作日志表
 * @author zhu.jian 2020.01.16
 */
public class SportsLog extends AbstractEntity {
	private static final long serialVersionUID = 7897379085872225478L;
	
	private Integer resource;	//来源:0-场所，1-器材
	private String placeId;
	private String placeName;
	private String materialId;
	private String materialName;
	private Integer operate;	//操作:0-新增，1-修改，2-删除
	private String remark;
	public Integer getResource() {
		return resource;
	}
	public void setResource(Integer resource) {
		this.resource = resource;
	}
	public String getPlaceId() {
		return placeId;
	}
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public Integer getOperate() {
		return operate;
	}
	public void setOperate(Integer operate) {
		this.operate = operate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public SportsLog() {
		super();
	}
	
	public SportsLog(Integer resource, String placeId, String placeName, String materialId, String materialName,
			Integer operate, String remark, String tokenId) {
		this.resource = resource;
		this.placeId = placeId;
		this.placeName = placeName;
		this.materialId = materialId;
		this.materialName = materialName;
		this.operate = operate;
		this.remark = remark;
		this.setTokenId(tokenId);
	}
	
}
