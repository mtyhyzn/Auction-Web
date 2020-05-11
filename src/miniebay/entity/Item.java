package miniebay.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Item_ID")
	private int itemId;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="Owner_Username")
	private User ownerUsername;
	
	@Column(name="Item_name")
	@NotNull(message="cannot be null")
	@Size(min=1, message="is required")
	private String itemName;
	
	@Column(name="Description")
	@NotNull(message="cannot be null")
	@Size(min=1, message="is required")
	private String description;
	
	@Column(name="Item_condition")
	@NotNull(message="cannot be null")
	@Min(value=1, message="must be greater than or equal to 1")
	@Max(value=5, message="must be less than or equal to 5")
	private Integer condition;
	
	@Column(name="Start_biding_price")
	private float startBidingPrice;
	
	@Column(name="Min_sale_price")
	private float minSalePrice;
	
	@Column(name="Get_it_now_price")
	private float getItNowPrice;
	
	@Column(name="Auction_ends_time")
	private Timestamp auctionEndsTime;
	
	@Column(name="Returnable")
	private boolean returnable;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="Name")
	private Category name;
	
	@OneToMany(mappedBy="bidItem", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Bid> bids;
	
	public Item() {

	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public User getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(User ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public float getStartBidingPrice() {
		return startBidingPrice;
	}

	public void setStartBidingPrice(float startBidingPrice) {
		this.startBidingPrice = startBidingPrice;
	}

	public float getMinSalePrice() {
		return minSalePrice;
	}

	public void setMinSalePrice(float minSalePrice) {
		this.minSalePrice = minSalePrice;
	}

	public float getGetItNowPrice() {
		return getItNowPrice;
	}

	public void setGetItNowPrice(float getItNowPrice) {
		this.getItNowPrice = getItNowPrice;
	}

	public Timestamp getAuctionEndsTime() {
		return auctionEndsTime;
	}

	public void setAuctionEndsTime(Timestamp auctionEndsTime) {
		this.auctionEndsTime = auctionEndsTime;
	}

	public boolean isReturnable() {
		return returnable;
	}

	public void setReturnable(boolean returnable) {
		this.returnable = returnable;
	}

	public Category getName() {
		return name;
	}

	public void setName(Category name) {
		this.name = name;
	}
	

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", ownerUsername=" + ownerUsername + ", itemName=" + itemName
				+ ", description=" + description + ", condition=" + condition + ", startBidingPrice=" + startBidingPrice
				+ ", minSalePrice=" + minSalePrice + ", getItNowPrice=" + getItNowPrice + ", auctionEndsTime="
				+ auctionEndsTime + ", returnable=" + returnable + ", name=" + name + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemName, item.itemName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(itemName);
    }
	
}
