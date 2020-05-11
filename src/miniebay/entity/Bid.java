package miniebay.entity;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Entity
@Table(name="BID")
public class Bid {

	@EmbeddedId
	private BidId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@MapsId("userName")
	//@JoinColumn(name="USER_Username",referencedColumnName="Username", insertable = false,updatable = false)
	@JoinColumn(name="Username", insertable = false,updatable = false)
	private User bidUsername;
	
	@ManyToOne(fetch=FetchType.LAZY)
	//@MapsId("itemId")
	//@JoinColumn(name="ITEM_Item_ID",referencedColumnName="Item_ID", insertable = false,updatable = false)
	@JoinColumn(name="Item_ID", insertable = false,updatable = false)
	private Item bidItem;
	
	//@MapsId("bidTime")
	//private Timestamp bidTime;
	
	@Column(name="Bid_amount")
	private float bidAmount;
	
	@Column(name="Is_get_it_now")
	private boolean isGetItNow;
	
	@Column(name="Is_winner")
	private boolean isWinner;
	
	public Bid() {
		
	}

	public Bid(User bidUsername, Item bidItem, Timestamp bidTime) {
		this.bidUsername = bidUsername;
		this.bidItem = bidItem;
		this.id = new BidId(bidUsername.getUserName(), bidItem.getItemId(), bidTime);
	}

	public BidId getId() {
		return id;
	}

	public void setId(BidId id) {
		this.id = id;
	}

	public User getBidUsername() {
		return bidUsername;
	}

	public void setBidUsername(User bidUsername) {
		this.bidUsername = bidUsername;
	}

	public Item getBidItem() {
		return bidItem;
	}

	public void setBidItem(Item bidItem) {
		this.bidItem = bidItem;
	}
	/*
	public Timestamp getBidTime() {
		return bidTime;
	}

	public void setBidTime(Timestamp bidTime) {
		this.bidTime = bidTime;
	}
	*/
	public float getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(float bidAmount) {
		this.bidAmount = bidAmount;
	}

	public boolean isGetItNow() {
		return isGetItNow;
	}

	public void setGetItNow(boolean isGetItNow) {
		this.isGetItNow = isGetItNow;
	}

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	
    @Override
	public String toString() {
		return "Bid [id=" + id + ", bidUsername=" + bidUsername + ", bidItem=" + bidItem + ", bidAmount=" + bidAmount
				+ ", isGetItNow=" + isGetItNow + ", isWinner=" + isWinner + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        Bid that = (Bid) o;
        return Objects.equals(bidUsername, that.bidUsername) &&
               Objects.equals(bidItem, that.bidItem) &&
               Objects.equals(id.getBidTime(), that.id.getBidTime());
    }
 
    @Override
    public int hashCode() {
        //return Objects.hash(bidUsername, bidItem, id.getBidTime());
    	return Objects.hash(bidUsername, bidItem);
    }
	
	
}
