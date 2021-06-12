import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = new Student(100, "Mike");
        // String student ="{\"stuId\":100, \"stuName\":\"Mike\"}";

        String str = ReflectUtil.jsonObj(student);
        request.setAttribute("key", str);
        request.getRequestDispatcher("/index_1.jsp").forward(request, response);
    }
}
