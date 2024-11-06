package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;

import java.util.List;

public class EntryRecordMapper {

    public static EntryRecordDTO domainToDto(EntryRecord entryRecord) {
        return EntryRecordDTO.builder()
                .entryRecordId(entryRecord.getEntryRecordId())
                .entryDate(entryRecord.getEntryDate())
                .clientMembershipId(entryRecord.getClientMembership() == null ? null : entryRecord.getClientMembership().getClientMembershipId())
                .build();
    }

    public static EntryRecord dtoToDomain(EntryRecordDTO entryRecordDTO){
        return EntryRecord.builder()
                .entryRecordId(entryRecordDTO.getEntryRecordId())
                .entryDate(entryRecordDTO.getEntryDate())
                .build();
    }

    public static List<EntryRecordDTO> domainToDtoList(List<EntryRecord> entryRecords){
        return entryRecords.stream().map(EntryRecordMapper::domainToDto).toList();
    }

    public static List<EntryRecord> dtoToDomainList(List<EntryRecordDTO> entryRecordsDTO){
        return entryRecordsDTO.stream().map(EntryRecordMapper::dtoToDomain).toList();
    }

}
