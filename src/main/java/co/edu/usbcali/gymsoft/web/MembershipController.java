package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembeshipRequest;
import co.edu.usbcali.gymsoft.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PostMapping
    public ResponseEntity<MembershipDTO> createMembership(@RequestBody @Valid CreateMembeshipRequest createMembeshipRequest) throws Exception {
        MembershipDTO membershipDTO = membershipService.createMembership(createMembeshipRequest);
        return ResponseEntity.ok().body(membershipDTO);
    }

//    @GetMapping
//    public ResponseEntity<List<Membership>> getAll(){
//        return ResponseEntity.ok(this.membershipService.getAll());
//    }
//
//    @GetMapping("/{membershipId}")
//    public ResponseEntity<Membership> getById(@PathVariable int membershipId){
//        return ResponseEntity.ok(this.membershipService.getById(membershipId));
//    }
//
//    @PostMapping
//    public ResponseEntity<Membership> save(@RequestBody Membership membership){
//        return ResponseEntity.ok(this.membershipService.save(membership));
//    }

}
