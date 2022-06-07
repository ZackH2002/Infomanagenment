package com.xianyu.service;

import cn.hutool.core.collection.CollUtil;
import com.xianyu.VO.ResultVO;
import com.xianyu.entity.Goods;
import com.xianyu.dao.GoodsDao;
import com.xianyu.dao.impl.GoodsDAOImpl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyc
 * @createTime 06 17:41
 * @description 主页相关操作
 */
public class GoodsService {

    /**
     * 注入dao层
     */
    GoodsDao goodsDAO = new GoodsDAOImpl();

    /**
     * 获取所有商品信息
     * @return 返回商品集合
     */
    public ResultVO listGoods() {
        ResultVO result = new ResultVO();
        //Map<String, List<Goods>> map = new HashMap<>(2);
        // 获取所有商品
        List<Goods> list = goodsDAO.listGoods();
        if (CollUtil.isEmpty(list)) {
            return result.message("操作失败!").code(400);
        }
        // 获取成功
        map.put("goodsList", list);
        return result.message("操作成功!").code(200);
    }

    /**
     * 添加商品信息
     * @param goods 商品实体
     * @return result
     */
    public ResultVO addGoods(Goods goods) {
        ResultVO result = new ResultVO();
        if (goods == null) {
            return result.message("商品信息不能为空!").code(302);
        }
        // 商品添加失败
        if (!goodsDAO.insertGoods(goods)) {
            return result.message("操作失败!").code(500);
        }
        // 添加成功
        return result.message("添加成功!").code(200);
    }




}
