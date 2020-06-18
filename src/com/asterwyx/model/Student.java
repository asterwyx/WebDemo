package com.asterwyx.model;

public class Student {
    private String name;
    private String studentId;
    private String gender;
    private int age;
    private String password;
    private String address;

    public Student() {
        this.name = "";
        this.studentId = "";
        this.gender = "";
        this.age = 0;
        this.password = "";
        this.address = "";
    }
    public Student(String name, String studentId, String gender, int age, String password, String address) {
        this.name = name;
        this.studentId = studentId;
        this.gender = gender;
        this.age = age;
        this.password = password;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", studentId='" + studentId + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
