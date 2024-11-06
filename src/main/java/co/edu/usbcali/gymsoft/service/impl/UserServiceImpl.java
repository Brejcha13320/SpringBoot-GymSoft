package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.mapper.UserMapper;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception {
        //Validar que el username no sea null
        if(createUserRequest.getUsername() == null || createUserRequest.getUsername().equals("")){
            throw new Exception("El username es obligatorio");
        }

        //Validar que el password no sea null
        if(createUserRequest.getPassword() == null || createUserRequest.getPassword().equals("")){
            throw new Exception("El username es obligatorio");
        }

        //Validar que el role no sea null
        if(createUserRequest.getRole() == null || createUserRequest.getRole().equals("")){
            throw new Exception("El role es obligatorio");
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.domainToDto(user);
        return userDTO;
    }
}
