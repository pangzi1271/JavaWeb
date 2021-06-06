import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 调用请求对象,获取用户的私人储物柜
        HttpSession session = request.getSession();

        //2. 调用请求对象,获取用户的所有物品,返回一个泛型为字符串类型的枚举对象
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        Enumeration<String> goodsNames = session.getAttributeNames();
        while (goodsNames.hasMoreElements()) {
            String goodsName = goodsNames.nextElement();
            int goodsCount = (int) session.getAttribute(goodsName);
            out.print("<font style='color:red;font-size=45px'>商品名称:" + goodsName + ", 商品数量: " + goodsCount + "件</font>");
            out.print("\n");
        }
    }

}
