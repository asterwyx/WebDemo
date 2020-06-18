package com.asterwyx.entity;

import com.asterwyx.model.Student;
import com.asterwyx.utils.DBUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DBUtil implements DAO<Student> {

    public static String tableName = "student_info";

    @Override
    public int insert(Student toIns) {
        String sql = "INSERT INTO " + tableName + " VALUES (?, ?, ?, ?, ?, ?);";
        Object[] params = {
                toIns.getName(),
                toIns.getStudentId(),
                toIns.getGender(),
                toIns.getAge(),
                toIns.getPassword(),
                toIns.getAddress()
        };
        return this.doUpdate(sql, params);
    }

    @Override
    public int update(Student toUpd) {
        String sql = "UPDATE " + tableName + " SET name=?, gender=?, age=?, address=?, password=? WHERE student_id=?;";
        Object[] params = {
                toUpd.getName(),
                toUpd.getGender(),
                toUpd.getAge(),
                toUpd.getPassword(),
                toUpd.getAddress(),
                toUpd.getStudentId()
        };

        return this.doUpdate(sql, params);
    }

    @Override
    public int delete(Student toDel) {
        String sql = "DELETE FROM " + tableName +" WHERE student_id=?;";
        Object[] params = {
                toDel.getStudentId()
        };
        return this.doUpdate(sql, params);
    }

    @Override
    public List<Student> selectAll() {
        List<Student> result = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + ";";
        ResultSet rs = this.doQuery(sql, null);
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                System.err.println("迭代结果集出错!");
                throwables.printStackTrace();
            }
            Student stu = null;
            try {
                stu = new Student(
                        rs.getString("name"),
                        rs.getString("student_id"),
                        rs.getString("gender"),
                        rs.getInt("age"),
                        rs.getString("password"),
                        rs.getString("address")
                );
            } catch (SQLException throwables) {
                System.err.println("获取学生失败!");
                throwables.printStackTrace();
            }
            result.add(stu);
        }
        this.closeAll();
        return result;
    }

    @Override
    public boolean selectByPriKey(Student toSrh) {
        String sql = "SELECT * FROM " + tableName +" WHERE student_id=?;";
        Object[] params = {
                toSrh.getStudentId()
        };
        ResultSet rs = this.doQuery(sql, params);
        try {
            if (rs.next()) {
                toSrh.setName(rs.getString("name"));
                toSrh.setGender(rs.getString("gender"));
                toSrh.setAge(rs.getInt("age"));
                toSrh.setPassword(rs.getString("password"));
                toSrh.setAddress(rs.getString("address"));
                return true;
            }
        } catch (SQLException throwables) {
            System.err.println("查询学生失败!");
            throwables.printStackTrace();
        }
        return false;
    }
}
