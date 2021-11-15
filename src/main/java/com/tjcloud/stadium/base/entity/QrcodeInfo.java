package com.tjcloud.stadium.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 场馆-二维码信息表(repair_qrcode_info)
 * @author auto bin.yin 2017.09.11
 */
public class QrcodeInfo extends AbstractEntity {
	private static final long serialVersionUID = 1505119100064L;

	private String stadiumId; //场馆Id
	private String qrCodeUrl; //二维码Url

	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getQrCodeUrl() {
		return this.qrCodeUrl;
	}
	public void setQrCodeUrl(String qrCodeUrl) {
		this.qrCodeUrl = qrCodeUrl;
	}
}