package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientRequest;

import java.util.List;

public interface ClientService {

    List<ClientDTO> getAllClients() throws Exception;
    ClientDTO getClientById(Integer clientId) throws Exception;
    ClientDTO createClient(CreateClientRequest createClientRequest) throws Exception;
    ClientDTO updateClient(Integer clientId, UpdateClientRequest updateClientRequest) throws Exception;
    void deleteClient(Integer clientId) throws Exception;
}
