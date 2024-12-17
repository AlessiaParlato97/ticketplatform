package it.exam.ticket.repository;

import it.exam.ticket.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
	
    Users findByEmail(String email);
}
