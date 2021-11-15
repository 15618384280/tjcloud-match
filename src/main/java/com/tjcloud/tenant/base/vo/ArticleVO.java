package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.Article;

public class ArticleVO extends Article {

	private static final long serialVersionUID = 2568911675612350020L;
	
	private String categoryName; //类型名称

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
