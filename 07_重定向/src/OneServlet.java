import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {

    //重定向演示
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet 负责洗韭菜！");
        // 使用sendRedirect()方法重定向到/myWeb/two这个资源文件
        response.sendRedirect("/myWeb/two");
    }
}
