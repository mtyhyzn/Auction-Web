package miniebay.service;

import java.util.List;

import javax.validation.Valid;

import miniebay.entity.Bid;
import miniebay.entity.Item;
import miniebay.entity.User;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

public interface BidService {
	
	public List<Bid> getBids(User theUser);

	public List<Bid> getBids(Item theItem);

	public void saveBid(@Valid Bid theBid);

	//public void saveBid(Bid theBid);

	//public Bid getBid(BidId bidId);

}


