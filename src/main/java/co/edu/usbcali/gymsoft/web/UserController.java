package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping
//    public ResponseEntity<List<User>> getAll(){
//        return ResponseEntity.ok(this.userService.getAll());
//    }
//
//    @GetMapping("/{userId}")
//    public ResponseEntity<User> getById(@PathVariable int userId){
//        return ResponseEntity.ok(this.userService.getById(userId));
//    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
        UserDTO userDTO = userService.createUser(createUserRequest);
        return ResponseEntity.ok(userDTO);
    }

}
