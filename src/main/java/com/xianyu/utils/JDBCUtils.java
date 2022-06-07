package com.xianyu.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * @author hyc
 * @createTime 01 19:53
 * @description JDBC工具类
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
    static {
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
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 封装PreparedStatement与Connection对象销毁细节
     */
    public static void close(PreparedStatement ps, Connection conn) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 封装PreparedStatement与Connection与ResultSet对象销毁细节
     *
     * @param rs 查询结果集
     */
    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

}
