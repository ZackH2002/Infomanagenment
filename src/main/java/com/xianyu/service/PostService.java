package com.xianyu.service;

import com.xianyu.dao.GoodsDao;
import com.xianyu.dao.impl.GoodsDAOImpl;
import com.xianyu.entity.Goods;

import java.util.List;

/**
 * @author 何雨灿
 * @createTime 09 15:24
 * @description
 */
public class PostService {

    /**
     * 注入dao
     */
    GoodsDao goodsDao = new GoodsDAOImpl();

    public List<Goods> listPostGoods(int userId) {
        // 判断参数是否非法
        if (userId <= 0) {
            return null;
        }
        return goodsDao.listPostById(userId);
    }
}
