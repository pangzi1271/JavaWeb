import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getServletContext().setAttribute("key1", 100);
    }

}
