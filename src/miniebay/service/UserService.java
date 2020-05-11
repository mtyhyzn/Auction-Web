package miniebay.service;

import java.util.List;

import miniebay.entity.Item;
import miniebay.entity.User;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

public interface UserService {
	
	public List<User> getUsers();

	public void saveUser(User theUser);

	public User getUser(String userName);

	public void deleteUser(String userName);

	public List<Item> getItems(String userName);

	public Item getItem(int theId);
	
	public void deleteItem(int theId);

	public void saveItem(Item theItem);

	public List<Item> getAcutionItems(String userName);

	public List<Item> getOpenAcutionItems(String userName);

	public List<Item> getClosedAcutionItems(String userName);

	public boolean isValidLogin(User theUser);
}


