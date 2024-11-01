package co.edu.usbcali.gymsoft.repository;
import co.edu.usbcali.gymsoft.domain.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

}
