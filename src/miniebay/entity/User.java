package miniebay.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/*
 *    --------------------------
 *    |      Author: Yu        | 
 *    --------------------------
 */

@Entity
@Table(name="USER")
public class User {
	
	@Id
	@Column(name="Username")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="First_name")
	private String firstName;
	
	@Column(name="Last_name")
	private String lastName;
	
	// mappedBy takes the instance name from the Item class
	@OneToMany(mappedBy="ownerUsername", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Item> items;
	
	@OneToMany(mappedBy="bidUsername", 
			cascade= {CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Bid> bids;
	
	public User() {
		
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "User [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(userName);
    }
	
}
