package com.xianyu.dao.impl;

import com.xianyu.dao.BalanceDAO;
import com.xianyu.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


    @Override
    public int getBalanceById(int userId) {
        int balance = 0;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT balance FROM user_login WHERE id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                balance = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }

        return balance;
    }


    @Override
    public void deleteBalanceById(double balance, int userId) {
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "UPDATE user_login SET balance = balance - ?  WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setDouble(1, balance);
            statement.setInt(2, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(statement, conn);
        }

    }
}