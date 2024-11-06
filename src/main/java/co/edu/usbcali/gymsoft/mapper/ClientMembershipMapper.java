package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;

import java.util.List;

public class ClientMembershipMapper {

    public static ClientMembershipDTO domainToDto(ClientMembership clientMembership) {
        return ClientMembershipDTO.builder()
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
                .clientId(clientMembership.getClient() == null ? null : clientMembership.getClient().getClientId())
                .membershipId(clientMembership.getMembership() == null ? null : clientMembership.getMembership().getMembershipId())
                .build();
    }

    public static ClientMembership dtoToDomain(ClientMembershipDTO clientMembershipDTO){
        return ClientMembership.builder()
                .clientMembershipId(clientMembershipDTO.getClientMembershipId())
                .startDate(clientMembershipDTO.getStartDate())
                .endDate(clientMembershipDTO.getEndDate())
                .remainingDays(clientMembershipDTO.getRemainingDays())
                .quantity(clientMembershipDTO.getQuantity())
                .cost(clientMembershipDTO.getCost())
                .price(clientMembershipDTO.getPrice())
                .enabled(clientMembershipDTO.getEnabled())
                .createdAt(clientMembershipDTO.getCreatedAt())
                .updatedAt(clientMembershipDTO.getUpdatedAt())
                .build();
    }

    public static List<ClientMembershipDTO> domainToDtoList(List<ClientMembership> clientsMemberships) {
        return clientsMemberships.stream().map(ClientMembershipMapper::domainToDto).toList();
    }

    public static List<ClientMembership> dtoToDomainList(List<ClientMembershipDTO> clientsMembershipsDTO){
        return clientsMembershipsDTO.stream().map(ClientMembershipMapper::dtoToDomain).toList();
    }

}
