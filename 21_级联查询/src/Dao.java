import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dao {

    JdbcUtil util = new JdbcUtil();
    ResultSet rs = null;
    public Province provinceInfo(Integer provinceId) {
        String sql = "select name, jiancheng, shenghui from province where id = ?";
        PreparedStatement ps = util.createStatement(sql);

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

    public List<Province> provinceQuery() {
        String sql = "select id, name, jiancheng, shenghui from province order by id";
        PreparedStatement ps = util.createStatement(sql);
        List<Province> provinces = new ArrayList<>();
        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Province province = new Province();
                province.setProvinceId(rs.getInt("id"));
                province.setProvinceName(rs.getString("name"));
                province.setProvinceShortName(rs.getString("jiancheng"));
                province.setCapital(rs.getString("shenghui"));
                provinces.add(province);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return provinces;
    }

    public List<City> cityInfo(Integer provinceId) {
        String sql = "select name from city where provinceId = ?";
        PreparedStatement ps = util.createStatement(sql);
        List<City> cityList = new ArrayList<>();
        try {
            ps.setInt(1,provinceId);
          rs =  ps.executeQuery();
          while (rs.next()){
              City city = new City();
              city.setCityName(rs.getString("name"));
//              city.set(rs.getInt("id"));
              cityList.add(city);
          }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            util.close(rs);
        }
        return cityList;
    }
}
