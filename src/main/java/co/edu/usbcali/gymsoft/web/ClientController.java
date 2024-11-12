package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientRequest;
import co.edu.usbcali.gymsoft.service.ClientService;
import jakarta.validation.Valid;
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

    @GetMapping(value = "/all")
    public ResponseEntity<List<ClientDTO>> getAllClients() throws Exception {
        List<ClientDTO> clientsDTO = clientService.getAllClients();
        return ResponseEntity.ok(clientsDTO);
    }

    @GetMapping(value = "/one/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Integer clientId) throws Exception {
        ClientDTO clientDTO = clientService.getClientById(clientId);
        return ResponseEntity.ok(clientDTO);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody @Valid CreateClientRequest createClientRequest) throws Exception {
        ClientDTO clientDTO = clientService.createClient(createClientRequest);
        return ResponseEntity.ok().body(clientDTO);
    }

    @PutMapping(value = "/update/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(
            @PathVariable Integer clientId,
            @RequestBody @Valid UpdateClientRequest updateClientRequest
    ) throws Exception {
        ClientDTO clientDTO = clientService.updateClient(clientId, updateClientRequest);
        return ResponseEntity.ok(clientDTO);
    }

    @DeleteMapping(value = "/delete/{clientId}")
    public ResponseEntity<Void> deleteClient(@PathVariable Integer clientId) throws Exception {
        clientService.deleteClient(clientId);
        return ResponseEntity.noContent().build();
    }
}
