package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 新闻类型表(article_category)
 * @author cuike 2018.11.30
 */
public class InstructorArticleCategory extends AbstractEntity {
	private static final long serialVersionUID = 1543390415932L;

	private String tenantId; //租户ID
	private String name; //分类名称
	private Integer orderNo; //排序
	private Boolean recom;	//0-首页不推荐，1-首页推荐
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
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
	public Boolean getRecom() {
		return this.recom;
	}
	public void setRecom(Boolean recom) {
		this.recom = recom;
	}
}
