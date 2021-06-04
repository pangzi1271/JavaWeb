import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Enumeration;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 通过请求对象获得请求头中的所有请求参数名
        Enumeration paraNames = request.getParameterNames(); //返回一个枚举对象
        while(paraNames.hasMoreElements()){
            String paraName = (String) paraNames.nextElement();
            // 2. 通过请求对象读取指定的请求参数的值
            String value = request.getParameter(paraName);
            System.out.println("请求参数名：" + paraName + "，请求对数值：" + value);
        }
    }

}
