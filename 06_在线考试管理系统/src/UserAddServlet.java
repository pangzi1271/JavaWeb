import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userName, sex, email, password;
        UserDao dao = new UserDao();
        int result;
        //1. 调用请求对象，读取请求头中的参数信息，得到用户的注册信息
        userName = request.getParameter("userName");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");

        //2. 调用UserDao，将用户信息填充到SQL的insert命令，并借助JDBC规范发送到数据库服务器
        Users user = new Users(userName, password, sex, email);
        result = dao.add(user);
        //3. 调用响应对象，将处理结果以二进制的形式写入到响应体中
        PrintWriter out;
        out = response.getWriter();

        response.setContentType("text/html;charset=utf-8");
        if (result == 1) {
            out.print("<font style = 'color : red;font-size : 40'>用户信息注册成功！</font>");
        } else {
            out.print("<font style = 'color : red;font-size : 40'>用户信息注册失败！</font>");
        }
    }
    /*Tomcat负责销毁请求对象及响应对象
      Tomcat负责将HTTP响应协议包推送到发起请求的浏览器上
      浏览器根据响应头的content-type指定编译器对响应体二进制内容编辑
      浏览器将编辑后的结果在窗口中展示给用户
     */

}
