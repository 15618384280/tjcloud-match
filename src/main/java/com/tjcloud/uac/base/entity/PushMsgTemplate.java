package com.tjcloud.uac.base.entity;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;

/**
 * (push_msg_template)
 * @author auto bin.yin 2016.12.07
 */
@LogRequired
public class PushMsgTemplate extends AbstractEntity {
	private static final long serialVersionUID = 1481079810273L;

	private String templateCode; //模板码
	private String templateMsg; //模板消息
	private String signName; //签名
	private String name; //名称

	public String getTemplateCode() {
		return this.templateCode;
	}
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getTemplateMsg() {
		return this.templateMsg;
	}
	public void setTemplateMsg(String templateMsg) {
		this.templateMsg = templateMsg;
	}

	public String getSignName() {
		return this.signName;
	}
	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
}