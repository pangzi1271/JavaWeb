import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName, money;
        userName = request.getParameter("userName");
        money = request.getParameter("money");

        Cookie cardUserName = new Cookie("userName", userName);
        Cookie cardMoney = new Cookie("money", money);

        response.addCookie(cardUserName);
        response.addCookie(cardMoney);

        request.getRequestDispatcher("OrderFood.html").forward(request, response);

    }

}
