package co.edu.usbcali.gymsoft.repository;

import co.edu.usbcali.gymsoft.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Boolean existsByEmail(String email);
}
