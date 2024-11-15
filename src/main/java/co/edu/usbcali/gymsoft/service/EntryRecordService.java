package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateEntryRecordRequest;

import java.util.List;

public interface EntryRecordService {

    public List<EntryRecordDTO> findAllEntryRecord() throws Exception;
    public EntryRecordDTO findEntryRecordById(Integer entryRecordId) throws Exception;
    public EntryRecordDTO createEntryRecord(CreateEntryRecordRequest createEntryRecordRequest) throws Exception;
    public EntryRecordDTO updateEntryRecord(Integer entryRecordId, UpdateEntryRecordRequest updateEntryRecordRequest) throws Exception;
    void deleteEntryRecord(Integer entryRecordId) throws Exception;
}
