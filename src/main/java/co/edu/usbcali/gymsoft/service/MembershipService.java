package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembeshipRequest;

public interface MembershipService {

    public MembershipDTO createMembership(CreateMembeshipRequest createMembeshipRequest) throws Exception;

}
