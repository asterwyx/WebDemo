package com.asterwyx.controller;

import com.asterwyx.model.UserDA;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        try {
            connection = UserDA.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            req.setCharacterEncoding("gb2312");
            String student_id = req.getParameter("student_id");
            String name = new String(req.getParameter("name").getBytes(StandardCharsets.ISO_8859_1),"UTF-8");
            String password = req.getParameter("password");
            String age = req.getParameter("age");
            String gender = req.getParameter("gender");
            String address = req.getParameter("address");
            String sql = "INSERT INTO student_info (name, student_id, gender, age, password, address) VALUES (\"" + name + "\", \"" + student_id + "\", \"" + gender + "\", " + age + ", \"" + password + "\", \"" + address + "\");";
            System.out.println(sql);
            Statement stm;
            try {
                stm = connection.createStatement();
                stm.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
