package util;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {

        Connection con= null;
        con = DBUtil.getConnection();

        if(con==null)
            System.out.println("连接失败");
        else
            System.out.println("连接成功");
    }
}
