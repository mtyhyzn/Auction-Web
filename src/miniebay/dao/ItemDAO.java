package miniebay.dao;

import java.util.List;

import miniebay.entity.Item;

public interface ItemDAO {

	public List<Item> getItems(String userName);

	public Item getItem(int theId);

	public void deleteItem(int theId);

	public void saveItem(Item theItem);

	public List<Item> getAuctionItems(String userName);

	public List<Item> getOpenAuctionItems(String userName);

	public List<Item> getClosedAuctionItems(String userName);
}
