package miniebay.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miniebay.entity.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<User> theQuery = 
				currentSession.createQuery("from User order by lastName", 
											User.class);
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		
		// return the results
		return users;
	}

	@Override
	public void saveUser(User theUser) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the user .. 
		// or update if )primaryKey/id) is NOT empty
		currentSession.saveOrUpdate(theUser);

	}

	@Override
	public User getUser(String userName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, userName);
		
		return theUser;
	}

	@Override
	public void deleteUser(String userName) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		User theUser = currentSession.get(User.class, userName);
		
		// delete user
		currentSession.delete(theUser);
		
		// here is an alternative way to delete
		/*
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from User where id=:userId");
		theQuery.setParameter("userId", userName);
		
		theQuery.executeUpdate();
		
		*/

	}

	@Override
	public boolean isValidLogin(User theUser) {
		
		boolean isValid = false;
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<User> theQuery = 
				currentSession.createQuery("from User order by lastName", 
											User.class);
		
		// execute query and get result list
		List<User> users = theQuery.getResultList();
		
		for (User user : users) {
			if (user.getUserName().equals(theUser.getUserName()) && 
				user.getPassword().equals(theUser.getPassword())) {
				isValid = true;
			}
		}
		
		return isValid;
	}

}
