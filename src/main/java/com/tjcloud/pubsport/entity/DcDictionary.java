package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 字典表(dc_dictionary)
 * @author auto bin.yin 2019.02.20
 */
public class DcDictionary extends AbstractEntity {
	private static final long serialVersionUID = 1550639073372L;

	private String objectId; //业务主键
	private Integer type; //类型(1.数据字典，2.配置项)
	private String code; //编码
	private String name; //名称
	private String value; //值
	private String body; //备用字段
	private String note; //描述
	private Integer rank; //序号
	private Boolean cached; //是否缓存
	private Boolean editable; //是否可编辑

	public String getObjectId() {
		return this.objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBody() {
		return this.body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getNote() {
		return this.note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getRank() {
		return this.rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Boolean getCached() {
		return this.cached;
	}
	public void setCached(Boolean cached) {
		this.cached = cached;
	}
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
}