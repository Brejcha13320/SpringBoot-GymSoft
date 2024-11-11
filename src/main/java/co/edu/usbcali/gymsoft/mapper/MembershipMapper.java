package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembeshipRequest;

import java.util.List;

public class MembershipMapper {

    public static MembershipDTO domainToDto(Membership membership) {
        return MembershipDTO.builder()
                .membershipId(membership.getMembershipId())
                .type(membership.getType())
                .description(membership.getDescription())
                .cost(membership.getCost())
                .enabled(membership.getEnabled())
                .createdAt(membership.getCreatedAt())
                .updatedAt(membership.getUpdatedAt())
                .build();
    }

    public static Membership dtoToDomain(MembershipDTO userDTO){
        return Membership.builder()
                .membershipId(userDTO.getMembershipId())
                .type(userDTO.getType())
                .description(userDTO.getDescription())
                .cost(userDTO.getCost())
                .enabled(userDTO.getEnabled())
                .createdAt(userDTO.getCreatedAt())
                .updatedAt(userDTO.getUpdatedAt())
                .build();
    }

    public static List<MembershipDTO> domainToDtoList(List<Membership> memberships){
        return memberships.stream().map(MembershipMapper::domainToDto).toList();
    }

    public static List<Membership> dtoToDomainList(List<MembershipDTO> membershipsDTO){
        return membershipsDTO.stream().map(MembershipMapper::dtoToDomain).toList();
    }

    public static Membership createMembershipRequestToDomain(CreateMembeshipRequest createMembeshipRequest){
        return Membership.builder()
                .type(createMembeshipRequest.getType())
                .description(createMembeshipRequest.getDescription())
                .cost(createMembeshipRequest.getCost())
                .build();
    }

}
