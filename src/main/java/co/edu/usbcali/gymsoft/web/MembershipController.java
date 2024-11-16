package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.MembershipDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateMembershipRequest;
import co.edu.usbcali.gymsoft.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/membership")
@CrossOrigin("*")
public class MembershipController {

    private final MembershipService membershipService;

    @Autowired
    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<MembershipDTO>> getAllMemberships() throws Exception {
        List<MembershipDTO> listMembershipDTO = membershipService.getAllMemberships();
        return ResponseEntity.ok(listMembershipDTO);
    }

    @GetMapping(value = "/one/{membershipId}")
    public ResponseEntity<MembershipDTO> getMembershipById(@PathVariable Integer membershipId) throws Exception {
        MembershipDTO membershipDTO = membershipService.getMembershipById(membershipId);
        return ResponseEntity.ok(membershipDTO);
    }

    @PostMapping
    public ResponseEntity<MembershipDTO> createMembership(@RequestBody @Valid CreateMembershipRequest createMembeshipRequest) throws Exception {
        MembershipDTO membershipDTO = membershipService.createMembership(createMembeshipRequest);
        return ResponseEntity.ok().body(membershipDTO);
    }

    @DeleteMapping(value = "/delete/{membershipId}")
    public ResponseEntity<Void> deleteMembership(@PathVariable Integer membershipId) throws Exception {
        membershipService.deleteMembership(membershipId);
        return ResponseEntity.noContent().build();
    }

}
