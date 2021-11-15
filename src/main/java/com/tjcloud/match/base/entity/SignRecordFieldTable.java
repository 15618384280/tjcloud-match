package com.tjcloud.match.base.entity;

import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.match.api.utils.SignRecordFieldUtils;

/**
 * 参赛人员报名字段信息记录表(sign_record_field_table)
 * @author auto bin.yin 2017.03.04
 */
public class SignRecordFieldTable extends AbstractEntity {
	private static final long serialVersionUID = 1488619014649L;

	private String recordId; 									//报名记录ID
	private String playersId; 									//参赛记录ID
	private String controlKey; 									//controlKey（controlKey不能重复）
	private String comment; 									//显示名称
	private String value; 										//值

	public String getRecordId() {
		return this.recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getPlayersId() {
		return this.playersId;
	}
	public void setPlayersId(String playersId) {
		this.playersId = playersId;
	}
	
	public String getControlKey() {
		return controlKey;
	}
	public void setControlKey(String controlKey) {
		this.controlKey = controlKey;
	}
	public String getComment() {
		return this.comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
		setControlKey(SignRecordFieldUtils.convertControlKey(comment));
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}