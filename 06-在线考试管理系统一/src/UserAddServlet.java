import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, password, sex, email;
        UserDao dao = new UserDao();
        int result;

        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        Users user = new Users(userName, password, sex, email);
        result = dao.add(user);
        PrintWriter out = response.getWriter();

        response.setContentType("text/html; charset=utf-8");

        if(result == 1) {
            out.print("<font style='color:red;font-size:45px'>用户注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:45px'>用户注册失败</font>");
        }
    }

}
