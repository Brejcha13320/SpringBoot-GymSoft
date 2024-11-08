package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.dto.ClientMembershipDto;

import java.util.List;

public class ClientMembershipMapper {

    public static ClientMembershipDto domainToDto(ClientMembership clientMembership) {
        return ClientMembershipDto.builder()
                .clientMembershipId(clientMembership.getClientMembershipId())
                .startDate(clientMembership.getStartDate())
                .endDate(clientMembership.getEndDate())
                .remainingDays(clientMembership.getRemainingDays())
                .quantity(clientMembership.getQuantity())
                .cost(clientMembership.getCost())
                .price(clientMembership.getPrice())
                .enabled(clientMembership.getEnabled())
                .createdAt(clientMembership.getCreatedAt())
                .updatedAt(clientMembership.getUpdatedAt())
                /*.client( clientMembership.getClient() != null
                        ? ClientMapper.domainToDto(clientMembership.getClient())
                        : null )
                .membership( clientMembership.getMembership() != null
                        ? MembershipMapper.domainToDto(clientMembership.getMembership())
                        : null )*/
                .build();
    }

    public static ClientMembership dtoToDomain(ClientMembershipDto clientMembershipDto) {
        return ClientMembership.builder()
                .clientMembershipId(clientMembershipDto.getClientMembershipId())
                .startDate(clientMembershipDto.getStartDate())
                .endDate(clientMembershipDto.getEndDate())
                .remainingDays(clientMembershipDto.getRemainingDays())
                .quantity(clientMembershipDto.getQuantity())
                .cost(clientMembershipDto.getCost())
                .price(clientMembershipDto.getPrice())
                .enabled(clientMembershipDto.getEnabled())
                .createdAt(clientMembershipDto.getCreatedAt())
                .updatedAt(clientMembershipDto.getUpdatedAt())
                /*.client( clientMembershipDto.getClient() != null
                        ? ClientMapper.dtoToDomain(clientMembershipDto.getClient())
                        : null )
                .membership( clientMembershipDto.getMembership() != null
                        ? MembershipMapper.dtoToDomain(clientMembershipDto.getMembership())
                        : null )*/
                .build();
    }

    public static List<ClientMembershipDto> domainToDtoList(List<ClientMembership> clientMemberships) {
        return clientMemberships.stream().map(ClientMembershipMapper::domainToDto).toList();
    }

    public static List<ClientMembership> dtoToDomainList(List<ClientMembershipDto> clientMembershipsDto) {
        return clientMembershipsDto.stream().map(ClientMembershipMapper::dtoToDomain).toList();
    }

}