import java.sql.*;

public class ProvinceDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public String provinceInfo(Integer provinceId) {
        String name = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "1234");
            String sql = "select name, jiancheng, shenghui from province where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
                // jiancheng = rs.getString("jiancheng");
                // shenghui = rs.getString("shenghui");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return name;
    }
}
