import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("OneServlet is running for cleaning chives.");
        RequestDispatcher report = request.getRequestDispatcher("/two");
        report.forward(request, response);
    }

}
