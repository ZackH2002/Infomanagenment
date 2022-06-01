package com.zack.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author hyc
 * @createTime 01 19:53
 * @description
 */

@SuppressWarnings("all")
public class JDBCUtils {

    /**
     * 驱动
     */
    private static String driver;
    /**
     * 数据库连接url
     */
    private static String url;
    /**
     * 数据库用户名
     */
    private static String username;
    /**
     * 数据库密码
     */
    private static String password;

    /**
     * 读书db文件 获取对应信息
     */
    static{
        ResourceBundle bundle = ResourceBundle.getBundle("db");
        driver = bundle.getString("driver");
        url = bundle.getString("url");
        username = bundle.getString("username");
        password = bundle.getString("password");
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // 加载驱动
            Class.forName(driver);
            // 获取连接
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 释放资源
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        if(resultSet!=null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement!=null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
