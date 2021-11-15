package com.tjcloud.order.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 用户区域关联表(order_user_region)
 * @author auto bin.yin 2017.10.29
 */
public class OrderUserRegion extends AbstractEntity {
	private static final long serialVersionUID = 1503971570267L;

	private String authId; 			// authId
	private String level; 			// 区域级别：1-省；2-市；3-区；
	private String pcode;			// 父级区域Code
	private String region;			// 区域代码
	private String regionName;		// 区域名称
	
	private List<OrderUserRegion> childRegionList;	// 子区域集合
	
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public List<OrderUserRegion> getChildRegionList() {
		return childRegionList;
	}
	public void setChildRegionList(List<OrderUserRegion> childRegionList) {
		this.childRegionList = childRegionList;
	}
	
}