package it.exam.ticket.repository;

import it.exam.ticket.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {
    // Metodo per recuperare le note in base all'ID del ticket
    List<Note> findByTicketNotes_Ticket_TicketId(int ticketId);
}
