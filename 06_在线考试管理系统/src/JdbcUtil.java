import java.sql.*;

/**
 *  将JDBC规范下相关对象【创建】与【销毁功能】封装到方法
 *
 *   一。JDBC开发步骤：
 *      1.注册数据库服务器提供的Driver接口实现类
 *      2.创建一个连接通道交给Connection接口的实例对象【JDBC4Connection】管理
 *      3.创建一个交通工具交给PreparedStatement接口的实例对象【JDBC4PreparedStatement】管理
 *      4.由交通工具在Java工程与数据库服务器之间进行传输，推送SQL命令并带回执行结果
 *      5.交易结束后，销毁相关资源【Connection,PreparedStatement,ResultSet】
 */
public class JdbcUtil {

    private  Connection conn = null;//类文件属性，可以在类文件中所有的方法中使用
    private  PreparedStatement ps=null;//类文件属性，可以在类文件中所有的方法中使用

    //静态语句块 static{}
    //在当前类文件第一次被加载到JVM时，JVM将会自动调用当前类文件静态语句块
    static{
        //1.注册数据库服务器提供的Driver接口实现类

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Driver接口实现类已成功注册。");
    }

    //封装Connection对象创建细节 不需要考虑使用对象创建细节
    public  Connection  createCon(){
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode",
                    "root", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection对象创建失败。。。。。");
        }
        return conn;
    }

    //封装PreparedStatement对象创建细节
    public PreparedStatement createStatement(String sql){

        Connection conn = createCon();
        try {
            ps = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

    //封装PreparedStatement对象与Connection对象销毁细节
    public void close(){
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //封装PreparedStatement对象与Connection对象与ResultSet对象销毁细节
    public void close(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close();
    }
}
