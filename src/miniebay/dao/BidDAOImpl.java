package miniebay.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import miniebay.entity.Bid;
import miniebay.entity.Item;
import miniebay.entity.User;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Repository
public class BidDAOImpl implements BidDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Bid> getBids(User theUser) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		
		Query<Bid> theQuery = 
				currentSession.createQuery("from Bid where Username=:userId order by id", 
											Bid.class).setParameter("userId", theUser.getUserName());
		/*
		Query<Bid> theQuery = 
				currentSession.createQuery("from Bid",
											Bid.class);
		*/
		
		// execute query and get result list
		List<Bid> bids = theQuery.getResultList();
		
		System.out.println("Bid list" + bids);
		
		for (Bid bid : bids) {
			System.out.println("Single bid: " + bid.getBidItem().getItemName());
		}
		
		// return the results
		return bids;
	}

	@Override
	public List<Bid> getBids(Item theItem) {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		
		Query<Bid> theQuery = 
				currentSession.createQuery("from Bid where Item_ID=:itemId order by Time_of_bid", 
											Bid.class).setParameter("itemId", theItem.getItemId());
		/*
		Query<Bid> theQuery = 
				currentSession.createQuery("from Bid",
											Bid.class);
		*/
		
		// execute query and get result list
		List<Bid> bids = theQuery.getResultList();
		
		System.out.println("Bid list" + bids);
		
		for (Bid bid : bids) {
			System.out.println("Single bid: " + bid.getBidItem().getItemName());
		}
		
		// return the results
		return bids;
	}

	@Override
	public void saveBid(@Valid Bid theBid) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the item .. 
		currentSession.save(theBid);
		
	}

}