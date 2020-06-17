package com.asterwyx.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String passwd = req.getParameter("password");
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        String[] hobbies = req.getParameterValues("hobby");
        StringBuilder hobby = new StringBuilder();
        for (String h : hobbies) {
            hobby.append(h).append(",");
        }
        hobby.deleteCharAt(hobby.length() - 1);
        String prompt = "用户名: " + userName + " 密码: " + passwd + " 性别: " + sex + " 爱好: " + hobby.toString() + " 地址: " + address;
        System.out.println(prompt);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
