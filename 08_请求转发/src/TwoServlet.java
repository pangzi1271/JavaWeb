import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("TwoServlet is running for frying chives.");
    }

}
