package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;
import co.edu.usbcali.gymsoft.repository.EntryRecordRepository;
import co.edu.usbcali.gymsoft.service.EntryRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entry-record")
public class EntryRecordController {

    private final EntryRecordService entryRecordService;

    @Autowired
    public EntryRecordController(EntryRecordService entryRecordService) {
        this.entryRecordService = entryRecordService;
    }

    @PostMapping
    public ResponseEntity<EntryRecordDTO> createEntryRecord(@RequestBody @Valid CreateEntryRecordRequest createEntryRecordRequest) throws Exception{
        EntryRecordDTO entryRecordDTO = entryRecordService.createEntryRecord(createEntryRecordRequest);
        return ResponseEntity.ok().body(entryRecordDTO);
    }

//    @GetMapping
//    public ResponseEntity<List<EntryRecord>> getAll(){
//        return ResponseEntity.ok(this.entryRecordService.getAll());
//    }
//
//    @GetMapping("/{entryRecordId}")
//    public ResponseEntity<EntryRecord> getById(@PathVariable int entryRecordId){
//        return ResponseEntity.ok(this.entryRecordService.getById(entryRecordId));
//    }
//
//    @PostMapping
//    public ResponseEntity<EntryRecord> save(@RequestBody EntryRecord entryRecord){
//        return ResponseEntity.ok(this.entryRecordService.save(entryRecord));
//    }

}
