<%@ page import="java.util.List" %>
<%@ page import="com.myweb.StudentAdd" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/6/9
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<StudentAdd> studentList = (List) request.getAttribute("students");
%>
<table align="center" border="2">
    <tr align="center">
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>学生性别</td>
        <td>学生年龄</td>
    </tr>

        <%
            for (StudentAdd student: studentList){
        %>
    <tr align="center">
        <td><%=student.getStuId()%></td>
        <td><%=student.getStuName()%></td>
        <td><%=student.getStuGender()%></td>
        <td><%=student.getStuAge()%></td>
    </tr>
    <%
        }
    %>


</table>


