import java.sql.*;

public class JdbcUtil {
    PreparedStatement ps = null;
    Connection connection = null;
    static {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }


        // ResultSet rs = null;

    // public Connection getConnection() {
    //     try {
    //         connection = DriverManager.getConnection("http://localhost:3306/bjpowernode", "root", "1234");
    //     } catch (SQLException throwables) {
    //         throwables.printStackTrace();
    //     }
    //     return connection;
    // }

    public PreparedStatement createStatement(String sql){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "1234");
            ps = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }

    //释放资源（insert, update, delete）
    public void close(){
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //释放资源（select）
    public void close(ResultSet rs){
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        close();
    }
}
