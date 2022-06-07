package com.xianyu.dao.impl;

import com.xianyu.dao.BalanceDAO;
import com.xianyu.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author hyc
 * @createTime 07 16:00
 * @description
 */
public class BalanceDAOImpl implements BalanceDAO {

    @Override
    public int addBalance(double balance, int userId) {
        int re = 0;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "UPDATE user_login SET balance = balance + ?  WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.setInt(2, userId);
            re = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
        }
        return re;

    }


}
