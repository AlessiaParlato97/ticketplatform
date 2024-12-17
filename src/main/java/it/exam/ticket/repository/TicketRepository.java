package it.exam.ticket.repository;

import it.exam.ticket.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    // Puoi aggiungere qui metodi personalizzati se necessario
}
