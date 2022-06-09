package com.xianyu.entity;

/**
 * @author hyc
 * @createTime 07 17:02
 * @description 用户收藏商品信息
 */
public class Collection {

    /**
     * 主键
     */
    private int collId;

    /**
     * 收藏商品名
     */
    private String goodsName;

    /**
     * 收藏商品id
     */
    private int goodsId;

    /**
     * 收藏用户id
     */
    private int userId;

    /**
     * 商品价格
     */
    private double goodsPrice;

    /**
     * 商品库存
     */
    private int goodsNum;

    /**
     * 商品图片地址
     */
    private String url;

    /**
     * 收藏品卖家id
     */
    private int ownerId;

    public Collection() {
    }

    public int getCollId() {
        return collId;
    }

    public void setCollId(int collId) {
        this.collId = collId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }
}
