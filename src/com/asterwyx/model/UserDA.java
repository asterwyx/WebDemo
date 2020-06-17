package com.asterwyx.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDA {
    // 这个DA类目前只提供一个工具方法
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 连接数据库
        String user = "root";
        String passwd = "4718";
        String url = "jdbc:mysql://localhost:3306/web_demo";
        Connection connection = DriverManager.getConnection(url, user, passwd);
        return connection;
    }
}
