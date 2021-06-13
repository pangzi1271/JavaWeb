import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html;charset=utf-8");

        //计算BMI
        float bmi = Integer.parseInt(weight) / (Integer.parseInt(height) * Integer.parseInt(height));

        //判断体重特征
        if (bmi <= 18.5) {
            pw.print(name + "先生/女士，您的体型偏瘦！");
        }else if (bmi > 18.5 && bmi <= 24) {
            pw.print(name + "先生/女士，您的体型正常，请注意保持！");
        }else if (bmi >24 && bmi <=27) {
            pw.print(name + "先生/女士，您的体型偏胖，请注意饮食！");
        }else {
            pw.print(name + "先生/女士，您的体型肥胖，请加强锻炼！");
        }
        pw.flush();
        pw.close();
    }
}
