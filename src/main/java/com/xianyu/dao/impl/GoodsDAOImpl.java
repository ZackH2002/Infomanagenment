package com.xianyu.dao.impl;

import com.xianyu.dao.GoodsDao;
import com.xianyu.entity.Goods;
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
public class GoodsDAOImpl implements GoodsDao {

    /**
     * 展示商品页
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
        }finally {
            JDBCUtils.close(statement, conn);
        }
        return re > 0;
    }
}
