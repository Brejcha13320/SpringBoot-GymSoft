package co.edu.usbcali.gymsoft.services.old;

import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.repository.MembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MembershipServiceOld {

    private final MembershipRepository membershipRepository;

    @Autowired
    public MembershipServiceOld(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    public Membership getById(int membershipId){
        return this.membershipRepository.findById(membershipId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Membership not found"));
    }

    public List<Membership> getAll() {
        return this.membershipRepository.findAll();
    }

    public Membership save(Membership membership) {
        return this.membershipRepository.save(membership);
    }

}
