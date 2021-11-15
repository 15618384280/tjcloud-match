package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 系统提示信息编码录入表(dd_message_info)
 * @author auto bin.yin 2016.06.28
 */
public class Message extends AbstractEntity implements Comparable<Message> {
	private static final long serialVersionUID = 1467096179940L;

	private Integer messageIndex;    //当前类目下的最大索引
	private Integer messageCode;     //提示信息编码
	private String messageText;      //提示信息描述
	private Integer messageRank = 1; //信息等级,默认为1级信息
	private String fatherId;         //父级记录的ID

	public Integer getMessageIndex() {
		return this.messageIndex;
	}
	public void setMessageIndex(Integer messageIndex) {
		this.messageIndex = messageIndex;
	}

	public Integer getMessageCode() {
		return this.messageCode;
	}
	public void setMessageCode(Integer messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageText() {
		return this.messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public String getFatherId() {
		return fatherId;
	}
	public void setFatherId(String fatherId) {
		this.fatherId = fatherId;
	}
	public Integer getMessageRank() {
		return messageRank;
	}
	public void setMessageRank(Integer messageRank) {
		this.messageRank = messageRank;
	}

	@Override
	public int compareTo(Message m) {
		return this.messageCode.compareTo(m.getMessageCode());
	}
}