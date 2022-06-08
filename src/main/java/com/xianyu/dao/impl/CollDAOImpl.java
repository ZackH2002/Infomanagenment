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
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "INSERT INTO collection(goods_name,goods_id,user_id,goods_price,goods_num)";


        return false;
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
