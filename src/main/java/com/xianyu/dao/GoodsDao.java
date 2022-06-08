package com.xianyu.dao;

import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;


import java.util.List;

/**
 * @author hyc
 */

public interface GoodsDao {

    /**
     * 获取所有上商品信息
     * @return 商品集合
     */
    List<Goods> listGoods();

    /**
     * 添加商品信息
     * @param goods 商品实体
     * @return 是否添加成功
     */
    boolean insertGoods(Goods goods);

    /**
     * 修改商品库存
     * @param goodsId 商品id
     * @return 是否修改成功
     */
    boolean updateGoodsNum(int goodsId);


    /**
     * 生成订单
     * @param order 订单实体
     * @return 是否成功
     */
    boolean createOrder(Order order);

    /**
     * 通过id查询用户所有订单
     * @param userId 用户id
     * @return 用户订单集合
     */
    List<Order> listOrder(int userId);


}
