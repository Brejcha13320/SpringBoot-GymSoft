package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDto;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.mapper.ClientMapper;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import co.edu.usbcali.gymsoft.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<ClientDto> getAll() {
        return ClientMapper.domainToDtoList(this.clientRepository.findAll());
    }

    public Client getById(int clientId){
        return this.clientRepository.findById(clientId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
    }

    public ClientDto save(CreateClientRequest createClientRequest) {
        //TODO: agregar validaciones

        Client client = ClientMapper.createClientRequestToDomain(createClientRequest);
        client = this.clientRepository.save(client);
        return ClientMapper.domainToDto(client);
    }

}
