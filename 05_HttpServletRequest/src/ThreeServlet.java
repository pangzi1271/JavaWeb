import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

public class ThreeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // request.setCharacterEncoding("GBK");
        // 通过请求对象，来获取“请求头”中的信息
        String userName = request.getParameter("userName");
        System.out.println("从请求体得到的参数值：" + userName);

        }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("GBK");
        // 通过请求对象，来获取“请求体”中的信息
        String userName = req.getParameter("userName");
        System.out.println("从请求头得到的参数值：" + userName);
    }
}
