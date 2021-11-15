package com.tjcloud.stadium.base.entity;

import java.util.List;

import com.tjcloud.core.annotation.LogRequired;
import com.tjcloud.core.entity.AbstractEntity;
import com.tjcloud.stadium.api.vo.StadiumItemOpeningTimeVO;
import com.tjcloud.stadium.api.vo.StadiumItemVO;

/**
 * 场馆项目(stadium_item)
 * @author auto bin.yin 2016.05.10
 */
public class StadiumItem extends AbstractEntity {
	private static final long serialVersionUID = 1462853057760L;

	private String stadiumItemName; //子项目名字
	private String tenantId; //所属商户,关键字段
	private String stadiumId; //所属场馆,关键字段
	private String stadiumName; // 场馆名称
	private Boolean converted; // 是否横竖转换
	private Integer bookMode; //预订模式,1-场地预订,2-人数预订,关键字段
	private String sportType; //项目类型，篮球，羽毛球,关键字段
	private String sportTypeCode;//项目类型code
	private String contactName; //子场馆联系人姓名,关键字段
	private String telephone;	// 子场馆联系方式
	private String bookPhone; //订场电话,关键字段
	private String noticePhone; //接收短信提醒号码,多个号码,关键字段
	private Integer allowBookingTenantDays; //提前开放天数,关键字段
	private Integer allowBookingPlatformDays; //平台提前开放天数
	private float cancelBookingTenantHours; //允许退订天数,关键字段
	private float cancelBookingPlatformHours; //平台允许退订天数
	private String tagLabel; //属性标签,以逗号分隔
	private Boolean platformOnline; //平台上线,true-上线
	private Boolean ctripOnline; //携程上线,true-上线
	private Boolean aliOnline; //阿里体育上线,true-上线
	private Boolean mapOnline; //电子地图产品上下线
	private Boolean zfbOnline; //支付宝上线,true-上线

	private Boolean jdOnline; //阿里体育上线,true-上线
	private Boolean nuomiOnline; //糯米上线,true-上线
	private Boolean dianpingOnline; //大众点评上线,false-未上线，true-上线
	private Boolean shareOnline; //共享场馆上线,false-未上线，true-上线
	private Boolean isShare; 									//是否共享场馆项目
	private Integer minPrice;     //最小价格(单位：分)
	private Integer maxPrice;     //最大价格(单位：分)
	private String floorHeight;			//层高
	private String environment;			//环境
	private Integer fieldCount;		//场地数量
	private String notice;			//场馆公告
	private Boolean online; //挂起状态 false-未挂起，true-挂起
	private String description; //描述
	private String material; 	// 材质
	private String tips;		//提示
	private Integer source;		// 0-我要运动 1-携程 2-上海体育局  9—场馆中心对接过来的
	private String venueId;		//第三方渠道场馆id
	private String sportId;	//第三方渠道运动类型id
	private Integer nonstandardPrice;	//体育局对接是否标准价格(0-标准 1-非标准)
	private Integer minute;	//第三方渠道运动类型id
	private String weChatGroup;	//微信群二维码
	private Integer limitOrderTimes; //限制单日场地预定数量
	private Integer opennessSchool;  //0-普通 1-学校开放
	private Integer venueType;  //0-学校场地 1-开放场地
	private String grade;			//综合评分
	private String serviceGrade;	//服务评价
	private Boolean canInvoicing;           //场馆0-不可开票 1-支持开票
	private Boolean platformCanInvoicing;	//平台0-不可开票 1-支持开票
	private String jVenueId;		//京东场馆id
	private String jWareId;		//京东商品id
	private String zfbVenueId;   //支付宝场馆id
	private Boolean stadiumShow;   //是否在我要运动展示

	//每个场馆有俩个营业时间 一个正常营业时间 一个临时营业时间
	private List<StadiumItemOpeningTimeVO> stadiumItemOpeningTimeVOList;
	private List<ImageAsset> imageUrlList;		// 图片

	private StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOAlways;
	private StadiumItemOpeningTimeVO stadiumItemOpeningTimeVOFalse;
	
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
	public String getServiceGrade() {
		return serviceGrade;
	}
	public void setServiceGrade(String serviceGrade) {
		this.serviceGrade = serviceGrade;
	}
	public Boolean getPlatformCanInvoicing() {
		return platformCanInvoicing;
	}
	public void setPlatformCanInvoicing(Boolean platformCanInvoicing) {
		this.platformCanInvoicing = platformCanInvoicing;
	}
	public Boolean getCanInvoicing() {
		return canInvoicing;
	}
	public void setCanInvoicing(Boolean canInvoicing) {
		this.canInvoicing = canInvoicing;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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

	public Integer getNonstandardPrice() {
		return nonstandardPrice;
	}
	public void setNonstandardPrice(Integer nonstandardPrice) {
		this.nonstandardPrice = nonstandardPrice;
	}
	public Integer getLimitOrderTimes() {
		return limitOrderTimes;
	}
	public void setLimitOrderTimes(Integer limitOrderTimes) {
		this.limitOrderTimes = limitOrderTimes;
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
	public Integer getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Integer getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}
	public String getStadiumItemName() {
		return stadiumItemName;
	}
	public void setStadiumItemName(String stadiumItemName) {
		this.stadiumItemName = stadiumItemName;
	}
	public String getSportTypeCode() {
		return sportTypeCode;
	}
	public void setSportTypeCode(String sportTypeCode) {
		this.sportTypeCode = sportTypeCode;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public List<ImageAsset> getImageUrlList() {
		return imageUrlList;
	}
	public void setImageUrlList(List<ImageAsset> imageUrlList) {
		this.imageUrlList = imageUrlList;
	}
	
	public String getTenantId() {
		return this.tenantId;
	}
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getStadiumName() {
		return stadiumName;
	}
	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}
	
	public String getStadiumId() {
		return this.stadiumId;
	}
	public void setStadiumId(String stadiumId) {
		this.stadiumId = stadiumId;
	}

	public Integer getBookMode() {
		return this.bookMode;
	}
	public void setBookMode(Integer bookMode) {
		this.bookMode = bookMode;
	}

	public String getSportType() {
		return this.sportType;
	}
	public void setSportType(String sportType) {
		this.sportType = sportType;
	}
	public float getCancelBookingTenantHours() {
		return cancelBookingTenantHours;
	}
	public void setCancelBookingTenantHours(float cancelBookingTenantHours) {
		this.cancelBookingTenantHours = cancelBookingTenantHours;
	}
	public float getCancelBookingPlatformHours() {
		return cancelBookingPlatformHours;
	}
	public void setCancelBookingPlatformHours(float cancelBookingPlatformHours) {
		this.cancelBookingPlatformHours = cancelBookingPlatformHours;
	}
	public String getContactName() {
		return this.contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getBookPhone() {
		return this.bookPhone;
	}
	public void setBookPhone(String bookPhone) {
		this.bookPhone = bookPhone;
	}

	public String getNoticePhone() {
		return this.noticePhone;
	}
	public void setNoticePhone(String noticePhone) {
		this.noticePhone = noticePhone;
	}

	public Integer getAllowBookingTenantDays() {
		return this.allowBookingTenantDays;
	}
	public void setAllowBookingTenantDays(Integer allowBookingTenantDays) {
		this.allowBookingTenantDays = allowBookingTenantDays;
	}

	public Integer getAllowBookingPlatformDays() {
		return this.allowBookingPlatformDays;
	}
	public void setAllowBookingPlatformDays(Integer allowBookingPlatformDays) {
		this.allowBookingPlatformDays = allowBookingPlatformDays;
	}


	public String getTagLabel() {
		return this.tagLabel;
	}
	public void setTagLabel(String tagLabel) {
		this.tagLabel = tagLabel;
	}

	public Boolean getPlatformOnline() {
		return this.platformOnline;
	}
	public void setPlatformOnline(Boolean platformOnline) {
		this.platformOnline = platformOnline;
	}

	public Boolean getDianpingOnline() {
		return this.dianpingOnline;
	}
	public void setDianpingOnline(Boolean dianpingOnline) {
		this.dianpingOnline = dianpingOnline;
	}
	
	public Boolean getShareOnline() {
		return shareOnline;
	}
	public void setShareOnline(Boolean shareOnline) {
		this.shareOnline = shareOnline;
	}
	
	public Boolean getIsShare() {
		return isShare;
	}
	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}
	public Boolean getOnline() {
		return online;
	}
	public void setOnline(Boolean online) {
		this.online = online;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	public Boolean getJdOnline() {
		return jdOnline;
	}
	public void setJdOnline(Boolean jdOnline) {
		this.jdOnline = jdOnline;
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

	public StadiumItem() {
		super();
	}
	public StadiumItem(StadiumItemVO stadiumItemVO) {
		setId(stadiumItemVO.getId());
		setStadiumItemName(stadiumItemVO.getStadiumItemName());
		setTenantId(stadiumItemVO.getTenantId());		// 租户Id
		setStadiumId(stadiumItemVO.getStadiumId());		// 场馆Id
		setStadiumName(stadiumItemVO.getStadiumName());	// 场馆名
		setBookMode(stadiumItemVO.getBookMode());
		setSportType(stadiumItemVO.getSportType());
		setSportTypeCode(stadiumItemVO.getSportTypeCode());
		setContactName(stadiumItemVO.getContactName());
		setTelephone(stadiumItemVO.getTelephone());
		setBookPhone(stadiumItemVO.getBookPhone());
		setNoticePhone(stadiumItemVO.getPhoneList() == null ? null : groupStr(stadiumItemVO.getPhoneList()));
		setAllowBookingTenantDays(stadiumItemVO.getAllowBookingTenantDays());
		setAllowBookingPlatformDays(stadiumItemVO.getAllowBookingPlatformDays());
		setCancelBookingPlatformHours(stadiumItemVO.getCancelBookingPlatformHours());
		setCancelBookingTenantHours(stadiumItemVO.getCancelBookingTenantHours());
		setTagLabel(stadiumItemVO.getTagLabelList() == null ? null : groupStr(stadiumItemVO.getTagLabelList()));
		setMaterial(stadiumItemVO.getMaterial());
		setDescription(stadiumItemVO.getDescription());
		setDisabled(stadiumItemVO.isDisabled());
		setPlatformOnline(stadiumItemVO.getPlatformOnline());
		setCtripOnline(stadiumItemVO.getCtripOnline());
		setJdOnline(stadiumItemVO.getJdOnline());
		setAliOnline(stadiumItemVO.getAliOnline());
		setNuomiOnline(stadiumItemVO.getNuomiOnline());
		setDianpingOnline(stadiumItemVO.getDianpingOnline());
		setMinPrice(stadiumItemVO.getMinPrice());
		setMaxPrice(stadiumItemVO.getMaxPrice());
		setFloorHeight(stadiumItemVO.getFloorHeight());
		setEnvironment(stadiumItemVO.getEnvironment());
		setFieldCount(stadiumItemVO.getFieldCount());
		setNotice(stadiumItemVO.getNotice());
		setLimitOrderTimes(stadiumItemVO.getLimitOrderTimes());
		setTips(stadiumItemVO.getTips());
		setSource(stadiumItemVO.getSource());
		setVenueId(stadiumItemVO.getVenueId());
		setSportId(stadiumItemVO.getSportId());
		setOnline(stadiumItemVO.getOnline());
		setIsShare(stadiumItemVO.getIsShare());
		setImageUrlList(stadiumItemVO.getImageUrlList());
		setOpennessSchool(stadiumItemVO.getOpennessSchool());
		setVenueType(stadiumItemVO.getVenueType());
		setStadiumItemOpeningTimeVOList(stadiumItemVO.getStadiumItemOpeningTimeVOList());
		setCanInvoicing(stadiumItemVO.getCanInvoicing());
		setPlatformCanInvoicing(stadiumItemVO.getPlatformCanInvoicing());
		setServiceGrade(stadiumItemVO.getServiceGrade());
		setjVenueId(stadiumItemVO.getjVenueId());
		setMapOnline(stadiumItemVO.getMapOnline());
		setConverted(stadiumItemVO.getConverted());
		setZfbOnline(stadiumItemVO.getZfbOnline());
		setZfbVenueId(stadiumItemVO.getZfbVenueId());
		setStadiumShow(stadiumItemVO.getStadiumShow());
	}
	
	private String groupStr(List<String> strList){
		String str = "";
		for(int i = 0 ;i < strList.size(); i++){
			str += strList.get(i);
			if(i != strList.size()-1){
				str += ",";
			}
		}
		return str;
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
	public Boolean getAliOnline() {
		return aliOnline;
	}
	public void setAliOnline(Boolean aliOnline) {
		this.aliOnline = aliOnline;
	}
	public void setNuomiOnline(Boolean nuomiOnline) {
		this.nuomiOnline = nuomiOnline;
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
	public Integer getMinute() {
		return minute;
	}
	public void setMinute(Integer minute) {
		this.minute = minute;
	}
	public String getWeChatGroup() {
		return weChatGroup;
	}
	public void setWeChatGroup(String weChatGroup) {
		this.weChatGroup = weChatGroup;
	}

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

	public Boolean getStadiumShow() {
		return stadiumShow;
	}

	public void setStadiumShow(Boolean stadiumShow) {
		this.stadiumShow = stadiumShow;
	}
}