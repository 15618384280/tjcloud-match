package com.tjcloud.uac.base.entity;

import com.alibaba.fastjson.JSONObject;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 菜单分类表(uac_menu_category)
 * @author auto bin.yin 2019.06.13
 */
@LogRequired
public class MenuCategory extends AbstractEntity {
	private static final long serialVersionUID = 4548391876602095743L;
	
	private String productId;			// 产品ID
	private String name;				// 分类名称
	private String introduce;			// 分类描述
	private String icon;				// 分类图标
	private Integer orderNo;			// 排序
	
	/**	非DB属性	**/
	private List<JSONObject> menuList;	// 菜单列表
	
	public List<JSONObject> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<JSONObject> menuList) {
		this.menuList = menuList;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
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
}