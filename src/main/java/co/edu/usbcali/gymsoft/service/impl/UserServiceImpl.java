package co.edu.usbcali.gymsoft.service.impl;

import co.edu.usbcali.gymsoft.domain.ClientMembership;
import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.ClientMembershipDTO;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateUserRequest;
import co.edu.usbcali.gymsoft.mapper.ClientMembershipMapper;
import co.edu.usbcali.gymsoft.mapper.UserMapper;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.UserService;
import co.edu.usbcali.gymsoft.utils.validation.UserMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserDTO> findAllUsers() throws Exception {
        List<User> users = userRepository.findAll();
        return UserMapper.domainToDtoList(users);
    }

    @Override
    public UserDTO findUserById(Integer userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new Exception(String.format(UserMessage.NOT_EXISTS_BY_USER_ID, userId))
        );

        return UserMapper.domainToDto(user);
    }

    @Override
    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception {

        //Validar si ya existe un usuario con ese username
        Boolean existsByUsername = userRepository.existsByUsername(createUserRequest.getUsername());
        if (existsByUsername) {
            throw new Exception(String.format(UserMessage.EXISTS_BY_USERNAME, createUserRequest.getUsername()));
        }

        User user = UserMapper.createUserRequestToDomain(createUserRequest);
        user.setEnabled(true);
        user = userRepository.save(user);
        UserDTO userDTO = UserMapper.domainToDto(user);
        return userDTO;
    }

    @Override
    public UserDTO updateUser(Integer userId, UpdateUserRequest updateUserRequest) throws Exception {
        UserDTO userDTO = findUserById(userId);
        User user = UserMapper.dtoToDomain(userDTO);
        user = UserMapper.updateUserRequestToDomain(user, updateUserRequest);

        user.setEnabled(updateUserRequest.getEnabled());
        user = userRepository.save(user);
        return UserMapper.domainToDto(user);
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
        UserDTO userDTO = findUserById(userId);
        User user = UserMapper.dtoToDomain(userDTO);
        userRepository.delete(user);
    }

}
