package com.xianyu.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import com.xianyu.VO.ResultVO;
import com.xianyu.dao.BalanceDAO;
import com.xianyu.dao.GoodsDao;
import com.xianyu.dao.impl.BalanceDAOImpl;
import com.xianyu.dao.impl.GoodsDAOImpl;
import com.xianyu.entity.Order;

import java.sql.Date;
import java.util.List;

/**
 * @author hyc
 * @createTime 07 17:45
 * @description
 */
public class OrderService {

    /**
     * 注入dao
     */
    GoodsDao goodsDao = new GoodsDAOImpl();

    BalanceDAO balanceDAO = new BalanceDAOImpl();

    /**
     * 生成订单
     * @param order 订单实体
     * @return result
     */
    public ResultVO createOrder(Order order) {
        ResultVO result = new ResultVO();
        if (order == null) {
            return result.message("操作失败!").code(302);
        }
        // 判断商品库存数量是否足够
        int goodsNum = goodsDao.getGoodsNum(order.getGoodsId());
        if (goodsNum <= 0) {
            return result.message("商品库存不足!").code(400);
        }
        // 判断账户余额是否足够
        int balance = balanceDAO.getBalanceById(order.getBuyerId());
        if (balance < order.getPrice()) {
            return result.message("余额不足,请充值!").code(400);
        }
        order.setOrderId(IdUtil.simpleUUID());
        order.setOrderTime(new Date(System.currentTimeMillis()));
        System.out.println(new Date(System.currentTimeMillis()));
        try {
            // 订单生成失败
            if (!goodsDao.createOrder(order)) {
                return result.message("操作异常").code(500);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // 订单生成成功 同时商品库存减少
        goodsDao.updateGoodsNum(order.getGoodsId());
        // 账户余额减少
        balanceDAO.deleteBalanceById(order.getPrice(), order.getBuyerId());
        // 卖家余额增加
        balanceDAO.addBalance(order.getPrice(), order.getSellerId());
        return result.message("购买成功!").code(200);
    }


    /**
     * 根据id展示用户所有商品订单
     * @param userId 用户id
     * @return 商品订单集合
     */
    public List<Order> listOrdersById(int userId) {

        if (userId <= 0) {
            return null;
        }
        List<Order> orders = null;
        try {
             orders = goodsDao.listOrder(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return orders;
    }

    /**
     * 根据id查询卖家订单
     * @param sellerId 卖家id
     * @return 订单集合
     */
    public List<Order> listSellerOrderById(int sellerId) {
        if (sellerId <= 0) {
            return null;
        }
        List<Order> orders = null;
        try {
            orders = goodsDao.listSellerOrder(sellerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return orders;
    }


}
