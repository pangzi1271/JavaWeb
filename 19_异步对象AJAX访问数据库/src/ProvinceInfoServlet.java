import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ProvinceInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String provinceId = request.getParameter("provinceId");
        System.out.println(provinceId);

        String name = "查询数据不能为空，请重新输入。";

        if (provinceId != null && !"".equals(provinceId.trim())){
            ProvinceDao dao = new ProvinceDao();
            name = dao.provinceInfo(Integer.valueOf(provinceId));
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(name);
        pw.flush();
        pw.close();
    }

}
