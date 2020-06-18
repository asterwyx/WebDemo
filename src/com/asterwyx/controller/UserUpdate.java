package com.asterwyx.controller;

import com.asterwyx.entity.StudentDAO;
import com.asterwyx.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserUpdate extends HttpServlet {
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
        int status = dao.update(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
        int status = dao.update(student);
        if (status != 0) {
            req.getRequestDispatcher("succeed.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("fail.html").forward(req, resp);
        }
    }
}
