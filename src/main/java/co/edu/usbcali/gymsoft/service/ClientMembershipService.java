package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientMembershipRequest;

import java.util.List;

public interface ClientMembershipService {

    List<ClientMembershipDTO> getAllClientMemberships() throws Exception;
    ClientMembershipDTO getClientMembershipById(Integer clientMembershipId) throws Exception;
    ClientMembershipDTO createClientMembership(CreateClientMembershipRequest createClientMembershipRequest) throws Exception;
    void deleteClientMembership(Integer clientMembershipId) throws Exception;
}