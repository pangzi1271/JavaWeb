import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

    JdbcUtil util = new JdbcUtil();

    public Province provinceInfo(Integer provinceId) {
        String sql = "select name, jiancheng, shenghui from province where id = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        Province province = null;
        try {
            ps.setInt(1, provinceId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String shortName = rs.getString("jiancheng");
                String capitalName = rs.getString("shenghui");
                province = new Province(null, name, shortName, capitalName);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return province;
    }

    public int cityAdd(City city) {

        String sql = "insert into city (name, provinceid) values(?, ?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, city.getCityName());
            ps.setInt(2, city.getProvinceId());
            result = ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }
}
