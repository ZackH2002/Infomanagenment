package com.xianyu.dao.impl;

import com.xianyu.dao.GoodsDao;
import com.xianyu.entity.Goods;
import com.xianyu.entity.Order;
import com.xianyu.utils.JDBCUtils;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hyc
 * @createTime 06 17:52
 * @description
 */
@SuppressWarnings("all")
public class GoodsDAOImpl implements GoodsDao {

    /**
     * 展示商品页
     *
     * @return 商品集合
     */
    @Override
    public List<Goods> listGoods() {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM goods";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Goods> list = new ArrayList<>();
        Goods good;
        try {
            statement = conn.prepareStatement(sql);
            // 执行查询语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                good = new Goods();
                good.setGoodsId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getDouble(3));
                good.setUrl(resultSet.getString(4));
                good.setNum(resultSet.getInt(5));
                good.setSellerId(resultSet.getInt(6));
                good.setContent(resultSet.getString(7));
                list.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }

        return list;
    }


    /**
     * 添加商品信息
     *
     * @param goods 商品实体
     * @return 是否添加成功
     */
    @Override
    public boolean insertGoods(Goods goods) {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "INSERT INTO goods(name, price, url, num, seller_id, content) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = null;
        int re = 0;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, goods.getName());
            statement.setDouble(2, goods.getPrice());
            statement.setString(3, goods.getUrl());
            statement.setInt(4, goods.getNum());
            statement.setInt(5, goods.getSellerId());
            statement.setString(6, goods.getContent());
            re = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
        }
        return re > 0;
    }


    @Override
    public boolean updateGoodsNum(int goodsId) {
        int re;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "UPDATE goods SET num = num - 1 WHERE goods_id = ?";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, goodsId);
            re = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
        }

        return re > 0;
    }

    @Override
    public boolean createOrder(Order order) {

        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "INSERT INTO order_detail(order_id, goods_id, goods_name, seller_id, buyer_id, order_time, url , price) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        int re = 0;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, order.getOrderId());
            statement.setInt(2, order.getGoodsId());
            statement.setString(3, order.getGoodsName());
            statement.setInt(4, order.getSellerId());
            statement.setInt(5, order.getBuyerId());
            statement.setDate(6, order.getOrderTime());
            statement.setString(7, order.getUrl());
            statement.setDouble(8, order.getPrice());
            re = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
        }
        return re > 0;
    }


    @Override
    public List<Order> listOrder(int userId) {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM order_detail WHERE buyer_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        Order order;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            // 执行查询语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setOrderId(resultSet.getString(1));
                order.setGoodsId(resultSet.getInt(2));
                order.setGoodsName(resultSet.getString(3));
                order.setSellerId(resultSet.getInt(4));
                order.setBuyerId(resultSet.getInt(5));
                order.setOrderTime(resultSet.getDate(6));
                order.setUrl(resultSet.getString(7));
                order.setPrice(resultSet.getDouble(8));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }

        return list;

    }


    @Override
    public int getGoodsNum(int goodsId) {
        int goodsNum = 0;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT num FROM goods WHERE goods_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, goodsId);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                goodsNum = resultSet.getInt(1);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return goodsNum;
    }


    @Override
    public List<Goods> listPostById(int userId) {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM goods WHERE seller_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Goods> list = new ArrayList<>();
        Goods good;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            // 执行查询语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                good = new Goods();
                good.setGoodsId(resultSet.getInt(1));
                good.setName(resultSet.getString(2));
                good.setPrice(resultSet.getDouble(3));
                good.setUrl(resultSet.getString(4));
                good.setNum(resultSet.getInt(5));
                good.setSellerId(resultSet.getInt(6));
                good.setContent(resultSet.getString(7));
                list.add(good);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }

        return list;

    }

    @Override
    public List<Order> listSellerOrder(int sellerId) {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM order_detail WHERE seller_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> list = new ArrayList<>();
        Order order;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, sellerId);
            // 执行查询语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                order = new Order();
                order.setOrderId(resultSet.getString(1));
                order.setGoodsId(resultSet.getInt(2));
                order.setGoodsName(resultSet.getString(3));
                order.setSellerId(resultSet.getInt(4));
                order.setBuyerId(resultSet.getInt(5));
                order.setOrderTime(resultSet.getDate(6));
                order.setUrl(resultSet.getString(7));
                order.setPrice(resultSet.getDouble(8));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }

        return list;

    }
}
