package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDto;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;

import java.util.List;

public interface ClientService {

    Client getById(int clientId) throws Exception;

    List<ClientDto> getAll() throws Exception;

    ClientDto save(CreateClientRequest createClientRequest) throws Exception;

}
