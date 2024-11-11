package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientMembershipRequest;
import co.edu.usbcali.gymsoft.service.ClientMembershipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/client-membership")
public class ClientMembershipController {

    private final ClientMembershipService clientMembershipService;

    @Autowired
    public ClientMembershipController(ClientMembershipService clientMembershipService) {
        this.clientMembershipService = clientMembershipService;
    }

    @PostMapping
    public ResponseEntity<ClientMembershipDTO> createClientMembership(@RequestBody @Valid CreateClientMembershipRequest createClientMembershipRequest) throws Exception {
        ClientMembershipDTO clientMembershipDTO = clientMembershipService.createClientMembership(createClientMembershipRequest);
        return ResponseEntity.ok().body(clientMembershipDTO);
    }

//    @GetMapping
//    public ResponseEntity<List<ClientMembership>> getAll(){
//        return ResponseEntity.ok(this.clientMembershipService.getAll());
//    }
//
//    @GetMapping("/{clientMembershipId}")
//    public ResponseEntity<ClientMembership> getById(@PathVariable int clientMembershipId){
//        return ResponseEntity.ok(this.clientMembershipService.getById(clientMembershipId));
//    }
//
//    @PostMapping
//    public ResponseEntity<ClientMembership> save(@RequestBody ClientMembership clientMembership){
//        return ResponseEntity.ok(this.clientMembershipService.save(clientMembership));
//    }

}
