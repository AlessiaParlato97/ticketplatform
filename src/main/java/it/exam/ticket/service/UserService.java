package it.exam.ticket.service;
import it.exam.ticket.model.AvailableStatus;
import it.exam.ticket.model.Users;
import it.exam.ticket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Recupero di un operatore per ID
    public Users getUserById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Operatore non trovato"));
    }

    public Users updateOperatorStatus(int userId, boolean available) {
        Users user = getUserById(userId);
        AvailableStatus status = available ? AvailableStatus.DISPONIBILE : AvailableStatus.NON_DISPONIBILE; // Converti boolean in enum
        user.setAvailable(status);
        return userRepository.save(user);
 
    }
}
