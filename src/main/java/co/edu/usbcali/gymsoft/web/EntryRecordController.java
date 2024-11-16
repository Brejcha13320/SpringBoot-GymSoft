package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.EntryRecordDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateEntryRecordRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateEntryRecordRequest;
import co.edu.usbcali.gymsoft.service.EntryRecordService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/entry-record")
@CrossOrigin("*")
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

    @GetMapping(value = "/all")
    public ResponseEntity<List<EntryRecordDTO>> getAllEntryRecords() throws Exception{
        List<EntryRecordDTO> listEntryRecordDTO = entryRecordService.findAllEntryRecord();
        return ResponseEntity.ok(listEntryRecordDTO);
    }

    @GetMapping(value = "/one/{entryRecordId}")
    public ResponseEntity<EntryRecordDTO> getEntryRecord(@PathVariable Integer entryRecordId) throws Exception{
        EntryRecordDTO entryRecordDTO = entryRecordService.findEntryRecordById(entryRecordId);
        return ResponseEntity.ok().body(entryRecordDTO);
    }

    @PutMapping(value = "/update/{entryRecordId}")
    public ResponseEntity<EntryRecordDTO> updateEntryRecord(
            @PathVariable Integer entryRecordId,
            @RequestBody @Valid UpdateEntryRecordRequest updateEntryRecordRequest
    ) throws Exception{
        EntryRecordDTO entryRecordDTO = entryRecordService.updateEntryRecord(entryRecordId, updateEntryRecordRequest);
        return ResponseEntity.ok().body(entryRecordDTO);
    }


    @DeleteMapping(value = "/delete/{entryRecordId}")
    public ResponseEntity<EntryRecordDTO> deleteEntryRecord(
            @PathVariable Integer entryRecordId
    ) throws Exception{
        entryRecordService.deleteEntryRecord(entryRecordId);
        return ResponseEntity.ok().build();
    }




}
