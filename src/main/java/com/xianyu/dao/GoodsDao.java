package com.xianyu.dao;

import com.xianyu.entity.Goods;


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





}
