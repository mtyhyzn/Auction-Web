package miniebay.dao;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miniebay.entity.Item;


@Repository
public class ItemDAOImpl implements ItemDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems(String userName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Item> theQuery = 
				currentSession.createQuery("from Item where Owner_Username=:userId order by itemId", 
											Item.class).setParameter("userId", userName);
		//Query theQuery = 
				//currentSession.createQuery("select * from Item where Owner_Username=:userId order by itemName"); 
		//theQuery.setParameter("userId", userName);
		
		//theQuery.executeUpdate();
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
		
		// return the results
		return items;
	}

	@Override
	public Item getItem(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Item theItem = currentSession.get(Item.class, theId);
		
		return theItem;
	}

	@Override
	public void deleteItem(int theId) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Item theItem = currentSession.get(Item.class, theId);
		
		// delete item
		currentSession.delete(theItem);
		
	}

	@Override
	public void saveItem(Item theItem) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the item .. 
		currentSession.save(theItem);
		
	}

	@Override
	public List<Item> getAuctionItems(String userName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by item id
		Query<Item> theQuery = 
				currentSession.createQuery("from Item where Owner_Username!=:userId order by itemId", 
											Item.class).setParameter("userId", userName);
		//Query theQuery = 
				//currentSession.createQuery("select * from Item where Owner_Username=:userId order by itemName"); 
		//theQuery.setParameter("userId", userName);
		
		//theQuery.executeUpdate();
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
		
		// return the results
		return items;
	}

	@Override
	public List<Item> getOpenAuctionItems(String userName) {
		
		LocalDateTime localTime = LocalDateTime.now();
		Timestamp dateTime = Timestamp.valueOf(localTime);
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by item id
		Query<Item> theQuery = 
				currentSession.createQuery("from Item where Owner_Username!=:userId and Auction_ends_time >:limit order by itemId", 
											Item.class).setParameter("userId", userName).setParameter("limit", dateTime);
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
		
		// return the results
		return items;
	}

	@Override
	public List<Item> getClosedAuctionItems(String userName) {
		
		LocalDateTime localTime = LocalDateTime.now();
		Timestamp dateTime = Timestamp.valueOf(localTime);
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by item id
		Query<Item> theQuery = 
				currentSession.createQuery("from Item where Owner_Username!=:userId and Auction_ends_time <:limit order by itemId", 
											Item.class).setParameter("userId", userName).setParameter("limit", dateTime);
		
		// execute query and get result list
		List<Item> items = theQuery.getResultList();
		
		// return the results
		return items;
	}

}
