import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jdk.jshell.spi.ExecutionControl;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        PrintWriter out;

        List<Users> usersList = dao.findAll();
        response.setContentType("text/html;charset=utf-8");
        out = response.getWriter();
        out.print("<table border=1px align='center'>");
        out.print("<tr>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户电邮</td>");
        out.print("</tr>");



        for (Users users : usersList) {
            out.print("<tr>");
            out.print("<td>"+users.getUserName()+"</td>");
            out.print("<td>"+"******"+"</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }

}
