package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client getById(int clientId){
        return this.clientRepository.findById(clientId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    public List<Client> getAll() {
        return this.clientRepository.findAll();
    }

    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

}
