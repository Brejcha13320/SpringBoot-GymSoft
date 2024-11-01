package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll(){
        return ResponseEntity.ok(this.clientService.getAll());
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getById(@PathVariable int clientId){
        return ResponseEntity.ok(this.clientService.getById(clientId));
    }

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client){
        return ResponseEntity.ok(this.clientService.save(client));
    }

}
