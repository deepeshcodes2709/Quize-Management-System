package quizmanagementsystem.dao;

import quizmanagementsystem.model.User;

public interface userDao extends AutoCloseable {

	public void Registration(String name, String email, String password) throws Exception;

public	User login(String email, String password) throws Exception;
}
