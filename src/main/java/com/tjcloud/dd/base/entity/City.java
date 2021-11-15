package com.tjcloud.dd.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 城市(dd_city)
 * @author auto bin.yin 2016.06.16
 */
public class City extends AbstractEntity {
	private static final long serialVersionUID = 1466062116220L;

	private String code; //代码
	private String parentCode; //父级代码
	private String name; //名称
	private String sname; //简称
	private String enname; //英文名称
	private String ensname; //英文简称
	private String telcode; //区号
	private String zipcode; //邮编
	private String townCode; //城乡代码
	private Integer type; //1.国，2.省市，3.市，4.区县
	private String population; //人口
	private String longitude; //经度
	private String latitude; //纬度

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getPopulation() {
        return population;
    }
    public void setPopulation(String population) {
        this.population = population;
    }

    public String getCode() {
		return this.code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getParentCode() {
		return this.parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return this.sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getEnname() {
		return this.enname;
	}
	public void setEnname(String enname) {
		this.enname = enname;
	}

	public String getEnsname() {
		return this.ensname;
	}
	public void setEnsname(String ensname) {
		this.ensname = ensname;
	}

	public String getTelcode() {
		return this.telcode;
	}
	public void setTelcode(String telcode) {
		this.telcode = telcode;
	}

	public String getZipcode() {
		return this.zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTownCode() {
		return townCode;
	}
	public void setTownCode(String townCode) {
		this.townCode = townCode;
	}
	
}