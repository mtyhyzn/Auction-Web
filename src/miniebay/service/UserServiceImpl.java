package miniebay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miniebay.dao.ItemDAO;
import miniebay.dao.UserDAO;
import miniebay.entity.Item;
import miniebay.entity.User;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Service
public class UserServiceImpl implements UserService {

	// need to inject user dao
	@Autowired
	private UserDAO userDAO;
	
	// need to inject item dao
	@Autowired
	private ItemDAO itemDAO;
	
	@Override
	@Transactional
	public List<User> getUsers() {

		return userDAO.getUsers();
	}


	@Override
	@Transactional
	public void saveUser(User theUser) {
		
		userDAO.saveUser(theUser);
		
	}


	@Override
	@Transactional
	public User getUser(String userName) {
		
		return userDAO.getUser(userName);
	}


	@Override
	@Transactional
	public void deleteUser(String userName) {
		
		userDAO.deleteUser(userName);
		
	}


	@Override
	@Transactional
	public List<Item> getItems(String userName) {

		return itemDAO.getItems(userName);
	}


	@Override
	@Transactional
	public Item getItem(int theId) {
		
		return itemDAO.getItem(theId);
	}


	@Override
	@Transactional
	public void deleteItem(int theId) {
		
		itemDAO.deleteItem(theId);
		
	}


	@Override
	@Transactional
	public void saveItem(Item theItem) {
		
		itemDAO.saveItem(theItem);
		
	}


	@Override
	@Transactional
	public List<Item> getAcutionItems(String userName) {
		
		return itemDAO.getAuctionItems(userName);
	}


	@Override
	@Transactional
	public List<Item> getOpenAcutionItems(String userName) {
		
		return itemDAO.getOpenAuctionItems(userName);
	}


	@Override
	@Transactional
	public List<Item> getClosedAcutionItems(String userName) {
		
		return itemDAO.getClosedAuctionItems(userName);
	}


	@Override
	@Transactional
	public boolean isValidLogin(User theUser) {
		
		return userDAO.isValidLogin(theUser);
	}

}
