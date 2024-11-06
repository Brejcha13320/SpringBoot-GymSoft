package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.EntryRecord;
import co.edu.usbcali.gymsoft.services.old.EntryRecordServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entryRecord")
public class EntryRecordController {

    private final EntryRecordServiceOld entryRecordService;

    @Autowired
    public EntryRecordController(EntryRecordServiceOld entryRecordService) {
        this.entryRecordService = entryRecordService;
    }

    @GetMapping
    public ResponseEntity<List<EntryRecord>> getAll(){
        return ResponseEntity.ok(this.entryRecordService.getAll());
    }

    @GetMapping("/{entryRecordId}")
    public ResponseEntity<EntryRecord> getById(@PathVariable int entryRecordId){
        return ResponseEntity.ok(this.entryRecordService.getById(entryRecordId));
    }

    @PostMapping
    public ResponseEntity<EntryRecord> save(@RequestBody EntryRecord entryRecord){
        return ResponseEntity.ok(this.entryRecordService.save(entryRecord));
    }

}
