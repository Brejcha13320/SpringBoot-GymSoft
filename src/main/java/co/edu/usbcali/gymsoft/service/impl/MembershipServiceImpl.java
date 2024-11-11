package co.edu.usbcali.gymsoft.service.impl;


import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembershipRequest;
import co.edu.usbcali.gymsoft.mapper.MembershipMapper;
import co.edu.usbcali.gymsoft.repository.MembershipRepository;
import co.edu.usbcali.gymsoft.service.MembershipService;
import co.edu.usbcali.gymsoft.utils.validation.ClientMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipServiceImpl(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<MembershipDTO> getAllMemberships() throws Exception {
        List<Membership> memberships = membershipRepository.findAll();
        return MembershipMapper.domainToDtoList(memberships);
    }

    @Override
    public MembershipDTO getMembershipById(Integer membershipId) throws Exception {
        Membership membership = membershipRepository.findById(membershipId).orElseThrow(
                () -> new Exception(String.format(ClientMessage.NOT_EXISTS_BY_MEMBERSHIP_ID, membershipId))
        );

        return MembershipMapper.domainToDto(membership);
    }

    @Override
    public MembershipDTO createMembership(CreateMembershipRequest createMembershipRequest) throws Exception {
        Membership membership = MembershipMapper.createMembershipRequestToDomain(createMembershipRequest);
        membership = membershipRepository.save(membership);
        MembershipDTO membershipDTO = MembershipMapper.domainToDto(membership);
        return membershipDTO;
    }
}
