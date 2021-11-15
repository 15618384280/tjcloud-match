package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 意见(dd_advice)
 * @author auto bin.yin 2017.12.19
 */
public class Advice extends AbstractEntity {
	private static final long serialVersionUID = 1513665563895L;

	private String userName; //用户名
	private String email; //邮箱
	private String mobile; //手机号
	private String content; //内容
	private Boolean isReply; //是否回复

	public String getUserName() {
		return this.userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Boolean getIsReply() {
		return this.isReply;
	}
	public void setIsReply(Boolean isReply) {
		this.isReply = isReply;
	}
}