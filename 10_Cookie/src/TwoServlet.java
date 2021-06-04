import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class TwoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int dumpling = 30;
        int meatBun = 20;
        int noodle = 15;
        int rice = 12;
        Cookie[] cookieArray = null;
        String userName;
        int money;

        String order = request.getParameter("food");

        cookieArray = request.getCookies();


        for (Cookie card:cookieArray){
            String key = card.getName();
            String value = card.getValue();
            if ("userName".equals(key)){
                userName = value;
            }else if("money".equals(key)){
                money = Integer.valueOf(value);
            }
        }
    }
}
