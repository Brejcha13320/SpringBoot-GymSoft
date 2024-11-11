package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;
import co.edu.usbcali.gymsoft.mapper.EntryRecordMapper;
import co.edu.usbcali.gymsoft.repository.ClientMembershipRepository;
import co.edu.usbcali.gymsoft.repository.EntryRecordRepository;
import co.edu.usbcali.gymsoft.service.EntryRecordService;
import co.edu.usbcali.gymsoft.utils.validation.EntryRecordMessage;
import org.springframework.stereotype.Service;

@Service
public class EntryRecordServiceImpl implements EntryRecordService {

    private final EntryRecordRepository entryRecordRepository;
    private final ClientMembershipRepository clientMembershipRepository;

    public EntryRecordServiceImpl(EntryRecordRepository entryRecordRepository, ClientMembershipRepository clientMembershipRepository) {
        this.entryRecordRepository = entryRecordRepository;
        this.clientMembershipRepository = clientMembershipRepository;
    }


    @Override
    public EntryRecordDTO createEntryRecord(CreateEntryRecordRequest createEntryRecordRequest) throws Exception {
        //Validar que exista el client-Membership
        Integer clientMembershipId = createEntryRecordRequest.getClientMembershipId();
        ClientMembership clientMembership = clientMembershipRepository.findById(clientMembershipId)
                .orElseThrow(
                        () -> new Exception(String.format(EntryRecordMessage.EXISTS_CLIENT_MEMBERSHIP, clientMembershipId))
                );

        EntryRecord entryRecord = EntryRecordMapper.createEntryRecord(createEntryRecordRequest);
        entryRecord.setClientMembership(clientMembership);
        entryRecord = entryRecordRepository.save(entryRecord);
        return EntryRecordMapper.domainToDto(entryRecord);
    }
}
