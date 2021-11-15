package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.List;

import com.tjcloud.stadium.base.entity.FieldShare;

/**
 * 场地共享
 * @author lihongzhou
 *
 */
public class FieldShareVO implements Serializable{

	private static final long serialVersionUID = -7800334869701547391L;
	
	private String id;
	private String stadiumId;			// 场馆Id
	private String oneFiledId;			// 一片场地Id
	private String oneStadiumItemId;	// 一片场地项目
	private Boolean enable;				// 是否共享 0-否 1-是
	private List<FieldShareDetailVO> fieldShareDetailList;	// 多片场地
	
	private String oneStadiumItemName;	//项目名
	private String oneFieldName;		// 场地名
	private String manyFieldNames;		// 多个名称
	private String manyStadiumItemNames;// 多个项目
	
	private String manyFieldId;			// 多个场地id
	
	
	public String getManyFieldId() {
		return manyFieldId;
	}
	public void setManyFieldId(String manyFieldId) {
		this.manyFieldId = manyFieldId;
	}
	public String getManyStadiumItemNames() {
		return manyStadiumItemNames;
	}
	public void setManyStadiumItemNames(String manyStadiumItemNames) {
		this.manyStadiumItemNames = manyStadiumItemNames;
	}
	public String getManyFieldNames() {
		return manyFieldNames;
	}
	public void setManyFieldNames(String manyFieldNames) {
		this.manyFieldNames = manyFieldNames;
	}
	public String getOneStadiumItemName() {
		return oneStadiumItemName;
	}
	public void setOneStadiumItemName(String oneStadiumItemName) {
		this.oneStadiumItemName = oneStadiumItemName;
	}
	public String getOneFieldName() {
		return oneFieldName;
	}
	public void setOneFieldName(String oneFieldName) {
		this.oneFieldName = oneFieldName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getOneFiledId() {
		return oneFiledId;
	}
	public void setOneFiledId(String oneFiledId) {
		this.oneFiledId = oneFiledId;
	}
	public String getOneStadiumItemId() {
		return oneStadiumItemId;
	}
	public void setOneStadiumItemId(String oneStadiumItemId) {
		this.oneStadiumItemId = oneStadiumItemId;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	public List<FieldShareDetailVO> getFieldShareDetailList() {
		return fieldShareDetailList;
	}
	public void setFieldShareDetailList(List<FieldShareDetailVO> fieldShareDetails) {
		this.fieldShareDetailList = fieldShareDetails;
	}
	public FieldShareVO() {
		super();
	}
	
	public FieldShareVO(FieldShare fieldShare) {
		setId(fieldShare.getId());
		setStadiumId(fieldShare.getStadiumId());
		setOneFiledId(fieldShare.getOneFiledId());
		setOneStadiumItemId(fieldShare.getOneStadiumItemId());
		setEnable(fieldShare.getEnable());
	}
	
	
}
