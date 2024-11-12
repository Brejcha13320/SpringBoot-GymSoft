package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembershipRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateMembershipRequest;

import java.util.List;

public interface MembershipService {

    List<MembershipDTO> getAllMemberships() throws Exception;
    MembershipDTO getMembershipById(Integer membershipId) throws Exception;
    MembershipDTO createMembership(CreateMembershipRequest createMembershipRequest) throws Exception;
    MembershipDTO updateMembership(Integer membershipId, UpdateMembershipRequest updateMembershipRequest) throws Exception;
    void deleteMembership(Integer membershipId) throws Exception;

}
