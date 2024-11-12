package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateUserRequest;
import co.edu.usbcali.gymsoft.service.UserService;
import jakarta.validation.Valid;
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

    @PutMapping(value = "/update/{userId}")
    public ResponseEntity<UserDTO> updateUser(
            @PathVariable Integer userId,
            @RequestBody @Valid UpdateUserRequest updateUserRequest) throws Exception {
        UserDTO userDTO = userService.updateUser(userId, updateUserRequest);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping(value = "/delete/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) throws Exception {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}
