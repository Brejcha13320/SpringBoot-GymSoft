package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateClientMembershipRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateClientMembershipRequest;
import co.edu.usbcali.gymsoft.mapper.ClientMembershipMapper;
import co.edu.usbcali.gymsoft.repository.ClientMembershipRepository;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import co.edu.usbcali.gymsoft.repository.MembershipRepository;
import co.edu.usbcali.gymsoft.service.ClientMembershipService;
import co.edu.usbcali.gymsoft.utils.validation.ClientMembershipMessage;
import co.edu.usbcali.gymsoft.utils.validation.ClientMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientMembershipServiceImpl implements ClientMembershipService {

    private final ClientMembershipRepository clientMembershipRepository;
    private final MembershipRepository membershipRepository;
    private final ClientRepository clientRepository;

    public ClientMembershipServiceImpl(
            ClientMembershipRepository clientMembershipRepository,
            MembershipRepository membershipRepository,
            ClientRepository clientRepository
    ) {
        this.clientMembershipRepository = clientMembershipRepository;
        this.membershipRepository = membershipRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public List<ClientMembershipDTO> getAllClientMemberships() throws Exception {
        List<ClientMembership> clientMembership = clientMembershipRepository.findAll();
        return ClientMembershipMapper.domainToDtoList(clientMembership);
    }

    @Override
    public ClientMembershipDTO getClientMembershipById(Integer clientMembershipId) throws Exception {
        ClientMembership clientMembership = clientMembershipRepository.findById(clientMembershipId).orElseThrow(
                () -> new Exception(String.format(ClientMessage.NOT_EXISTS_BY_CLIENT_MEMBERSHIP_ID, clientMembershipId))
        );

        return ClientMembershipMapper.domainToDto(clientMembership);
    }

    @Override
    public ClientMembershipDTO createClientMembership(CreateClientMembershipRequest createClientMembershipRequest) throws Exception {

        //Validar que exista el client
        Integer clientId = createClientMembershipRequest.getClientId();
        Client client = clientRepository.findById(clientId)
                .orElseThrow(
                        () -> new Exception(String.format(ClientMembershipMessage.EXISTS_CLIENT, clientId))
                );

        //Validar que exista el membership
        Integer membershipId = createClientMembershipRequest.getMembershipId();
        Membership membership = membershipRepository.findById(membershipId)
                .orElseThrow(
                        () -> new Exception(String.format(ClientMembershipMessage.EXISTS_MEMBERSHIP, membershipId))
                );

        ClientMembership clientMembership = ClientMembershipMapper.createClientMembershipRequestToDomain(createClientMembershipRequest);
        clientMembership.setClient(client);
        clientMembership.setMembership(membership);
        clientMembership = clientMembershipRepository.save(clientMembership);
        return ClientMembershipMapper.domainToDto(clientMembership);
    }

    @Override
    public ClientMembershipDTO updateClientMembership(Integer clientMembershipId, UpdateClientMembershipRequest updateClientMembershipRequest) throws Exception {
        ClientMembershipDTO clientMembershipDTO = getClientMembershipById(clientMembershipId);
        ClientMembership clientMembership = ClientMembershipMapper.dtoToDomain(clientMembershipDTO);
        clientMembership = ClientMembershipMapper.updateClientMembershipRequestToDomain(clientMembership, updateClientMembershipRequest);
        clientMembership = clientMembershipRepository.save(clientMembership);
        return ClientMembershipMapper.domainToDto(clientMembership);
    }

    @Override
    public void deleteClientMembership(Integer clientMembershipId) throws Exception {
        ClientMembershipDTO clientMembershipDTO = getClientMembershipById(clientMembershipId);
        ClientMembership clientMembership = ClientMembershipMapper.dtoToDomain(clientMembershipDTO);
        clientMembershipRepository.delete(clientMembership);
    }
}
