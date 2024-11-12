package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientRequest;
import co.edu.usbcali.gymsoft.mapper.ClientMapper;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import co.edu.usbcali.gymsoft.service.ClientService;
import co.edu.usbcali.gymsoft.utils.validation.ClientMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientDTO> getAllClients() throws Exception {
        List<Client> clients = clientRepository.findAll();
        return ClientMapper.domainToDtoList(clients);
    }

    @Override
    public ClientDTO getClientById(Integer clientId) throws Exception {
        Client client = clientRepository.findById(clientId).orElseThrow(
                () -> new Exception(String.format(ClientMessage.NOT_EXISTS_BY_CLIENT_ID, clientId))
        );

        return ClientMapper.domainToDto(client);
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

    @Override
    public ClientDTO updateClient(Integer clientId, UpdateClientRequest updateClientRequest) throws Exception {
        ClientDTO clientDTO = getClientById(clientId);
        Client client = ClientMapper.dtoToDomain(clientDTO);
        client = ClientMapper.updateClientRequestToDomain(client, updateClientRequest);
        client = clientRepository.save(client);
        return ClientMapper.domainToDto(client);
    }

    @Override
    public void deleteClient(Integer clientId) throws Exception {
        ClientDTO clientDTO = getClientById(clientId);
        Client client = ClientMapper.dtoToDomain(clientDTO);
        clientRepository.delete(client);
    }

}
