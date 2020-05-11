package miniebay.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import miniebay.dao.BidDAO;
import miniebay.entity.Bid;
import miniebay.entity.Item;
import miniebay.entity.User;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Service
public class BidServiceImpl implements BidService {

	// need to inject bid dao
	@Autowired
	private BidDAO bidDAO;
	
	@Override
	@Transactional
	public List<Bid> getBids(User theUser) {
		
		return bidDAO.getBids(theUser);
	}

	@Override
	@Transactional
	public List<Bid> getBids(Item theItem) {
		
		return bidDAO.getBids(theItem);
	}

	@Override
	@Transactional
	public void saveBid(@Valid Bid theBid) {
		
		bidDAO.saveBid(theBid);
		
	}


}
