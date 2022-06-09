package com.xianyu.dao.impl;

import com.xianyu.dao.CollDAO;
import com.xianyu.entity.Collection;
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
 * @createTime 08 16:18
 * @description
 */
public class CollDAOImpl implements CollDAO {


    @Override
    public boolean addColl(Collection collection) {
        int i = 0;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "INSERT INTO collection(goods_name,goods_id,user_id,goods_price,goods_num,url) VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, collection.getGoodsName());
            statement.setInt(2, collection.getGoodsId());
            statement.setInt(3, collection.getUserId());
            statement.setDouble(4, collection.getGoodsPrice());
            statement.setInt(5, collection.getGoodsNum());
            statement.setString(6, collection.getUrl());
            i = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
        }

        return i > 0;
    }

    @Override
    public List<Collection> listColl(int userId) {

        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM collection WHERE user_id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Collection> list = new ArrayList<>();
        Collection coll;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            // 执行查询语句
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                coll = new Collection();
                coll.setCollId(resultSet.getInt(1));
                coll.setGoodsName(resultSet.getString(2));
                coll.setGoodsId(resultSet.getInt(3));
                coll.setUserId(resultSet.getInt(4));
                coll.setGoodsPrice(resultSet.getDouble(5));
                coll.setGoodsNum(resultSet.getInt(6));
                coll.setUrl(resultSet.getString(7));
                list.add(coll);
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
