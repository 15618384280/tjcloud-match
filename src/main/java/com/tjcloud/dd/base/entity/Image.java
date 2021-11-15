package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 图片上传信息(dd_image)
 * @author auto bin.yin 2016.08.08
 */
public class Image extends AbstractEntity {
	private static final long serialVersionUID = 1470638414972L;

	private String imageId;     //图片唯一标识
	private String imageUrl;    //图片的访问地址
	private String imageName;   //图片名称
	private String imageType;   //图片类型(IMAGE,QRCODE,BRCODE)
	private String imageBucket; //图片空间

	public String getImageId() {
		return this.imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getImageUrl() {
		return this.imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getImageName() {
		return this.imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getImageType() {
		return imageType;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public String getImageBucket() {
		return imageBucket;
	}
	public void setImageBucket(String imageBucket) {
		this.imageBucket = imageBucket;
	}
}