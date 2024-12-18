package it.exam.ticket.model;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.util.*;

@Entity
@Table (name = "user_type")
public class UsersType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int usersTypeId;
	
	private String category;
	
	private Date creationDate;
	
	private boolean available;

	
	public int getUserTypeId() {
		return usersTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.usersTypeId = userTypeId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	

}
