package it.exam.ticket.model;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table (name = "ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	@OneToMany(mappedBy = "ticket")
    private List<TicketNote> ticketNotes;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;
	
	private String title;
	
	private String description;
	
    private Date creationDate;
	
	private Date closeDate;
	
	private String category;
	
	@Enumerated(EnumType.STRING)
    private TicketStatus status;
	
	  public TicketStatus getStatus() {
	        return status;
	    }

	    public void setStatus(TicketStatus status) {
	        this.status = status;
	    }
	
	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	
	public Users getUser() {
        return userId;
    }

    public void setUser(Users user) {
        this.userId = user;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	
	

}
