package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 图片上传配置信息(dd_image_config)
 * @author auto bin.yin 2016.08.09
 */
public class ImageConfig extends AbstractEntity {
	private static final long serialVersionUID = 1470737311051L;

	private String domain; //图片域名
	private String bucket; //图片存储空间
	private String secret; //图片存储空间密文

	public String getDomain() {
		return this.domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getBucket() {
		return this.bucket;
	}
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
}