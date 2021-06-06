import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, money;

        //1. 调用请求对象读取“请求头”参数信息
        userName = request.getParameter("userName");
        money = request.getParameter("money");

        //2. 生成cookies用来存储一些需要共享的信息，可以暂存在浏览器中也可以存储在用户硬盘中
        Cookie cardUserName = new Cookie("userName", userName);
        Cookie cardMoney = new Cookie("money", money);

        //3. 将生成的cookies添加到响应头中返回给浏览器
        response.addCookie(cardUserName);
        response.addCookie(cardMoney);

        //4. 通知Tomcat将“点餐页面”内容写入到响应体交给浏览器(请求转发)
        //getRequestDispatcher(String s)这个方法为请求转发，将这个类中的参数转发给它带的参数，也就是转发给一个网页
        request.getRequestDispatcher("OrderFood.html").forward(request, response);
    }
}
