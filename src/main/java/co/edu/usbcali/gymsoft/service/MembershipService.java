package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembershipRequest;

import java.util.List;

public interface MembershipService {

    public List<MembershipDTO> getAllMemberships() throws Exception;
    public MembershipDTO getMembershipById(Integer membershipId) throws Exception;
    public MembershipDTO createMembership(CreateMembershipRequest createMembershipRequest) throws Exception;

}
