package com.asterwyx.utils;

import java.sql.*;

public class DBUtil {
    // 这个类主要完成驱动的加载和连接的获取
    public static String dbDriverClass = "com.mysql.jdbc.Driver";
    private Connection conn;
    private PreparedStatement stmt;
    private String dbName;
    private String connUserName;
    private String userPassword;
    private String dbType;
    private String connHost;
    private int connPort;

    // 静态代码块，用于加载驱动
    static {
        try {
            Class.forName(dbDriverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DBUtil() {
        this.conn = null;
        this.dbName = "web_demo";
        this.connUserName = "root";
        this.userPassword = "4718";
        this.dbType = "mysql";
        this.connHost = "localhost";
        this.connPort = 3306;
        // 初始化自动连接
        this.connect();
    }

    /**
     * 根据传入的参数准备statement
     * @param sql 用于准备的sql语句
     */
    private void prepareStatement(String sql, Object[] params) {
        this.closeStatement();
        try {
            this.stmt = this.conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            System.err.println("创建语句对象失败!");
            throwables.printStackTrace();
        }
        // 填入参数
        if (params != null && params.length != 0) {
            for (int i = 0; i < params.length; i++) {
                try {
                    this.stmt.setObject(i + 1, params[i]);
                } catch (SQLException throwables) {
                    System.err.println("设置参数失败!");
                    throwables.printStackTrace();
                }
            }
        }
        System.out.println(this.stmt);
    }


    /**
     * 执行sql语句进行更新并返回更新的状态
     * @param sql 要执行的sql语句
     * @return 更新的状态
     */
    public int doUpdate(String sql, Object[] params) {
        // 首先获取执行语句
        int result = 0; // 这里是影响行数
        this.connect();
        this.prepareStatement(sql, params);
        try {
            result = this.stmt.executeUpdate();
            System.out.println("执行状态:" + result); // 调试用
        } catch (SQLException throwables) {
            System.err.println("更新失败!");
            throwables.printStackTrace();
        }
        this.closeAll();
        return result;
    }



    /**
     * 执行sql语句返回查询到的结果集
     * @param sql 要执行的静态sql语句
     * @return 结果集
     */
    public ResultSet doQuery(String sql, Object[] params) {
        ResultSet result = null;
        this.connect();
        this.prepareStatement(sql, params);
        try {
            result = this.stmt.executeQuery();
        } catch (SQLException throwables) {
            System.err.println("查询结果集出错!");
            throwables.printStackTrace();
        }
        return result;
    }

    public void closeAll() {
        this.closeStatement();
        this.closeConnection();
    }

    private void closeStatement() {
        if (this.stmt != null) {
            try {
                this.stmt.close();
            } catch (SQLException throwables) {
                System.err.println("关闭语句对象失败!");
                throwables.printStackTrace();
            }
        }
    }

    private void closeConnection() {
        if (this.conn != null) {
            try {
                this.conn.close();
            } catch (SQLException throwables) {
                System.err.println("关闭数据库连接失败!");
                throwables.printStackTrace();
            }
        }
    }


    /**
     * 连接到数据库，这是一个私有方法
     */
    private void connect() {
        if (this.conn == null) {
            try {
                this.conn = DriverManager.getConnection("jdbc:" + this.dbType + "://" + this.connHost + ":" + this.connPort + "/" + this.dbName, this.connUserName, this.userPassword);
            } catch (SQLException throwables) {
                System.err.println("建立数据库连接失败!");
                throwables.printStackTrace();
            }
        }
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getConnUserName() {
        return connUserName;
    }

    public void setConnUserName(String connUserName) {
        this.connUserName = connUserName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public String getConnHost() {
        return connHost;
    }

    public void setConnHost(String connHost) {
        this.connHost = connHost;
    }

    public int getConnPort() {
        return connPort;
    }

    public void setConnPort(int connPort) {
        this.connPort = connPort;
    }
}
