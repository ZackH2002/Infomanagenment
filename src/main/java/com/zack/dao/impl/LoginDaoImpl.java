package com.zack.dao.impl;

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
        // 编写SQL语句 插入信息
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
            JDBCUtils.close(statement, conn);
            JDBCUtils.close(resultSet);
        }
        return user;
    }


}
