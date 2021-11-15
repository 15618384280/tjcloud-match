package com.tjcloud.uac.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.uac.api.vo.OperationVO;

/**
 * 功能块表(uac_operation)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class Operation extends AbstractEntity {
	private static final long serialVersionUID = 1462848091250L;

	private String menuId; //菜单ID
	private String name; //名称
	private Integer orderNo; //序号,本级内排序
	private String uniqueKey; //
	private String frontendView;
	
	private String menuName;  //菜单名称
	private String productId; //产品ID
	private String icon;      //图标
	private String code;      //编码


	private Boolean checked = true;
	private List<Resource> resourceList;
	private List<String> resourceIdList;

	public Boolean isChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getMenuId() {
		return this.menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderNo() {
		return this.orderNo;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public String getUniqueKey() {
		return this.uniqueKey;
	}
	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public List<String> getResourceIdList() {
		return this.resourceIdList;
	}
	public void setResourceIdList(List<String> resourceIdList) {
		this.resourceIdList = resourceIdList;
	}
	public List<Resource> getResourceList() {
		return this.resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public OperationVO getOperationVO() {
		OperationVO operationVO = new OperationVO();
		operationVO.setId(getId());
		operationVO.setTitle(name);
		operationVO.setLabel(name);
		operationVO.setMenuId(menuId);
		operationVO.setType("OPERATION");
		operationVO.setFrontendView(frontendView);
		operationVO.setUniqueKey(uniqueKey);
		operationVO.setOrderNo(orderNo);
		return operationVO;
	}

	public String getFrontendView() {
		return frontendView;
	}

	public void setFrontendView(String frontendView) {
		this.frontendView = frontendView;
	}

	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}