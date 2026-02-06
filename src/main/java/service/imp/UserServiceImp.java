package service.imp;

import bean.User;
import dao.UserDao;
import dao.imp.UserDaoImp;
import service.UserService;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImp implements UserService {

    //增
    @Override
    public boolean addUser(User user) {
        boolean b = false;
        UserDao userDao = new UserDaoImp();
        try (Connection con = DBUtil.getConnection();) {
            b = userDao.addUser(user, con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //删
    @Override
    public boolean deleteUser(String id) {
        boolean b = false;
        UserDao userDao = new UserDaoImp();
        try (Connection con = DBUtil.getConnection();) {
            b = userDao.deleteUser(id, con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //查一个
    @Override
    public User getUser(String id) {

        User user = null;
        UserDao userDao = new UserDaoImp();
        try (Connection con = DBUtil.getConnection();) {
            user = userDao.getUser(id, con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //查全部
    @Override
    public int getAllUserNum() {
        int number = 0;
        UserDao userDao = new UserDaoImp();
        try (Connection con = DBUtil.getConnection();) {
            number = userDao.getAllUserNum(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public List<User> getAllUser(int pageNo, int pageSize) {
        List<User> users = null;
        UserDao userDao = new UserDaoImp();
        try (Connection con = DBUtil.getConnection();) {
            int rowNum = (pageNo - 1) * pageSize;
            users = userDao.getAllUser(rowNum, pageSize, con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    //改
    @Override
    public boolean updateUser(User user) {
        boolean b = false;
        UserDao userDao = new UserDaoImp();
        Connection con = null;
        try {
            con = DBUtil.getConnection();
            con.setAutoCommit(false);
            b = userDao.updateUser(user, con);
            con.commit();

        } catch (Exception e) {
            if (con != null) {
                try {
                    con.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            DBUtil.close(con);
            return b;
        }
    }
}

