import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用请求对象,得到商品名称
        String goodsName = request.getParameter("goodsName");

        //2. 调用请求对象，向Tomcat索要当前用户在服务端的私人储物柜
        HttpSession session = request.getSession();

        //3. 将用户选购商品添加到当前用户私人储物柜,为避免空指针异常,使用Integer来定义
        Integer goodsCount = (Integer) session.getAttribute(goodsName);
        if (goodsCount == null) {
            session.setAttribute(goodsName, 1);
        }else {
            session.setAttribute(goodsName, goodsCount + 1);
        }
    }

}
