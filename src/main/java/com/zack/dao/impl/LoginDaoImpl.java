package com.zack.dao.impl;

import com.zack.VO.ResultVO;
import com.zack.dao.LoginDao;
import com.zack.entity.UserLogin;
import com.zack.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hyc
 * @createTime 01 20:42
 * @description
 */
@SuppressWarnings("all")
public class LoginDaoImpl implements LoginDao {

    @Override
    public UserLogin queryUser(String account, String userPwd) {
        UserLogin user = null;
        int result = 0;
        // 获取jdbc连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT id,account,user_pwd FROM user_login WHERE account = ? AND user_pwd = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.prepareStatement(sql);
            // 给SQL语句占位符赋值
            statement.setString(1, account);
            statement.setString(2, userPwd);
            // 执行查询语句
            resultSet = statement.executeQuery();
            // 循环读取数据
            while (resultSet.next()) {
                user = new UserLogin();
                user.setUserId(resultSet.getInt(1));
                user.setAccount(resultSet.getString(2));
                user.setUserPwd(resultSet.getString(3));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }
        return user;
    }

    @Override
    public int insertUser(String account, String userPwd) {
        int re = 0;
        // 获取连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "INSERT INTO user_login(account, user_pwd) VALUES(?, ?)";
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1, account);
            statement.setString(2, userPwd);
            re = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.close(statement, conn);
        }
        return re;
    }


    @Override
    public boolean findUserByAccount(String account) {

        // 获取连接
        Connection conn = JDBCUtils.getConnection();
        // 编写SQL语句
        String sql = "SELECT * FROM user_login WHERE account = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            statement =  conn.prepareStatement(sql);
            statement.setString(1,account);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }
        // 用户名不存在
        if (resultSet != null) {
            return false;
        }
        return true;
    }
}
