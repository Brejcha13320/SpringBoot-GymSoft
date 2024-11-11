package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.mapper.ClientMapper;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import co.edu.usbcali.gymsoft.service.ClientService;
import co.edu.usbcali.gymsoft.utils.validation.ClientMessage;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO createClient(CreateClientRequest createClientRequest) throws Exception {
        //Validar si ya existe un client con ese email
        Boolean existsByEmail = clientRepository.existsByEmail(createClientRequest.getEmail());
        if (existsByEmail) {
            throw new Exception(String.format(ClientMessage.EXISTS_BY_EMAIL, createClientRequest.getEmail()));
        }

        Client client = ClientMapper.createClientRequestToDomain(createClientRequest);
        client = clientRepository.save(client);
        ClientDTO clientDTO = ClientMapper.domainToDto(client);
        return clientDTO;
    }
}