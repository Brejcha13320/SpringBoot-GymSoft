package co.edu.usbcali.gymsoft.repository;

import co.edu.usbcali.gymsoft.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
