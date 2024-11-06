package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.services.old.ClientMembershipServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientMembership")
public class ClientMembershipController {

    private final ClientMembershipServiceOld clientMembershipService;

    @Autowired
    public ClientMembershipController(ClientMembershipServiceOld clientMembershipService) {
        this.clientMembershipService = clientMembershipService;
    }

    @GetMapping
    public ResponseEntity<List<ClientMembership>> getAll(){
        return ResponseEntity.ok(this.clientMembershipService.getAll());
    }

    @GetMapping("/{clientMembershipId}")
    public ResponseEntity<ClientMembership> getById(@PathVariable int clientMembershipId){
        return ResponseEntity.ok(this.clientMembershipService.getById(clientMembershipId));
    }

    @PostMapping
    public ResponseEntity<ClientMembership> save(@RequestBody ClientMembership clientMembership){
        return ResponseEntity.ok(this.clientMembershipService.save(clientMembership));
    }

}
