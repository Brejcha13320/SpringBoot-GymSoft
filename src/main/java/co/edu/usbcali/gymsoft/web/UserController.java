package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.mapper.UserMapper;
import co.edu.usbcali.gymsoft.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws Exception {
        List<UserDTO> usersDTO = userService.findAllUsers();
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping(value = "/one/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) throws Exception {
        UserDTO userDTO = userService.findUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) throws Exception {
        UserDTO userDTO = userService.createUser(createUserRequest);
        return ResponseEntity.ok(userDTO);
    }

}
