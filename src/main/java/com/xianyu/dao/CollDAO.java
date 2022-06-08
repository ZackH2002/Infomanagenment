package com.xianyu.dao;

import com.xianyu.entity.Collection;

import java.util.List;

/**
 * @author hyc
 * 收藏商品dao层
 */
public interface CollDAO {

    /**
     * 用户添加收藏品
     * @param collection 收藏品实体
     * @return 是否添加成功
     */
    boolean addColl(Collection collection);

    /**
     * 通过用户id展示用户收藏商品
     * @param userId 用户id
     * @return 收藏商品集合
     */
    List<Collection> listColl(int userId);
}
