package com.xianyu.entity;

import com.sun.scenario.effect.impl.prism.PrImage;

import java.util.Date;

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




}
