package com.xianyu.entity;


import java.sql.Date;

/**
 * @author hyc
 * @createTime 07 15:34
 * @description 商品订单实体
 */
public class Order {

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 商品id
     */
    private int goodsId;

    /**
     * 商品名
     */
    private String goodsName;

    /**
     * 卖家id
     */
    private int sellerId;

    /**
     * 买家id
     */
    private int buyerId;

    /**
     * 订单成交时间
     */
    private Date orderTime;

    /**
     * 商品图片地址
     */
    private String url;

    /**
     * 商品价格
     */
    private double price;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(int buyerId) {
        this.buyerId = buyerId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
