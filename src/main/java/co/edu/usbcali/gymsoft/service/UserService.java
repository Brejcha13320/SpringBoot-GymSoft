package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateUserRequest;

import java.util.List;

public interface UserService {

    List<UserDTO> findAllUsers() throws Exception;
    UserDTO findUserById(Integer userId) throws Exception;
    UserDTO createUser(CreateUserRequest createUserRequest) throws Exception;
    UserDTO updateUser(Integer userId, UpdateUserRequest updateUserRequest) throws Exception;
    void deleteUser(Integer userId) throws Exception;
}
