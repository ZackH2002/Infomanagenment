package com.xianyu.service;

import com.xianyu.VO.ResultVO;
import com.xianyu.dao.CollDAO;
import com.xianyu.dao.impl.CollDAOImpl;
import com.xianyu.entity.Collection;

import java.util.List;

/**
 * @author hyc
 * @createTime 09 14:30
 * @description
 */
public class CollService {

    /**
     * 注入dao层
     */
    CollDAO collDAO = new CollDAOImpl();

    /**
     * 添加收藏商品
     * @param coll 商品实体
     * @return result
     */
    public ResultVO addFavorite(Collection coll) {
        ResultVO result = new ResultVO();
        if (coll == null) {
            return result.message("操作异常").code(500);
        }
        // 收藏失败
        if (!collDAO.addColl(coll)) {
            return result.message("操作失败!").code(500);
        }
        return result.message("操作成功！").code(200);
    }

    /**
     * 通过id查询用户收藏商品
     * @param userId 用户id
     * @return 商品集合
     */
    public List<Collection> listColl(int userId) {
        // 判断用户id是否非法
        if (userId <= 0) {
            return null;
        }

        return collDAO.listColl(userId);

    }



}
