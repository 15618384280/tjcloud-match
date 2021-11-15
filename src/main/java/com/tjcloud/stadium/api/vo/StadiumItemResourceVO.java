package com.tjcloud.stadium.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class StadiumItemResourceVO implements Serializable{
	private static final long serialVersionUID = -1076197509286720876L;

	private String newFieldId;//新系统id

	@JsonProperty("field_id")
	private String fieldId; //老系统id

	@JsonProperty("field_name")
	private String fieldName;

	@JsonProperty("period_date")
	private String periodDate;

	@JsonProperty("field_resource")
	private List<FieldTransferResourceVO> fieldTransferResources;

	public String getNewFieldId() {
		return this.newFieldId;
	}

	public void setNewFieldId(String newFieldId) {
		this.newFieldId = newFieldId;
	}

	public String getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPeriodDate() {
		return this.periodDate;
	}

	public void setPeriodDate(String periodDate) {
		this.periodDate = periodDate;
	}

	public List<FieldTransferResourceVO> getFieldTransferResources() {
		return this.fieldTransferResources;
	}

	public void setFieldTransferResources(List<FieldTransferResourceVO> fieldTransferResources) {
		this.fieldTransferResources = fieldTransferResources;
	}
}