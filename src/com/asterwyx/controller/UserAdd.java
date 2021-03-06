package com.asterwyx.controller;

import com.asterwyx.entity.StudentDAO;
import com.asterwyx.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        Student student = new Student(
                name,
                student_id,
                gender,
                Integer.parseInt(age),
                password,
                address
        );
        StudentDAO dao = new StudentDAO();
        int status = dao.insert(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // 在使用POST方法的时候，浏览器会使用html指定的编码（在meta中指定的编码）进行参数的编码，在这里需要设置相应的编码来解码
        String student_id = req.getParameter("student_id");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String gender = req.getParameter("gender");
        String address = req.getParameter("address");
        Student student = new Student(
                name,
                student_id,
                gender,
                Integer.parseInt(age),
                password,
                address
        );
        StudentDAO dao = new StudentDAO();
        int status = dao.insert(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }
}
