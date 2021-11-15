package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 器材分类(ps_material_category)
 * @author auto bin.yin 2018.02.27
 */
public class MaterialCategory extends AbstractEntity {
	private static final long serialVersionUID = 1519719771340L;

	private String tenantId; //租户ID
	private String name; //名称
	private String code; //名称code
	private String parentName; //父类名称
	private String parentCode; //父类名称code
	private String useInstruction; //使用说明
	private String funcVideoUrl; //教程视频

	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getUseInstruction() {
		return useInstruction;
	}

	public void setUseInstruction(String useInstruction) {
		this.useInstruction = useInstruction;
	}

	public String getFuncVideoUrl() {
		return funcVideoUrl;
	}

	public void setFuncVideoUrl(String funcVideoUrl) {
		this.funcVideoUrl = funcVideoUrl;
	}
}