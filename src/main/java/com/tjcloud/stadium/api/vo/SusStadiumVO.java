package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

public class SusStadiumVO implements Serializable{

	private static final long serialVersionUID = -8990817126181614548L;
	
	private String tenantId;			//租户id
	private String stadiumId;			//场馆id
	private String stadiumName;			//场馆名
	private String stadiumItemId; 		//项目id
	private String stadiumItemName;		//项目名
	private String imageUrl;			//图片
	private Integer minPrice;			//价格
	private Integer size;				//子项目个数
	
	List<SusStadiumVO> items;			//子项目
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public List<SusStadiumVO> getItems() {
		return items;
	}
	public void setItems(List<SusStadiumVO> items) {
		this.items = items;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getStadiumItemId() {
		return stadiumItemId;
	}
	public void setStadiumItemId(String stadiumItemId) {
		this.stadiumItemId = stadiumItemId;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
}
