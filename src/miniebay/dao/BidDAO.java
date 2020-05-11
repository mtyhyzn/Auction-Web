package miniebay.dao;

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

public interface BidDAO {

	public List<Bid> getBids(User theUser);

	public List<Bid> getBids(Item theItem);

	public void saveBid(@Valid Bid theBid);
}
