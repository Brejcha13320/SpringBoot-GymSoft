package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembershipRequest;

public interface MembershipService {

    public MembershipDTO createMembership(CreateMembershipRequest createMembeshipRequest) throws Exception;

}
