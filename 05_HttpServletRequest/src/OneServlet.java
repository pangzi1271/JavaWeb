import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 通过请求对象req，读取请求行中的url信息
        String url = req.getRequestURL().toString();
        //2. 通过请求对象req，读取请求行中的method信息
        String method = req.getMethod();

        //3. 通过请求对象req，读取请求行中的uri信息，URI是指资源文件精准定位地址
        // 在请求行中并没有URI这个属性，实际上是从URL中截取的一段字符串，这个字符串的格式是"/网站名/资源文件名"
        // URI的作用是让HTTP服务器对被访问的文件进行定位
        String uri = req.getRequestURI();

        System.out.println("URL = " + url);
        System.out.println("URI = " + uri);
        System.out.println("METHOD = " + method);
    }
}
