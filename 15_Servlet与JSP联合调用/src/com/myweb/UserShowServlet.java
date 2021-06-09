package com.myweb;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserShowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentAdd stu1 = new StudentAdd(100, "张三", "男", 23);
        StudentAdd stu2 = new StudentAdd(101, "李四", "男", 22);
        StudentAdd stu3 = new StudentAdd(103, "王五", "男", 24);

        List<StudentAdd> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);

        request.setAttribute("students", studentList);
        request.getRequestDispatcher("user_show.jsp").forward(request, response);
    }

}
