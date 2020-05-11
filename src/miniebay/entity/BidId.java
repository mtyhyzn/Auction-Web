package miniebay.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Embeddable
public class BidId implements Serializable{
	
	@Column(name="Username",insertable = false,updatable = false)
	private String userName;
	
	@Column(name="Item_ID",insertable = false,updatable = false)
	private int itemId;
	
	@Column(name="Time_of_bid")
	private Timestamp bidTime;
	
	private BidId() {
		
	}

	public BidId(String userName, int itemId, Timestamp bidTime) {
		this.userName = userName;
		this.itemId = itemId;
		this.bidTime = bidTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public Timestamp getBidTime() {
		return bidTime;
	}

	public void setBidTime(Timestamp bidTime) {
		this.bidTime = bidTime;
	}
	
	
	@Override
	public String toString() {
		return "BidId [userName=" + userName + ", itemId=" + itemId + ", bidTime=" + bidTime + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        BidId that = (BidId) o;
        return Objects.equals(userName, that.userName) &&
               Objects.equals(itemId, that.itemId) &&
               Objects.equals(bidTime, that.bidTime);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(userName, itemId, bidTime);
    }
	
}
