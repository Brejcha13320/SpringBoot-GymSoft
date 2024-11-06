package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.Membership;
import co.edu.usbcali.gymsoft.services.old.MembershipServiceOld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/membership")
public class MembershipController {

    private final MembershipServiceOld membershipService;

    @Autowired
    public MembershipController(MembershipServiceOld membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping
    public ResponseEntity<List<Membership>> getAll(){
        return ResponseEntity.ok(this.membershipService.getAll());
    }

    @GetMapping("/{membershipId}")
    public ResponseEntity<Membership> getById(@PathVariable int membershipId){
        return ResponseEntity.ok(this.membershipService.getById(membershipId));
    }

    @PostMapping
    public ResponseEntity<Membership> save(@RequestBody Membership membership){
        return ResponseEntity.ok(this.membershipService.save(membership));
    }

}
