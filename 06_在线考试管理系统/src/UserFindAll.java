import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserFindAll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName, password, sex, email;
        UserDao dao = new UserDao();
        List<Users> usersList = new ArrayList<>();
        PrintWriter out;

        //1. 调用DAO将查询命令推送到数据库服务器上，得到所有用户信息List
        usersList = dao.findAll();
        resp.setContentType("text/html;charset=utf-8");
        out = resp.getWriter();

        //输出表格的表头
        out.print("<table border=1px align=center>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户姓名</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户电邮</td>");
        out.print("</tr>");

        //表格数据
        for (Users users: usersList){
            out.print("<tr>");
            out.print("<td>"+users.getUserID() +"</td>");
            out.print("<td>"+users.getUserName() +"</td>");
            out.print("<td>"+ "******" +"</td>");
            out.print("<td>"+users.getSex() +"</td>");
            out.print("<td>"+users.getEmail() +"</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
