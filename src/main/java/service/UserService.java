package service;

import bean.User;
import java.util.List;


public interface UserService {

	//增
	boolean addUser(User user);

	//查一个
	User getUser(String id);

	//删
	boolean deleteUser(String id);

	//改
	boolean updateUser(User user);

	//查全部
	int getAllUserNum();//查询数据库一共数据有多少条
	List<User> getAllUser(int pageNo,int pageSize);

}
