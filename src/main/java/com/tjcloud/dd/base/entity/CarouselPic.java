package com.tjcloud.dd.base.entity;
import com.tjcloud.core.entity.AbstractEntity;

public class CarouselPic extends AbstractEntity{

	private static final long serialVersionUID = -4735993726197815026L;

	private String tenantId;      //七牛图片地址
	private String pictureUrl;      //七牛图片地址
	private String source;          //ANDROID_USER 或是 IOS_USER
	private String linkUrl;			//前端微信地址
	private String name;			//名字
	private Integer isDelete;		//是否被删除  1-删除  0-没删除
	
	
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	

}
