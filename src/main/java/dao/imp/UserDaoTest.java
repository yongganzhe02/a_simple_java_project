package dao.imp;

import bean.User;
import dao.UserDao;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;

import org.junit.runners.MethodSorters;
import util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDaoTest {
    UserDao userDao = new UserDaoImp();

    @Ignore
    @Test
    public void ATestUserDaoadd() throws SQLException {
        UserDao userDao = new UserDaoImp();
        Connection con = DBUtil.getConnection();
        User user = new User();
        user.setId("1");
        user.setName("赵子健");
        user.setSex(1);
        userDao.addUser(user, con);
    }

    @Ignore
    @Test
    public void BTestUserDaoSelectOne() throws SQLException {
        UserDao userDao = new UserDaoImp();
        Connection con = DBUtil.getConnection();
        User user = null;
        user = userDao.getUser("1", con);
        System.out.println(user);
    }

    @Ignore
    @Test
    public void CTestUserDaoDeleteOne() throws SQLException {
        UserDao userDao = new UserDaoImp();
        Connection con = DBUtil.getConnection();
        boolean flag = userDao.deleteUser("1", con);
        System.out.println(flag);
    }

    @Ignore
    @Test
    public void TestUserDaoModify() throws SQLException {
        UserDao userDao = new UserDaoImp();
        Connection con = DBUtil.getConnection();
        User user = new User();
        user.setId("1");
        user.setName("赵子健修改");
        user.setSex(0);
        userDao.updateUser(user, con);
    }

    @Ignore
    @Test
    public void TestUserDaoCount() throws SQLException {

        Connection con = DBUtil.getConnection();
        System.out.println(userDao.getAllUserNum(con));
    }

    @Ignore
    @Test
    public void TestUserDaoList() throws SQLException {
        Connection con = DBUtil.getConnection();
        List<User> list = new ArrayList<>();
        list=userDao.getAllUser(0,3,con);
        list.forEach(i -> System.out.println(i));
    }
}
