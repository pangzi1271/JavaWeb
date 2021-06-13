import jakarta.servlet.*;
import jakarta.servlet.http.*;
import net.sf.json.JSONObject;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Dept dept = new Dept(10, "工程部", "北京");
        JSONObject jsonObject = JSONObject.fromObject(dept);
        request.setAttribute("key", jsonObject.toString());
        request.getRequestDispatcher("index_1.jsp").forward(request, response);
    }

}
