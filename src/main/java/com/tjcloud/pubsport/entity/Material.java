package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 器材库(ps_material)
 * @author auto bin.yin 2018.03.12
 */
public class Material extends AbstractEntity {
	private static final long serialVersionUID = 1520838154845L;

	private String tenantId; //租户ID
	private String factoryId; //厂商ID
	private String factoryName; //厂商名称
	private String brandId; //品牌ID
	private String brandName; //品牌名称
	private String categoryId; //器材分类ID
	private String categoryName; //器材分类名称
	private String largeCategory; //器材分类code（大范围）
	private String smallCategory; //器材分类code （小范围）
	private String largeCategoryName; //器材分类名字（大范围）
	private String smallCategoryName; //器材分类名字（大范围）
	private String name; //器材名称
	private String spec; //器材型号
	private String image; //器材图片
	private Boolean isNscc; //是否国休认证
	private String funcInstruction; //功能说明
	private String useInstruction; //使用说明
	private String funcVideoUrl; //教程视频

	public String getFuncVideoUrl() {
		return funcVideoUrl;
	}
	public void setFuncVideoUrl(String funcVideoUrl) {
		this.funcVideoUrl = funcVideoUrl;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(String factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Boolean getIsNscc() {
		return isNscc;
	}
	public void setIsNscc(Boolean isNscc) {
		this.isNscc = isNscc;
	}
	public String getFuncInstruction() {
		return funcInstruction;
	}
	public void setFuncInstruction(String funcInstruction) {
		this.funcInstruction = funcInstruction;
	}
	public String getUseInstruction() {
		return useInstruction;
	}
	public void setUseInstruction(String useInstruction) {
		this.useInstruction = useInstruction;
	}

	public String getLargeCategory() {
		return largeCategory;
	}

	public void setLargeCategory(String largeCategory) {
		this.largeCategory = largeCategory;
	}

	public String getSmallCategory() {
		return smallCategory;
	}

	public void setSmallCategory(String smallCategory) {
		this.smallCategory = smallCategory;
	}

	public String getLargeCategoryName() {
		return largeCategoryName;
	}

	public void setLargeCategoryName(String largeCategoryName) {
		this.largeCategoryName = largeCategoryName;
	}

	public String getSmallCategoryName() {
		return smallCategoryName;
	}

	public void setSmallCategoryName(String smallCategoryName) {
		this.smallCategoryName = smallCategoryName;
	}
}