package dao;

import bean.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
	//增
	boolean addUser(User user, Connection con) throws SQLException;
	//查一个
	User getUser(String studentId,Connection con) throws SQLException;
	//删
	boolean deleteUser(String id , Connection con) throws SQLException;
	//改
	boolean updateUser(User user, Connection con) throws SQLException;

	//查全部
	int getAllUserNum(Connection con) throws SQLException;//查询数据库一共数据有多少条
	List<User> getAllUser(int rowNum,int pageSize,Connection con) throws SQLException;

}
