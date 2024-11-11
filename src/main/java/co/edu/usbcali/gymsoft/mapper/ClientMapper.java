package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientRequest;
import co.edu.usbcali.gymsoft.utils.Constants;

import java.util.List;

public class ClientMapper {

    public static ClientDTO domainToDto(Client client) {
        return ClientDTO.builder()
                .clientId(client.getClientId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .address(client.getAddress())
                .email(client.getEmail())
                .phone(client.getPhone())
                .enabled(client.getEnabled())
                .createdAt(client.getCreatedAt())
                .updatedAt(client.getUpdatedAt())
                .build();
    }

    public static Client dtoToDomain(ClientDTO clientDTO){
        return Client.builder()
                .clientId(clientDTO.getClientId())
                .firstName(clientDTO.getFirstName())
                .lastName(clientDTO.getLastName())
                .address(clientDTO.getAddress())
                .email(clientDTO.getEmail())
                .phone(clientDTO.getPhone())
                .enabled(clientDTO.getEnabled())
                .createdAt(clientDTO.getCreatedAt())
                .updatedAt(clientDTO.getUpdatedAt())
                .build();
    }

    public static List<ClientDTO> domainToDtoList(List<Client> clients){
        return clients.stream().map(ClientMapper::domainToDto).toList();
    }

    public static List<Client> dtoToDomainList(List<ClientDTO> clientsDTO){
        return clientsDTO.stream().map(ClientMapper::dtoToDomain).toList();
    }

    public static Client createClientRequestToDomain(CreateClientRequest createClientRequest){
        return Client.builder()
                .firstName(createClientRequest.getFirstName())
                .lastName(createClientRequest.getLastName())
                .address(createClientRequest.getAddress())
                .email(createClientRequest.getEmail())
                .phone(createClientRequest.getPhone())
                .enabled(Constants.ENABLE_ACTIVE)
                .build();
    }

    public static Client updateClientRequestToDomain(Client client, UpdateClientRequest updateClientRequest){
        client.setFirstName(updateClientRequest.getFirstName());
        client.setLastName(updateClientRequest.getLastName());
        client.setAddress(updateClientRequest.getAddress());
        client.setEmail(updateClientRequest.getEmail());
        client.setPhone(updateClientRequest.getPhone());
        return client;
    }

}
