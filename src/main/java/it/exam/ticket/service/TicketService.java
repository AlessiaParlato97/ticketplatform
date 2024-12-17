package it.exam.ticket.service;

import it.exam.ticket.model.Ticket;
import it.exam.ticket.model.TicketStatus;
import it.exam.ticket.repository.TicketRepository;
//import it.exam.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    /*@Autowired
    private UserRepository userRepository;*/

    public Ticket createTicket(Ticket ticket) {
        // Verifica se l'operatore è disponibile
        if (!ticket.getUser().isAvailable()) {
            throw new IllegalArgumentException("Operatore non disponibile");
        }

        ticket.setStatus(TicketStatus.APERTO); // Stato iniziale
        return ticketRepository.save(ticket);
    }


    // Recupero di tutti i ticket
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    // Recupero di un ticket specifico tramite ID
    public Ticket getTicketById(int ticketId) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketId);
        if (ticket.isPresent()) {
            return ticket.get();
        } else {
            throw new IllegalArgumentException("Ticket non trovato");
        }
    }

    // Modifica dei dettagli di un ticket
    public Ticket updateTicket(int ticketId, Ticket ticketDetails) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setTitle(ticketDetails.getTitle());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setCategory(ticketDetails.getCategory());
        // Altri aggiornamenti...
        return ticketRepository.save(ticket);
    }

    // Eliminazione di un ticket
    public void deleteTicket(int ticketId) {
        ticketRepository.deleteById(ticketId);
    }

    // Aggiornamento dello stato di un ticket
    public Ticket updateTicketStatus(int ticketId, TicketStatus status) {
        Ticket ticket = getTicketById(ticketId);
        ticket.setStatus(status);
        return ticketRepository.save(ticket);
    }
}
