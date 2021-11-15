package com.tjcloud.pubsport.entity;

import com.tjcloud.core.entity.AbstractEntity;

import java.util.List;

/**
 * 项目类型(ps_sports_place_item)
 * @author auto bin.yin 2016.07.15
 */
public class SportsPlaceItem extends AbstractEntity {
    private static final long serialVersionUID = -5300590604132443390L;

    private String sportsPlaceId; //场所Id
    private String sportsPlaceName; // 场所名
    private String sportsPlaceItemName; //健身场所子项目名字
    private String sportType; //项目类型，篮球、足球、门球
    private String sportTypeCode; //项目类型code
    private String floorHeight;			//层高
    private String environment;			//环境
    private Integer fieldCount;		//场地数量
    private String beginDate;      // 开始营业时间
    private String endDate;        // 结束营业时间
    private String telephone;	// 健身场所子项目馆联系方式
    private String material; 	// 材质
    private List<ImageItem> imageUrlList;		// 图片
    private String typeId;		// 场所类型

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getSportsPlaceId() {
        return sportsPlaceId;
    }

    public void setSportsPlaceId(String sportsPlaceId) {
        this.sportsPlaceId = sportsPlaceId;
    }

    public String getSportsPlaceName() {
        return sportsPlaceName;
    }

    public void setSportsPlaceName(String sportsPlaceName) {
        this.sportsPlaceName = sportsPlaceName;
    }

    public String getSportsPlaceItemName() {
        return sportsPlaceItemName;
    }

    public void setSportsPlaceItemName(String sportsPlaceItemName) {
        this.sportsPlaceItemName = sportsPlaceItemName;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(String floorHeight) {
        this.floorHeight = floorHeight;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Integer getFieldCount() {
        return fieldCount;
    }

    public void setFieldCount(Integer fieldCount) {
        this.fieldCount = fieldCount;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public List<ImageItem> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<ImageItem> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public String getSportTypeCode() {
        return sportTypeCode;
    }

    public void setSportTypeCode(String sportTypeCode) {
        this.sportTypeCode = sportTypeCode;
    }
}
