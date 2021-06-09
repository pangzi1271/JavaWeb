<%@ page import="com.myweb.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/9
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int stuId, stuAge;
    String stuName, stuGender;
    Student stu1 = new Student(100, "张三", "男", 23);
    stuId = stu1.getStuId();
    stuName = stu1.getStuName();
    stuGender = stu1.getStuGender();
    stuAge = stu1.getStuAge();
%>

<table border="2" align="center">
    <tr align="center">
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>学生性别</td>
        <td>学生年龄</td>
    </tr>
    <tr align="center">
        <td><%=stuId%></td>
        <td><%=stuName%></td>
        <td><%=stuGender%></td>
        <td><%=stuAge%></td>
    </tr>
</table>
