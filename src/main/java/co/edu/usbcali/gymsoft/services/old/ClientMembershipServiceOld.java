package co.edu.usbcali.gymsoft.services.old;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.repository.ClientMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientMembershipServiceOld {

    private final ClientMembershipRepository clientMembershipRepository;

    @Autowired
    public ClientMembershipServiceOld(ClientMembershipRepository clientMembershipRepository) {
        this.clientMembershipRepository = clientMembershipRepository;
    }

    public ClientMembership getById(int clientMembershipId){
        return this.clientMembershipRepository.findById(clientMembershipId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Membership not found"));
    }

    public List<ClientMembership> getAll() {
        return this.clientMembershipRepository.findAll();
    }

    public ClientMembership save(ClientMembership clientMembership) {
        return this.clientMembershipRepository.save(clientMembership);
    }

}
