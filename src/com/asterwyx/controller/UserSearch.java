package com.asterwyx.controller;

import com.asterwyx.entity.StudentDAO;
import com.asterwyx.model.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserSearch extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String student_id = req.getParameter("student_id");
        StudentDAO dao = new StudentDAO();
        if (student_id.equals("*")) {
            List<Student> students = dao.selectAll();
            System.out.println(students);
        } else {
            Student student = new Student();
            student.setStudentId(student_id);
            boolean find = dao.selectByPriKey(student);
            if (find) {
                System.out.println(student);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String student_id = req.getParameter("student_id");
        StudentDAO dao = new StudentDAO();
        if (student_id.equals("*")) {
            List<Student> students = dao.selectAll();
            System.out.println(students);
        } else {
            Student student = new Student();
            student.setStudentId(student_id);
            boolean find = dao.selectByPriKey(student);
            if (find) {
                System.out.println(student);
            }
        }
    }
}
