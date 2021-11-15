package com.tjcloud.order.api.vo;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * 场地利用率
 * @author wufu
 *
 */
public class SiteUsageVO {
	
	private int weekD;					// 星期数:1为星期一，7为星期天
	private BigDecimal morningHour;		// 早上使用场时
	private BigDecimal noonHour;		// 中午使用场时
	private BigDecimal nightHour;		// 晚上使用场时
	private BigDecimal totalOpenHour;	// 总开放场时
	private BigDecimal morningOpenHour;	// 早上总开放场时
	private BigDecimal noonOpenHour;	// 中午总开放场时
	private BigDecimal nightOpenHour;	// 晚上总开放场时
	private BigDecimal morningUsageRate;// 场地-早上利用率
	private BigDecimal noonUsageRate;	// 场地-中午利用率
	private BigDecimal nightUsageRate;	// 场地-晚上利用率
	private BigDecimal averageUsageRate;	// 场地-平均利用率
	
	public SiteUsageVO(){
		
	}
	
	public SiteUsageVO(int weekD){
		this.weekD = weekD;
		this.morningHour = new BigDecimal(0);
		this.noonHour = new BigDecimal(0);
		this.nightHour = new BigDecimal(0);
		this.totalOpenHour = new BigDecimal(0);
		this.morningOpenHour = new BigDecimal(0);
		this.noonOpenHour = new BigDecimal(0);
		this.nightOpenHour = new BigDecimal(0);
		this.morningUsageRate = new BigDecimal(0);
		this.noonUsageRate = new BigDecimal(0);
		this.nightUsageRate = new BigDecimal(0);
		this.averageUsageRate = new BigDecimal(0);
	}
	
	public int getWeekD() {
		return weekD;
	}
	public void setWeekD(int weekD) {
		this.weekD = weekD;
	}
	public BigDecimal getMorningHour() {
		return morningHour;
	}
	public void setMorningHour(BigDecimal morningHour) {
		this.morningHour = morningHour;
	}
	public BigDecimal getNoonHour() {
		return noonHour;
	}
	public void setNoonHour(BigDecimal noonHour) {
		this.noonHour = noonHour;
	}
	public BigDecimal getNightHour() {
		return nightHour;
	}
	public void setNightHour(BigDecimal nightHour) {
		this.nightHour = nightHour;
	}
	public BigDecimal getMorningOpenHour() {
		return morningOpenHour;
	}
	public void setMorningOpenHour(BigDecimal morningOpenHour) {
		this.morningOpenHour = morningOpenHour;
	}
	public BigDecimal getNoonOpenHour() {
		return noonOpenHour;
	}
	public void setNoonOpenHour(BigDecimal noonOpenHour) {
		this.noonOpenHour = noonOpenHour;
	}
	public BigDecimal getNightOpenHour() {
		return nightOpenHour;
	}
	public void setNightOpenHour(BigDecimal nightOpenHour) {
		this.nightOpenHour = nightOpenHour;
	}
	public BigDecimal getMorningUsageRate() {
		return morningUsageRate;
	}
	public void setMorningUsageRate(BigDecimal morningUsageRate) {
		this.morningUsageRate = morningUsageRate;
	}
	public BigDecimal getNoonUsageRate() {
		return noonUsageRate;
	}
	public void setNoonUsageRate(BigDecimal noonUsageRate) {
		this.noonUsageRate = noonUsageRate;
	}
	public BigDecimal getNightUsageRate() {
		return nightUsageRate;
	}
	public void setNightUsageRate(BigDecimal nightUsageRate) {
		this.nightUsageRate = nightUsageRate;
	}
	public BigDecimal getAverageUsageRate() {
		return averageUsageRate;
	}
	public void setAverageUsageRate(BigDecimal averageUsageRate) {
		this.averageUsageRate = averageUsageRate;
	}
	public BigDecimal getTotalOpenHour() {
		return totalOpenHour;
	}
	public void setTotalOpenHour(BigDecimal totalOpenHour) {
		this.totalOpenHour = totalOpenHour;
	}
	
	public int getCalendarWeek(){
		switch (this.weekD) {
		case 1:
			return Calendar.MONDAY;
		case 2:
			return Calendar.TUESDAY;
		case 3:
			return Calendar.WEDNESDAY;
		case 4:
			return Calendar.THURSDAY;
		case 5:
			return Calendar.FRIDAY;
		case 6:
			return Calendar.SATURDAY;
		case 7:
			return Calendar.SUNDAY;
		default:
			return weekD;
		}
	}
	
	public String getWeekDTxt(){
		if(this.weekD == 0){
			return "";
		}
		switch (this.weekD) {
		case 1:
			return "周一";
		case 2:
			return "周二";
		case 3:
			return "周三";
		case 4:
			return "周四";
		case 5:
			return "周五";
		case 6:
			return "周六";
		case 7:
			return "周日";
		default:
			return "";
		}
	}
	
	/**
	 * 计算场地利用率
	 */
	public void calcUsageRate(){
		// 计算早上、中午、晚上 三时段的场地利用率
		this.morningUsageRate = this.morningOpenHour.doubleValue() == 0? new BigDecimal(0): this.morningHour.divide(this.morningOpenHour,4,BigDecimal.ROUND_HALF_UP);
		this.noonUsageRate = this.noonOpenHour.doubleValue() == 0? new BigDecimal(0): this.noonHour.divide(this.noonOpenHour,4,BigDecimal.ROUND_HALF_UP);
		this.nightUsageRate = this.nightOpenHour.doubleValue() == 0? new BigDecimal(0): this.nightHour.divide(this.nightOpenHour,4,BigDecimal.ROUND_HALF_UP);
		
		// 计算场地平均利用率
		this.averageUsageRate = (this.morningUsageRate.add(this.noonUsageRate).add(this.nightUsageRate)).divide(new BigDecimal(3),4,BigDecimal.ROUND_HALF_UP);
	}
	
    DecimalFormat df =new DecimalFormat("#.##%");

	public String getMorningUsageRateTxt(){
		// 四舍五入，保留小数点后两位
		BigDecimal morningUsageRateScaler = this.morningUsageRate.setScale(4, BigDecimal.ROUND_HALF_UP);
		return df.format(morningUsageRateScaler.doubleValue());
	}
	public String getNoonUsageRateTxt(){
		// 四舍五入，保留小数点后两位
		BigDecimal noonUsageRateScaler = this.noonUsageRate.setScale(4, BigDecimal.ROUND_HALF_UP);
		return df.format(noonUsageRateScaler.doubleValue());
	}
	public String getNightUsageRateTxt(){
		// 四舍五入，保留小数点后两位
		BigDecimal nightUsageRateScaler = this.nightUsageRate.setScale(4, BigDecimal.ROUND_HALF_UP);
		return df.format(nightUsageRateScaler.doubleValue());
	}
	public String getAverageUsageRateTxt(){
		// 四舍五入，保留小数点后两位
		BigDecimal averageUsageRateScaler = this.averageUsageRate.setScale(4, BigDecimal.ROUND_HALF_UP);
		return df.format(averageUsageRateScaler.doubleValue());
	}
}
