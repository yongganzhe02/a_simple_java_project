package util;


import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static {
// System.out.println(System.getProperty("user.dir"));//获取项目路径
// System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));//获取classpath的路径!
        ResourceBundle rb = ResourceBundle.getBundle("db");

        driverClass = rb.getString("driverClass");
        url = rb.getString("url");
        username = rb.getString("username");
        password = rb.getString("password");

        //1.加载并注册驱动
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //2.获取数据库的连接
    public static Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }


    //3.关闭数据库连接
    public static void close( Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement pst) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}