package com.tjcloud.tenant.base.vo;

import com.tjcloud.tenant.base.entity.InstructorArticle;

public class InstructorArticleVO extends InstructorArticle {

    private static final long serialVersionUID = 2568911675612350020L;

    private String categoryName; //类型名称

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
