import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = request.getServletContext();

        // 由于getAttribute()方法返回是的Object类型，而为了避免空指针异常，应使用Integer初始化一个变量来接收用Integer强转的数据
        Integer money = (Integer) application.getAttribute("key1");
        System.out.println("金额是：" + money);
    }

}
