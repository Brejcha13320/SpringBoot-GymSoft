package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientRequest;

import java.util.List;

public interface ClientService {

    public List<ClientDTO> getAllClients() throws Exception;

    public ClientDTO getClientById(Integer clientId) throws Exception;

    public ClientDTO createClient(CreateClientRequest createClientRequest) throws Exception;

    public ClientDTO updateClient(Integer clientId, UpdateClientRequest updateClientRequest) throws Exception;
}
