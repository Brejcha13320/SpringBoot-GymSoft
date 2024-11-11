package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientMembershipRequest;

public interface ClientMembershipService {

    public ClientMembershipDTO createClientMembership(CreateClientMembershipRequest createClientMembershipRequest) throws Exception;

}
