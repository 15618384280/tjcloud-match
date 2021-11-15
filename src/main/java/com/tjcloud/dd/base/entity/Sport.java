package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 项目类型(dd_sport)
 * @author auto bin.yin 2016.07.15
 */
public class Sport extends AbstractEntity {
	private static final long serialVersionUID = 1468581556914L;

	private String code; //类型代码
	private String codeName; //运动类型
	private Integer orderNo; 	// 排序
	private String icon;		//图片
	private Boolean bookingShow; //场地显示
//	private String typeId; //场所类型ID
	
	public Boolean getBookingShow() {
		return bookingShow;
	}
	public void setBookingShow(Boolean bookingShow) {
		this.bookingShow = bookingShow;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return this.codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
//
//	public String getTypeId() {
//		return typeId;
//	}
//
//	public void setTypeId(String typeId) {
//		this.typeId = typeId;
//	}
}