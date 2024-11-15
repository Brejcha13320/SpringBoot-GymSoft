package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateEntryRecordRequest;
import co.edu.usbcali.gymsoft.mapper.EntryRecordMapper;
import co.edu.usbcali.gymsoft.repository.ClientMembershipRepository;
import co.edu.usbcali.gymsoft.repository.EntryRecordRepository;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.EntryRecordService;
import co.edu.usbcali.gymsoft.utils.validation.EntryRecordMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryRecordServiceImpl implements EntryRecordService {

    private final EntryRecordRepository entryRecordRepository;
    private final ClientMembershipRepository clientMembershipRepository;
    private final UserRepository userRepository;

    public EntryRecordServiceImpl(EntryRecordRepository entryRecordRepository, ClientMembershipRepository clientMembershipRepository, UserRepository userRepository) {
        this.entryRecordRepository = entryRecordRepository;
        this.clientMembershipRepository = clientMembershipRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<EntryRecordDTO> findAllEntryRecord() throws Exception{
        List<EntryRecord> entryRecords = entryRecordRepository.findAll();
        return EntryRecordMapper.domainToDtoList(entryRecords);
    };

    @Override
    public EntryRecordDTO findEntryRecordById(Integer entryRecordId) throws Exception {
        EntryRecord entryRecord = entryRecordRepository.findById(entryRecordId)
                .orElseThrow(() -> new Exception(String.format(EntryRecordMessage.EXISTS_ENTRY_RECORD, entryRecordId)));

        return EntryRecordMapper.domainToDto(entryRecord);
    }

    @Override
    public EntryRecordDTO createEntryRecord(CreateEntryRecordRequest createEntryRecordRequest) throws Exception {
        // Obtener el ID de la membresía del cliente del request
        Integer clientMembershipId = createEntryRecordRequest.getClientMembershipId();

        // Buscar la membresía del cliente por ID
        ClientMembership clientMembership = clientMembershipRepository.findById(clientMembershipId)
                .orElseThrow(() -> new Exception(String.format(EntryRecordMessage.EXISTS_CLIENT_MEMBERSHIP, clientMembershipId)));

        // Crear un nuevo registro de entrada a partir del request
        EntryRecord entryRecord = EntryRecordMapper.createEntryRecord(createEntryRecordRequest);

        // Asignar la membresía del cliente al registro de entrada
        entryRecord.setClientMembership(clientMembership);

        // Guardar el registro de entrada en el repositorio
        entryRecord = entryRecordRepository.save(entryRecord);

        // Convertir y devolver el registro de entrada como DTO
        return EntryRecordMapper.domainToDto(entryRecord);
    }


    @Override
    public EntryRecordDTO updateEntryRecord(Integer entryRecordId, UpdateEntryRecordRequest updateEntryRecordRequest) throws Exception {
        // Buscar el registro de entrada por ID
        EntryRecordDTO entryRecordDTO = findEntryRecordById(entryRecordId);
        EntryRecord entryRecord = EntryRecordMapper.dtoToDomain(entryRecordDTO);

        // Actualizar el registro de entrada con los nuevos datos
        entryRecord = EntryRecordMapper.updateEntryRecord(entryRecord, updateEntryRecordRequest);

        // Obtener el ID de la membresía del cliente
        Integer clientMembershipId = updateEntryRecordRequest.getClientMembershipId();
        if (clientMembershipId != null && clientMembershipId != 0) {
            // Buscar la membresía del cliente por ID
            ClientMembership clientMembership = clientMembershipRepository.findById(clientMembershipId)
                    .orElseThrow(() -> new Exception(String.format(EntryRecordMessage.EXISTS_CLIENT_MEMBERSHIP, clientMembershipId)));

            // Asignar la membresía del cliente al registro de entrada
            entryRecord.setClientMembership(clientMembership);
        }else {
            throw new Exception(String.format(EntryRecordMessage.NOT_NULL_CLIENT_MEMBERSHIP_ID, clientMembershipId));
        }

        // Guardar el registro de entrada actualizado en el repositorio
        entryRecord = entryRecordRepository.save(entryRecord);

        // Convertir y devolver el registro de entrada actualizado como DTO
        return EntryRecordMapper.domainToDto(entryRecord);
    }


    @Override
    public void deleteEntryRecord(Integer entryRecordId) throws Exception {
        EntryRecordDTO entryRecordDTO = findEntryRecordById(entryRecordId);
        EntryRecord entryRecord = EntryRecordMapper.dtoToDomain(entryRecordDTO);
        entryRecordRepository.delete(entryRecord);
    }

}
