import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ProvinceQueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //默认值， {} ：表示json格式的数据
        String json = "{}";

        //从浏览器获取请求参数
        Dao provinces = new Dao();
        List<Province> provinceList = provinces.provinceQuery();

        //判断provinceId是否有值，
        if (provinceList != null ){
           //需要使用jackson把Province对象转为json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(provinceList);
        }

        //将数据返回给浏览器
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(json);
        pw.flush();
        pw.close();
    }

}
