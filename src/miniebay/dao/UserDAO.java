package miniebay.dao;

import java.util.List;

import miniebay.entity.User;

public interface UserDAO {

	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(String userName);

	public void deleteUser(String userName);

	public boolean isValidLogin(User theUser);
}
