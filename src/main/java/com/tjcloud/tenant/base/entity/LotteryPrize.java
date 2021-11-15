package com.tjcloud.tenant.base.entity;

import com.tjcloud.core.entity.AbstractEntity;

/**
 * 奖品(lottery_prize)
 * @author auto bin.yin 2018.07.26
 */
public class LotteryPrize extends AbstractEntity {
	private static final long serialVersionUID = 1532590515997L;

	private String lotteryId; //抽奖活动ID
	private Integer type; //奖品类型(0.阳光普照,1.中奖)
	private Integer index; //奖品等级
	private String name; //奖品名称
	private Integer quantity; //奖品数量
	private Integer awardQuantity; //已中奖次数
	private Integer balanceQuantity; //剩余中奖次数
	private Integer probability; //中状概率基数
	private Integer probabilityStart; //权重起始值
	private Integer probabilityEnd; //权重结束值
	private String color; //文字颜色
	private String image; //图片路径
	private Integer width; //图片宽度
	private Integer height; //图片高度
	private Integer rank; //显示顺序
	private Boolean isOpen; //是否开放

	public String getLotteryId() {
		return this.lotteryId;
	}
	public void setLotteryId(String lotteryId) {
		this.lotteryId = lotteryId;
	}
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIndex() {
		return this.index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return this.quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getAwardQuantity() {
		return this.awardQuantity;
	}
	public void setAwardQuantity(Integer awardQuantity) {
		this.awardQuantity = awardQuantity;
	}
	public Integer getBalanceQuantity() {
		return this.balanceQuantity;
	}
	public void setBalanceQuantity(Integer balanceQuantity) {
		this.balanceQuantity = balanceQuantity;
	}
	public Integer getProbability() {
		return this.probability;
	}
	public void setProbability(Integer probability) {
		this.probability = probability;
	}
	public Integer getProbabilityStart() {
		return this.probabilityStart;
	}
	public void setProbabilityStart(Integer probabilityStart) {
		this.probabilityStart = probabilityStart;
	}
	public Integer getProbabilityEnd() {
		return this.probabilityEnd;
	}
	public void setProbabilityEnd(Integer probabilityEnd) {
		this.probabilityEnd = probabilityEnd;
	}
	public String getColor() {
		return this.color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getWidth() {
		return this.width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return this.height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getRank() {
		return this.rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Boolean getIsOpen() {
		return this.isOpen;
	}
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}