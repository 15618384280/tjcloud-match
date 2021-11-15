package com.tjcloud.match.base.vo;

import java.io.Serializable;

public class CoordVO implements Serializable{

	private static final long serialVersionUID = -8965362669253042847L;

	private String coordName;	//坐标名称
	private String imageUrl;		//坐标图片
	private String longitude;	//经度
	private String latitude;		//纬度
	public String getCoordName() {
		return coordName;
	}
	public void setCoordName(String coordName) {
		this.coordName = coordName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	
	
}
