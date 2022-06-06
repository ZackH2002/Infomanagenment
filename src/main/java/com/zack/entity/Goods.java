package com.zack.entity;

/**
 * @author Zack
 * on 2022/6/6 10:41
 */
public class Goods {

    /**
     * id主键
     */
    private int goodsId;

    /**
     * name 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private double price;

    /**
     * 图片
     */
    private String url;

    /**
     * 库存
     */
    private int num;

    /**
     * 卖家id
     */
    private int sellerId;

    /**
     *介绍
     */
    private String content;
    public Goods() {
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
