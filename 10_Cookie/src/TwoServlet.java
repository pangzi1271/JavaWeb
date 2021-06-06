import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dumpling = 30;
        int meatBun = 20;
        int noodle = 15;
        int rice = 12;
        Cookie[] cookieArray = null;
        String userName = null;
        int money = 0;
        PrintWriter out = null;
        out = response.getWriter();

        //1. 读取请求头的信息，获取用户点餐信息
        String order = request.getParameter("food");

        //2. 获取cookie中的信息
        cookieArray = request.getCookies();

        //配置向网面输出的字符类型及字符编码
        response.setContentType("text/html;charset=utf-8");

        for (Cookie card:cookieArray){
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)){
                //获取用户名
                userName = value;
            }else if("money".equals(key)){
                //获取当前用户的金额
                money = Integer.valueOf(value);
                if ("饺子".equals(order)){
                    if(money < dumpling) {
                        out.print("<font style='color:red;font-size:25px'>您的余额不足，请充值。</font>");
                    }else {
                        out.print("<font>用户：" + userName + "点餐：" + order + "消费：" + dumpling + "</font>");
                    }
                }
                if ("包子".equals(order)){
                    if(money < meatBun) {
                        out.print("<font style='color:red;font-size:25px'>您的余额不足，请充值。</font>");
                    }else {
                        out.print("<font>用户：" + userName + "点餐：" + order + "消费：" + meatBun + "</font>");
                    }
                }
                if ("牛肉面".equals(order)){
                    if(money < noodle) {
                        out.print("<font style='color:red;font-size:25px'>您的余额不足，请充值。</font>");
                    }else {
                        out.print("<font>用户：" + userName + "点餐：" + order + "消费：" + noodle + "</font>");
                    }
                }
                if ("盖饭".equals(order)){
                    if(money < rice) {
                        out.print("<font style='color:red;font-size:25px'>您的余额不足，请充值。</font>");
                    }else {
                        out.print("<font>用户：" + userName + "，点餐：" + order + "，消费：" + rice + "元</font>");
                    }
                }
            }
        }
    }
}
