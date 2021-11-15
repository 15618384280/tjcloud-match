package com.tjcloud.stadium.api.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.tjcloud.stadium.base.entity.ImageAsset;
import com.tjcloud.stadium.base.entity.StadiumItem;

public class StadiumItemVO implements Serializable {

	private static final long serialVersionUID = 3819793341028032218L;

	private String id;
	private String stadiumItemName;	//子项目名称 
	private String tenantId; 	//所属商户,关键字段
	private String stadiumId; 	//所属场馆,关键字段
	private String stadiumName; // 场馆名称
	private String sportType; 	//项目类型，篮球，羽毛球,关键字段
	private String sportTypeCode; // 项目类型code
	private Integer bookMode; //预订模式,1-场地预订,2-人数预订,关键字段
	private String contactName; //子场馆联系人姓名,关键字段
	private String telephone;	// 联系方式
	private Integer allowBookingTenantDays; //提前开放天数,关键字段
	private float cancelBookingTenantHours;//允许退订天数,关键字段
	private Integer allowBookingPlatformDays; //平台提前开放天数,关键字段
	private float cancelBookingPlatformHours; //允许退订天数,关键字段
	private String bookPhone; 				//订场电话,关键字段
	private String material;		// 材质
	private String description;		// 描述
	private String tips;			//提示
	private Boolean disabled;	//禁用
	private Boolean platformOnline; //平台上线,true-上线
	private Boolean isShare; 									//是否共享场馆项目
	private Boolean ctripOnline; //携程上线,true-上线
	private Boolean aliOnline; //阿里体育上线,true-上线
	private Boolean jdOnline; //京东体育上线,true-上线
	private Boolean nuomiOnline; //糯米上线,true-上线
	private Boolean dianpingOnline; //大众点评上线,false-未上线，true-上线
	private Integer minPrice;     //最小价格(单位：分)
	private Integer maxPrice;     //最大价格(单位：分)
	private String floorHeight;			//层高
	private String environment;			//环境
	private Integer fieldCount;			//场地数量
	private String notice;				//场馆公告
	private Integer source;				// 0-我要运动 1-携程
	private String venueId;				//第三方渠道场馆id
	private String sportId;				//第三方渠道运动类型id
	private String jVenueId;				//第三方渠道运动类型id
	private String jWareId;				//第三方渠道运动类型id
	private Boolean online;		// 状态
	private String tagLabel;     //标签
	private List<String> phoneList;		// 消息手机
	private List<String> tagLabelList;	// 标签
	private List<ImageAsset> imageUrlList;		// 图片
	private List<StadiumItemOpeningTimeVO> stadiumItemOpeningTimeVOList; // 营业时间
	
	private List<Object> sessionList;	// 场次列表

	private StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOAlways;
	private StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOFalse;
	
	private Integer limitOrderTimes; //限制单日场地预定数量
	private Integer opennessSchool;  //0-普通 1-学校开放
	private Integer venueType;  //0-学校场地 1-开放场地
	private String grade;			//综合评分
	private String serviceGrade;	//服务评价
	private Boolean canInvoicing;		//场馆 0-不支持开票 1-可开票
	private Boolean platformCanInvoicing; //平台 0-不支持开票 1-可开票

	private Boolean mapOnline;

	// 是否进行横竖转换
	private Boolean converted;
	private Boolean zfbOnline; //支付宝上线,true-上线
	private String zfbVenueId;   //支付宝场馆id
	private Boolean stadiumShow;   //是否在我要运动展示

	public Boolean getZfbOnline() {
		return zfbOnline;
	}

	public void setZfbOnline(Boolean zfbOnline) {
		this.zfbOnline = zfbOnline;
	}

	public String getZfbVenueId() {
		return zfbVenueId;
	}

	public void setZfbVenueId(String zfbVenueId) {
		this.zfbVenueId = zfbVenueId;
	}

	public Boolean getMapOnline() {
		return mapOnline;
	}

	public void setMapOnline(Boolean mapOnline) {
		this.mapOnline = mapOnline;
	}

	public Boolean getConverted() {
		return converted;
	}

	public void setConverted(Boolean converted) {
		this.converted = converted;
	}

	public String getTagLabel() {
		return tagLabel;
	}
	public void setTagLabel(String tagLabel) {
		this.tagLabel = tagLabel;
	}
	public String getjVenueId() {
		return jVenueId;
	}
	public void setjVenueId(String jVenueId) {
		this.jVenueId = jVenueId;
	}
	public String getjWareId() {
		return jWareId;
	}
	public void setjWareId(String jWareId) {
		this.jWareId = jWareId;
	}
	public Boolean getJdOnline() {
		return jdOnline;
	}
	public void setJdOnline(Boolean jdOnline) {
		this.jdOnline = jdOnline;
	}
	public String getServiceGrade() {
		return serviceGrade;
	}
	public void setServiceGrade(String serviceGrade) {
		this.serviceGrade = serviceGrade;
	}
	public Boolean getCanInvoicing() {
		return canInvoicing;
	}
	public void setCanInvoicing(Boolean canInvoicing) {
		this.canInvoicing = canInvoicing;
	}
	public Boolean getPlatformCanInvoicing() {
		return platformCanInvoicing;
	}
	public void setPlatformCanInvoicing(Boolean platformCanInvoicing) {
		this.platformCanInvoicing = platformCanInvoicing;
	}
	public Integer getLimitOrderTimes() {
		return limitOrderTimes;
	}
	public void setLimitOrderTimes(Integer limitOrderTimes) {
		this.limitOrderTimes = limitOrderTimes;
	}
	public Integer getOpennessSchool() {
		return opennessSchool;
	}
	public void setOpennessSchool(Integer opennessSchool) {
		this.opennessSchool = opennessSchool;
	}

	public Integer getVenueType() {
		return venueType;
	}

	public void setVenueType(Integer venueType) {
		this.venueType = venueType;
	}

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Boolean getAliOnline() {
		return aliOnline;
	}
	public void setAliOnline(Boolean aliOnline) {
		this.aliOnline = aliOnline;
	}
	public String getSportId() {
		return sportId;
	}
	public void setSportId(String sportId) {
		this.sportId = sportId;
	}
	public String getVenueId() {
		return venueId;
	}
	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}
	public Integer getSource() {
		return source;
	}
	public void setSource(Integer source) {
		this.source = source;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public Boolean getPlatformOnline() {
		return platformOnline;
	}
	public void setPlatformOnline(Boolean platformOnline) {
		this.platformOnline = platformOnline;
	}
	public Boolean getCtripOnline() {
		return ctripOnline;
	}
	public void setCtripOnline(Boolean ctripOnline) {
		this.ctripOnline = ctripOnline;
	}
	public Boolean getNuomiOnline() {
		return nuomiOnline;
	}
	public void setNuomiOnline(Boolean nuomiOnline) {
		this.nuomiOnline = nuomiOnline;
	}
	public Boolean getDianpingOnline() {
		return dianpingOnline;
	}
	public void setDianpingOnline(Boolean dianpingOnline) {
		this.dianpingOnline = dianpingOnline;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
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
	public float getCancelBookingPlatformHours() {
		return cancelBookingPlatformHours;
	}
	public void setCancelBookingPlatformHours(float cancelBookingPlatformHours) {
		this.cancelBookingPlatformHours = cancelBookingPlatformHours;
	}
	public Integer getAllowBookingPlatformDays() {
		return allowBookingPlatformDays;
	}
	public void setAllowBookingPlatformDays(Integer allowBookingPlatformDays) {
		this.allowBookingPlatformDays = allowBookingPlatformDays;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public List<Object> getSessionList() {
		return sessionList;
	}
	public void setSessionList(List<Object> sessionList) {
		this.sessionList = sessionList;
	}
	public Boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}
	public String getSportTypeCode() {
		return sportTypeCode;
	}
	public void setSportTypeCode(String sportTypeCode) {
		this.sportTypeCode = sportTypeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getBookMode() {
		return bookMode;
	}
	public void setBookMode(Integer bookMode) {
		this.bookMode = bookMode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTenantId() {
		return tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}
	public String getStadiumId() {
		return stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}
	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	public String getSportType() {
		return sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Integer getAllowBookingTenantDays() {
		return allowBookingTenantDays;
	}
	public void setAllowBookingTenantDays(Integer allowBookingTenantDays) {
		this.allowBookingTenantDays = allowBookingTenantDays;
	}
	public float getCancelBookingTenantHours() {
		return cancelBookingTenantHours;
	}
	public void setCancelBookingTenantHours(float cancelBookingTenantHours) {
		this.cancelBookingTenantHours = cancelBookingTenantHours;
	}
	public String getBookPhone() {
		return bookPhone;
	}
	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public List<String> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<String> phoneList) {
		this.phoneList = phoneList;
	}
	public List<String> getTagLabelList() {
		return tagLabelList;
	}
	public void setTagLabelList(List<String> tagLabelList) {
		this.tagLabelList = tagLabelList;
	}
	public List<ImageAsset> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<ImageAsset> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	public List<StadiumItemOpeningTimeVO> getStadiumItemOpeningTimeVOList() {
		return stadiumItemOpeningTimeVOList;
	}
	public void setStadiumItemOpeningTimeVOList(List<StadiumItemOpeningTimeVO> stadiumItemOpeningTimeVOList) {
		this.stadiumItemOpeningTimeVOList = stadiumItemOpeningTimeVOList;
	}

	public StadiumItemOpeningTimeVO getStadiumItemOpeningTimeVOAlways() {
		return this.stadiumItemOpeningTimeVOAlways;
	}

	public void setStadiumItemOpeningTimeVOAlways(StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOAlways) {
		this.stadiumItemOpeningTimeVOAlways = stadiumItemOpeningTimeVOAlways;
	}

	public StadiumItemOpeningTimeVO getStadiumItemOpeningTimeVOFalse() {
		return this.stadiumItemOpeningTimeVOFalse;
	}

	public void setStadiumItemOpeningTimeVOFalse(StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOFalse) {
		this.stadiumItemOpeningTimeVOFalse = stadiumItemOpeningTimeVOFalse;
	}

	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	public Integer getFieldCount() {
		return fieldCount;
	}
	public void setFieldCount(Integer fieldCount) {
		this.fieldCount = fieldCount;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	
	public Boolean getIsShare() {
		return isShare;
	}
	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}
	public StadiumItemVO() {
		super();
	}
	public StadiumItemVO(StadiumItem stadiumItem) {
		setId(stadiumItem.getId());
		setStadiumItemName(stadiumItem.getStadiumItemName());
		setTenantId(stadiumItem.getTenantId());
		setStadiumId(stadiumItem.getStadiumId());
		setStadiumName(stadiumItem.getStadiumName());
		setSportType(stadiumItem.getSportType());
		setSportTypeCode(stadiumItem.getSportTypeCode());
		setBookMode(stadiumItem.getBookMode());
		setContactName(stadiumItem.getContactName());
		setTelephone(stadiumItem.getTelephone());
		setAllowBookingTenantDays(stadiumItem.getAllowBookingTenantDays());
		setAllowBookingPlatformDays(stadiumItem.getAllowBookingPlatformDays());
		setCancelBookingTenantHours(stadiumItem.getCancelBookingTenantHours());
		setCancelBookingPlatformHours(stadiumItem.getCancelBookingPlatformHours());
		setBookPhone(stadiumItem.getBookPhone());
		setMaterial(stadiumItem.getMaterial());
		setDescription(stadiumItem.getDescription());
		setDisabled(stadiumItem.isDisabled());
		setPlatformOnline(stadiumItem.getPlatformOnline());
		setCtripOnline(stadiumItem.getCtripOnline());
		setAliOnline(stadiumItem.getAliOnline());
		setJdOnline(stadiumItem.getJdOnline());
		setNuomiOnline(stadiumItem.getNuomiOnline());
		setDianpingOnline(stadiumItem.getDianpingOnline());
		setMinPrice(stadiumItem.getMinPrice());
		setMaxPrice(stadiumItem.getMaxPrice());
		setFloorHeight(stadiumItem.getFloorHeight());
		setEnvironment(stadiumItem.getEnvironment());
		setFieldCount(stadiumItem.getFieldCount());
		setNotice(stadiumItem.getNotice());
		setOnline(stadiumItem.getOnline());
		setPhoneList(getStrList(stadiumItem.getNoticePhone()));
		setTagLabel(stadiumItem.getTagLabel());
		setTagLabelList(getStrList(stadiumItem.getTagLabel()));
		setImageUrlList(stadiumItem.getImageUrlList());
		setStadiumItemOpeningTimeVOList(stadiumItem.getStadiumItemOpeningTimeVOList());
		setStadiumItemOpeningTimeVOFalse(stadiumItem.getStadiumItemOpeningTimeVOFalse());
		setStadiumItemOpeningTimeVOAlways(stadiumItem.getStadiumItemOpeningTimeVOAlways());
		setTips(stadiumItem.getTips());
		setSource(stadiumItem.getSource());
		setVenueId(stadiumItem.getVenueId());
		setSportId(stadiumItem.getSportId());
		setIsShare(stadiumItem.getIsShare());
		setLimitOrderTimes(stadiumItem.getLimitOrderTimes());
		setOpennessSchool(stadiumItem.getOpennessSchool());
		setVenueType(stadiumItem.getVenueType());
		setGrade(stadiumItem.getGrade());
		setCanInvoicing(stadiumItem.getCanInvoicing());
		setPlatformCanInvoicing(stadiumItem.getPlatformCanInvoicing());
		setServiceGrade(stadiumItem.getServiceGrade());
		setjVenueId(stadiumItem.getjVenueId());
		setjWareId(stadiumItem.getjWareId());
		setMapOnline(stadiumItem.getMapOnline());
		setConverted(stadiumItem.getConverted());
		setZfbOnline(stadiumItem.getZfbOnline());
		setZfbVenueId(stadiumItem.getZfbVenueId());
		setStadiumShow(stadiumItem.getStadiumShow());
	}
	private List<String> getStrList(String str) {
		if(str != null && !"".equals(str)) {
			String[] strs = str.split(",");
			return Arrays.asList(strs);
		}
		return null;
	}

	public Boolean getStadiumShow() {
		return stadiumShow;
	}

	public void setStadiumShow(Boolean stadiumShow) {
		this.stadiumShow = stadiumShow;
	}
}
