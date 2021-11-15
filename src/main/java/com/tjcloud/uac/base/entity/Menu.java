package com.tjcloud.uac.base.entity;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tjcloud.core.Constants;
import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.uac.api.vo.MenuVO;

/**
 * 菜单表(uac_menu)
 * @author auto bin.yin 2016.04.26
 */
@LogRequired
public class Menu extends AbstractEntity {
	private static final long serialVersionUID = 1461636429870L;

	private String title; //标题
	private String icon; //图标
	private String uri; //URL
	private Integer orderNo; //序号
	private String parentId; //父级ID
	private List<Operation> operationList;
	private JSONArray childMenu;
	private String frontendView;
	private Boolean hot;
	
	private String type; //类型(folder/item)
	private String code; //编码
	private String name; //名称
	private String link; //URL
	private String path; //PATH
	private String productId; //产品ID

	public Boolean isFolder() {
		return Constants.TreeType.FOLDER.equals(type);
	}
	public Boolean isItem() {
		return Constants.TreeType.ITEM.equals(type);
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
		//this.name = title;
	}

	public String getIcon() {
		return this.icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUri() {
		return this.uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
		this.link = uri;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getParentId() {
		return this.parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<Operation> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<Operation> operationList) {
		this.operationList = operationList;
	}

	public JSONArray getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(JSONArray childMenu) {
		this.childMenu = childMenu;
	}

	public MenuVO getMenuVO() {
		MenuVO menuVO = new MenuVO();
		menuVO.setTitle(title);
		menuVO.setLabel(title);
		menuVO.setParentId(parentId);
		menuVO.setId(getId());
		menuVO.setType("MENU");
		menuVO.setIcon(icon);
		menuVO.setFrontendView(frontendView);
		menuVO.setOrderNo(orderNo);
		return menuVO;
	}

	public String getFrontendView() {
		return frontendView;
	}

	public void setFrontendView(String frontendView) {
		this.frontendView = frontendView;
	}
	public Boolean getHot() {
		return hot;
	}
	public void setHot(Boolean hot) {
		this.hot = hot;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		//this.title = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
		this.uri = link;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
}