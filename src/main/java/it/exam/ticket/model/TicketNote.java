package it.exam.ticket.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "ticket_note")
public class TicketNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketNoteId;
	
	@ManyToMany
	private Ticket ticketId;
	
	@ManyToMany
	private Note noteId;


	public int getTicketNoteId() {
		return ticketNoteId;
	}


	public void setTicketNoteId(int ticketNoteId) {
		this.ticketNoteId = ticketNoteId;
	}


	public Ticket getTicketId() {
		return ticketId;
	}


	public void setTicketId(Ticket ticketId) {
		this.ticketId = ticketId;
	}


	public Note getNoteId() {
		return noteId;
	}


	public void setNoteId(Note noteId) {
		this.noteId = noteId;
	}
	
	
}
