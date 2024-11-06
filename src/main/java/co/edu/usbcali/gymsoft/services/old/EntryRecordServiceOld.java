package co.edu.usbcali.gymsoft.services.old;

import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.repository.EntryRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EntryRecordServiceOld {

    private final EntryRecordRepository entryRecordRepository;

    @Autowired
    public EntryRecordServiceOld(EntryRecordRepository entryRecordRepository) {
        this.entryRecordRepository = entryRecordRepository;
    }

    public EntryRecord getById(int entryRecordId){
        return this.entryRecordRepository.findById(entryRecordId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Entry Record not found"));
    }

    public List<EntryRecord> getAll() {
        return this.entryRecordRepository.findAll();
    }

    public EntryRecord save(EntryRecord entryRecord) {
        return this.entryRecordRepository.save(entryRecord);
    }

}
