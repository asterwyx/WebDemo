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

public class UserDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student();
        StudentDAO dao = new StudentDAO();
        String student_id = req.getParameter("student_id");
        student.setStudentId(student_id);
        int status = dao.delete(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Student student = new Student();
        StudentDAO dao = new StudentDAO();
        String student_id = req.getParameter("student_id");
        student.setStudentId(student_id);
        int status = dao.delete(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }
}
