package it.exam.ticket.model;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_note")
public class TicketNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketNoteId;
    
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
    
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

 
    public int getTicketNoteId() {
        return ticketNoteId;
    }

    public void setTicketNoteId(int ticketNoteId) {
        this.ticketNoteId = ticketNoteId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}

