package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作工具类
 */
public class DBUtil {
    private static final String driver = "com.mysql.cj.jdbc.Driver"; //数据库驱动
    //连接数据库的URL地址
    private static final String url = "jdbc:mysql://127.0.0.1:3306/server?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    private static final String username = "root";//数据库的用户名
    private static final String password = "root";//数据库的密码
    
    static Statement ps=null;
    static ResultSet rs=null;
	   static Connection conn = null;

    //静态代码块负责加载驱动
   

    //单例模式返回数据库连接对象
    public static Connection getConnection() throws Exception {
    	try {
            Class.forName(driver);
            System.out.println("驱动加载成功");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("驱动加载失败");
        }
        if (conn == null) {
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn;
    }

    public static void close(ResultSet rs,Statement st, Connection conn) {
        try {
            if (conn != null)
                conn.close();
            if (st != null)
                st.close();
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static boolean executeSql(String sql) {
        Connection conn = null;
        try {
            conn = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Statement st = null;
        try {
            st = conn.createStatement();
            return st.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(null,st, conn);
        }
        return false;
    }
   

}
