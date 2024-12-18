package it.exam.ticket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.*;


@Entity
@Table (name = "note")
public class Note {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

	@ManyToMany
	@JoinTable(
	  name = "ticket_note", 
	  joinColumns = @JoinColumn(name = "note_id"), 
	  inverseJoinColumns = @JoinColumn(name = "ticket_id"))
	List<Ticket> listTickets;

	
    @ManyToOne
	@JoinColumn(name = "user_id")
	private Users userId;
	
	private String text;
	
	private Date creationDate;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	
	public Users getUser() {
        return userId;
    }

    public void setUser(Users user) {
        this.userId = user;
    }


	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	

	
}
