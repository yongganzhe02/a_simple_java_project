package dao.imp;

import bean.User;
import dao.UserDao;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImp implements UserDao {

    //增
    @Override
    public boolean addUser(User user, Connection con) throws SQLException {
        boolean b = true;
        //第一次插入BLOB空值
        String sql1 = "insert into TEST_TABLE (ID,XM,XB) values(?,?,?) ";
        try (PreparedStatement ps = con.prepareStatement(sql1);) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setInt(3, user.getSex());
            int num = ps.executeUpdate();//返回受影响行数1
            if (num > 0) {
                System.out.println(num);
                b = true;
            }
            return b;
        }
    }

    //查一个
    @Override
    public User getUser(String id, Connection con) throws SQLException {
        User user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement("select * from TEST_TABLE where id=? ");
            pst.setString(1, id);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getString(1));
                user.setName(rs.getString(2));
                user.setSex(rs.getInt(3));
            }
            return user;
        } finally {
            DBUtil.close(rs, pst);
        }


    }

    //删
    @Override
    public boolean deleteUser(String id, Connection con) throws SQLException {
        boolean b = false;
        try (PreparedStatement ps = con.prepareStatement("delete from TEST_TABLE where id ='" + id + "'");) {
            int num = ps.executeUpdate();
            if (num > 0) {
                System.out.println(num);
                b = true;
            }
            return b;
        }
    }

    //改
    @Override
    public boolean updateUser(User user, Connection con) throws SQLException {
        boolean b = false;
        //更新数据
        String sql = "update TEST_TABLE set XM=?,XB=? where id = ? ";
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, user.getName());
            ps.setInt(2, user.getSex());
            ps.setString(3, user.getId());
            int num = ps.executeUpdate();
            if (num > 0) {
                b = true;
            }
            return b;
        }
    }

    //查全部
    @Override
    public int getAllUserNum(Connection con) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            int number = 0;
            pst = con.prepareStatement("select count(*) from TEST_TABLE ");
            rs = pst.executeQuery();
            if (rs.next())
                number = rs.getInt(1);
            return number;
        } finally {
            DBUtil.close(rs, pst);
        }
    }

    @Override
    public List<User> getAllUser(int rowNum, int pageSize, Connection con) throws SQLException {

        List<User> userList = new ArrayList<>();
        User user = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement("select * from TEST_TABLE limit ?, ?;");//(pageNo-1)*pageSize
            pst.setInt(1, rowNum);
            pst.setInt(2, pageSize);
            rs = pst.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getString("ID"));
                user.setName(rs.getString("XM"));
                user.setSex(rs.getInt("XB"));
                userList.add(user);
            }
            return userList;
        } finally {
            DBUtil.close(rs, pst);
        }
    }
}







