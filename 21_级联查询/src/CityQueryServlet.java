import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CityQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String json = "{}";

        Dao cityDao = new Dao();
        String provinceId = request.getParameter("provinceId");
        List<City> cityList = cityDao.cityInfo(Integer.valueOf(provinceId));

        if (cityList != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(cityList);
        }

        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
