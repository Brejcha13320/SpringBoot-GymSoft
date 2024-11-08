package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.MembershipDto;

public class MembershipMapper {

    public static MembershipDto domainToDto(Membership membership) {
        return MembershipDto.builder()
                .membershipId(membership.getMembershipId())
                .type(membership.getType())
                .description(membership.getDescription())
                .cost(membership.getCost())
                .enabled(membership.getEnabled())
                .createdAt(membership.getCreatedAt())
                .updatedAt(membership.getUpdatedAt())
                .build();
    }

    public static Membership dtoToDomain(MembershipDto membershipDto) {
        return Membership.builder()
                .membershipId(membershipDto.getMembershipId())
                .type(membershipDto.getType())
                .description(membershipDto.getDescription())
                .cost(membershipDto.getCost())
                .enabled(membershipDto.getEnabled())
                .createdAt(membershipDto.getCreatedAt())
                .updatedAt(membershipDto.getUpdatedAt())
                .build();
    }

}