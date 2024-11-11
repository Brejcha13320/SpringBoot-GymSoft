package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientMembershipRequest;

import java.util.List;

public interface ClientMembershipService {

    public List<ClientMembershipDTO> getAllClientMemberships() throws Exception;
    public ClientMembershipDTO getClientMembershipById(Integer clientMembershipId) throws Exception;
    public ClientMembershipDTO createClientMembership(CreateClientMembershipRequest createClientMembershipRequest) throws Exception;

}
