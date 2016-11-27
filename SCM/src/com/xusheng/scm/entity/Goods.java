package com.xusheng.scm.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable{
	
	private static final long serialVersionUID = 6177527638436029755L;

	private String goodsId;

    private String goodsName;

    private String goodsUnit;

    private String goodsType;

    private String goodsColor;

    private Integer goodsStore;

    private Integer goodsLimit;

    private BigDecimal goodsCommission;

    private String goodsProducer;

    private String goodsRemark;

    private BigDecimal goodsSelPrice;

    private BigDecimal goodsBuyPrice;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUnit() {
        return goodsUnit;
    }

    public void setGoodsUnit(String goodsUnit) {
        this.goodsUnit = goodsUnit;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getGoodsColor() {
        return goodsColor;
    }

    public void setGoodsColor(String goodsColor) {
        this.goodsColor = goodsColor;
    }

    public Integer getGoodsStore() {
        return goodsStore;
    }

    public void setGoodsStore(Integer goodsStore) {
        this.goodsStore = goodsStore;
    }

    public Integer getGoodsLimit() {
        return goodsLimit;
    }

    public void setGoodsLimit(Integer goodsLimit) {
        this.goodsLimit = goodsLimit;
    }

    public BigDecimal getGoodsCommission() {
        return goodsCommission;
    }

    public void setGoodsCommission(BigDecimal goodsCommission) {
        this.goodsCommission = goodsCommission;
    }

    public String getGoodsProducer() {
        return goodsProducer;
    }

    public void setGoodsProducer(String goodsProducer) {
        this.goodsProducer = goodsProducer;
    }

    public String getGoodsRemark() {
        return goodsRemark;
    }

    public void setGoodsRemark(String goodsRemark) {
        this.goodsRemark = goodsRemark;
    }

    public BigDecimal getGoodsSelPrice() {
        return goodsSelPrice;
    }

    public void setGoodsSelPrice(BigDecimal goodsSelPrice) {
        this.goodsSelPrice = goodsSelPrice;
    }

    public BigDecimal getGoodsBuyPrice() {
        return goodsBuyPrice;
    }

    public void setGoodsBuyPrice(BigDecimal goodsBuyPrice) {
        this.goodsBuyPrice = goodsBuyPrice;
    }

	public Goods(String goodsId, String goodsName, String goodsUnit,
			String goodsType, String goodsColor, Integer goodsStore,
			Integer goodsLimit, BigDecimal goodsCommission,
			String goodsProducer, String goodsRemark, BigDecimal goodsSelPrice,
			BigDecimal goodsBuyPrice) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsUnit = goodsUnit;
		this.goodsType = goodsType;
		this.goodsColor = goodsColor;
		this.goodsStore = goodsStore;
		this.goodsLimit = goodsLimit;
		this.goodsCommission = goodsCommission;
		this.goodsProducer = goodsProducer;
		this.goodsRemark = goodsRemark;
		this.goodsSelPrice = goodsSelPrice;
		this.goodsBuyPrice = goodsBuyPrice;
	}

	public Goods() {}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName
				+ ", goodsUnit=" + goodsUnit + ", goodsType=" + goodsType
				+ ", goodsColor=" + goodsColor + ", goodsStore=" + goodsStore
				+ ", goodsLimit=" + goodsLimit + ", goodsCommission="
				+ goodsCommission + ", goodsProducer=" + goodsProducer
				+ ", goodsRemark=" + goodsRemark + ", goodsSelPrice="
				+ goodsSelPrice + ", goodsBuyPrice=" + goodsBuyPrice + "]";
	}
    
    
}