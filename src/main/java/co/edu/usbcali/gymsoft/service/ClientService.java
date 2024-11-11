package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;

public interface ClientService {

    public ClientDTO createClient(CreateClientRequest createClientRequest) throws Exception;

}
