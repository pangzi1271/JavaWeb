import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");

        float bmi = Float.parseFloat(weight) / (Float.parseFloat(height) * Float.parseFloat(height));

        String msg = "";
        if (bmi <= 18.5) {
            msg = "你的体型偏瘦。";
        }else if (bmi > 18.5 && bmi <= 24) {
            msg = "你的体型正常！";
        }else if (bmi > 24 && bmi <= 30) {
            msg = "你的体型偏胖！";
        }else {
            msg = "你的体型过于肥胖！";
        }

        msg = name + "先生/女士，你好。你的BMI是" + bmi + "，" + msg;

        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(msg);
        pw.flush();
        pw.close();
    }
}
