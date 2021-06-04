import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private JdbcUtil util = new JdbcUtil();

    //用户注册
    public int add(Users user){
        String sql = "insert into users (userName,password,sex,email) values(?, ?, ?, ?)";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            util.close();
        }
        return result;
    }

    //查询所有用户信息
    public List<Users> findAll(){
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List<Users> userList = new ArrayList<>();

        try {
            rs = ps.executeQuery();
            while(rs.next()){
                Integer userID = rs.getInt("userID");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users users = new Users(userID, userName, password, sex, email);
                userList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close(rs);
        }
        return userList;
    }

    //根据userID删除用户信息
    public int deleteUser(String userID){

        String sql = "delete from users where userID = ?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;

        try {
            ps.setInt(1, Integer.parseInt(userID));
            result = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }

    //用户登录验证
    public int login(String userName, String password){
        int result = 0;
        String sql = "select count(*) from users where userName = ? and password = ?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;


        try {
            ps.setString(1, userName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while(rs.next()){
                result = rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            util.close();
        }
        return result;
    }
}
