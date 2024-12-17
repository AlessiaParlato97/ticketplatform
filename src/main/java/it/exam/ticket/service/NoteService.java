package it.exam.ticket.service;
import java.util.List;
import it.exam.ticket.model.Note;
import it.exam.ticket.model.Ticket;
import it.exam.ticket.repository.NoteRepository;
import it.exam.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private TicketRepository ticketRepository;

    // Aggiunta di una nota a un ticket
    public Note addNoteToTicket(int ticketId, Note note) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket non trovato"));
        
        note.setTicket(ticket);
        return noteRepository.save(note);
    }

    public List<Note> getNotesForTicket(int ticketId) {
        return noteRepository.findByTicketNotes_Ticket_TicketId(ticketId);
    }

}
