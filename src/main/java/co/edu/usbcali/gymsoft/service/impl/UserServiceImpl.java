package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.mapper.UserMapper;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.UserService;
import co.edu.usbcali.gymsoft.utils.validation.UserMessage;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception {

        //Validar si ya existe un usuario con ese username
        Boolean existsByUsername = userRepository.existsByUsername(createUserRequest.getUsername());
        if (existsByUsername) {
            throw new Exception(String.format(UserMessage.EXISTS_BY_USERNAME, createUserRequest.getUsername()));
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.domainToDto(user);
        return userDTO;
    }
}
