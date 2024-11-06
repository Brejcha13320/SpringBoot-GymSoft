package co.edu.usbcali.gymsoft.services.old;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserServiceOld {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceOld(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int userId){
        return this.userRepository.findById(userId).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

}
