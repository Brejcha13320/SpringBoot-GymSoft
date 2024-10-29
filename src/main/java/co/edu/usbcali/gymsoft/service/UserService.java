package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    public UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int userId){
        return this.userRepository.getReferenceById(userId);
    }

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User save(User user) {
        return this.userRepository.save(user);
    }

}
