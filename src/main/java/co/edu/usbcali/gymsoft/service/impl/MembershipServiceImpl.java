package co.edu.usbcali.gymsoft.service.impl;


import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembeshipRequest;
import co.edu.usbcali.gymsoft.mapper.MembershipMapper;
import co.edu.usbcali.gymsoft.repository.MembershipRepository;
import co.edu.usbcali.gymsoft.service.MembershipService;
import org.springframework.stereotype.Service;

@Service
public class MembershipServiceImpl implements MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipServiceImpl(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public MembershipDTO createMembership(CreateMembeshipRequest createMembeshipRequest) throws Exception {
        Membership membership = MembershipMapper.createMembershipRequestToDomain(createMembeshipRequest);
        membership = membershipRepository.save(membership);
        MembershipDTO membershipDTO = MembershipMapper.domainToDto(membership);
        return membershipDTO;
    }
}
