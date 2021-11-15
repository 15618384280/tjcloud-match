package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * 组织表(uac_organization)
 * @author auto bin.yin 2016.05.10
 */
@LogRequired
public class Organization extends AbstractEntity {
	private static final long serialVersionUID = 1462848091882L;

	private String name; //名称
	private String parentId; //父级ID
	private Boolean isLeaf; //是否叶子节点

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return this.parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Boolean getIsLeaf() {
		return this.isLeaf;
	}
	public void setIsLeaf(Boolean isLeaf) {
		this.isLeaf = isLeaf;
	}
}