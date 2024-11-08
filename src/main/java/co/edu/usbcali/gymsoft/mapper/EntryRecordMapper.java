package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.dto.EntryRecordDto;

public class EntryRecordMapper {

    public EntryRecordDto domainToDto(EntryRecord entryRecord) {
        return EntryRecordDto.builder()
                .entryRecordId(entryRecord.getEntryRecordId())
                //.clientMembership(entryRecord.getClientMembership())
                .entryDate(entryRecord.getEntryDate())
                .build();
    }

    public EntryRecord domainToDto(EntryRecordDto entryRecordDto) {
        return EntryRecord.builder()
                .entryRecordId(entryRecordDto.getEntryRecordId())
                //.clientMembership(entryRecordDto.getClientMembership())
                .entryDate(entryRecordDto.getEntryDate())
                .build();
    }

}
