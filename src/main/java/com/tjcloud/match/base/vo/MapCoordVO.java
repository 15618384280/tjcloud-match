package com.tjcloud.match.base.vo;

import java.io.Serializable;
import java.util.List;

public class MapCoordVO  implements Serializable {

	private static final long serialVersionUID = 2399012237995761336L;

	private String routeName;        //路线名称;
	private String routeKey;         //路线名称;
	private String distance;			//距离
	private List<CoordVO> coord;		//坐标点
	
	
	public String getRouteName() {
		return routeName;
	}
	public void setRouteName(String routeName) {
		this.routeName = routeName;
	}
	
	public String getRouteKey() {
		return routeKey;
	}
	public void setRouteKey(String routeKey) {
		this.routeKey = routeKey;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public List<CoordVO> getCoord() {
		return coord;
	}
	public void setCoord(List<CoordVO> coord) {
		this.coord = coord;
	}
	
	
}
