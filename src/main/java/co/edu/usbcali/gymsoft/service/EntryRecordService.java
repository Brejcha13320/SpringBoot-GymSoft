package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;

public interface EntryRecordService {

    public EntryRecordDTO createEntryRecord(CreateEntryRecordRequest createEntryRecordRequest) throws Exception;

}
