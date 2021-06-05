import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    JdbcUtil util = new JdbcUtil();

    public int add(Users user){
        String sql = "insert into users(userName, password, sex, email) values(?, ?, ?, ?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3,user.getSex());
            ps.setString(4,user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;

    }
}
