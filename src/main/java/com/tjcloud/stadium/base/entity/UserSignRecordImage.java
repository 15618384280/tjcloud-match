package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * (user_sign_record_image)签到打卡记录图片表
 * @author zhujian 2020.03.17
 */
public class UserSignRecordImage extends AbstractEntity {
	private static final long serialVersionUID = -6744376682625739764L;
	
	private String objectId;		//签到打卡记录Id
	private Integer type;			//类型：0-笑脸照片 1-规范照片 2-场地照片 3-管理员签到照片
	private String imageUrl;		//图片url
	private Integer sort;			//排序号
	
	
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
