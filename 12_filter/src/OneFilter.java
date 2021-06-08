import jakarta.servlet.*;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //1. 调用请求对象获取请求参数中的值
        String age = servletRequest.getParameter("age");
        //2. 对值进行判断是否需要过滤
        if (Integer.valueOf(age) < 70) {
            // 程序运行到这一步说明符合过滤器的条件
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            //程序走到这一步，说明不不符合过滤器的条件
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter pw = servletResponse.getWriter();
            pw.print("<center><font style='color:red;font-size:45px'>大爷，珍惜生命，少看美女。</font></center>");
        }
    }
}
