package co.edu.usbcali.gymsoft.web;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(this.userService.getAll());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getById(@PathVariable int userId){
        return ResponseEntity.ok(this.userService.getById(userId));
    }

}
