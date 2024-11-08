package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDto;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;

import java.util.List;

public class ClientMapper {

    public static ClientDto domainToDto(Client client) {
        return ClientDto.builder()
                .clientId(client.getClientId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .address(client.getAddress())
                .email(client.getEmail())
                .phone(client.getPhone())
                .enabled(client.getEnabled())
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                /*.clientMemberships( client.getClientMemberships() != null
                        ? ClientMembershipMapper.domainToDtoList(client.getClientMemberships())
                        : null )*/
                .build();
    }

    public static Client dtoToDomain(ClientDto clientDto) {
        return Client.builder()
                .clientId(clientDto.getClientId())
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .address(clientDto.getAddress())
                .email(clientDto.getEmail())
                .phone(clientDto.getPhone())
                .enabled(clientDto.getEnabled())
                .createdAt(clientDto.getCreatedAt())
                .updatedAt(clientDto.getUpdatedAt())
                /*.clientMemberships( clientDto.getClientMemberships() != null
                        ? ClientMembershipMapper.dtoToDomainList(clientDto.getClientMemberships())
                        : null )*/
                .build();
    }

    public static Client createClientRequestToDomain(CreateClientRequest createClientRequest) {
        return Client.builder()
                .firstName(createClientRequest.getFirstName())
                .lastName(createClientRequest.getLastName())
                .address(createClientRequest.getAddress())
                .email(createClientRequest.getEmail())
                .phone(createClientRequest.getPhone())
                .enabled(createClientRequest.getEnabled())
                .createdAt(createClientRequest.getCreatedAt())
                .updatedAt(createClientRequest.getUpdatedAt())
                /*.clientMemberships( clientDto.getClientMemberships() != null
                        ? ClientMembershipMapper.dtoToDomainList(clientDto.getClientMemberships())
                        : null )*/
                .build();
    }

    public static List<ClientDto> domainToDtoList(List<Client> clients) {
        return clients.stream().map(ClientMapper::domainToDto).toList();
    }

    public static List<Client> dtoToDomainList(List<ClientDto> clientsDto) {
        return clientsDto.stream().map(ClientMapper::dtoToDomain).toList();
    }

}