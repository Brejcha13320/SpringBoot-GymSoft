package co.edu.usbcali.gymsoft.repository;
import co.edu.usbcali.gymsoft.domain.ClientMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMembershipRepository extends JpaRepository<ClientMembership, Integer> {
}
