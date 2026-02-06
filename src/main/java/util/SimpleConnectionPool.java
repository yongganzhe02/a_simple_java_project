package util;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 数据库连接池
 * 初始化一个数据库连接池并向里面添加10个数据库连接
 * 从连接池中获取连接
 * 当程序用完连接后，需要将该连接重新放入到连接池中
 */
public class SimpleConnectionPool {

    //频繁对数据库连接池取出和放回，需要保证线程安全
    //静态属性，按照顺序比静态代码块先执行，建立池子
    private static LinkedList<Connection> pool = new LinkedList<Connection>();
    //静态代码块：在类加载后就向数据库连接池中添加10个数据库连接对象
    static {
        for (int i = 0; i < 10; i++) {
            Connection connection = DBUtil.getConnection();
            pool.add(connection);
            System.out.println("DB+1");
        }
    }

    //返回一个Connection
    public static Connection getConnectionFromPool() {
        Connection con = null;

        //判断数据库连接池中是否还有数据库连接对象
        if(pool.size()>0){
            con=pool.removeFirst();
        }else{
            throw new RuntimeException("服务器忙，请稍后再试");
        }
        return con;
    }
//用完放回
    public static void release(Connection con){
        pool.addLast(con);
        System.out.println("DB-1");
    }
}




