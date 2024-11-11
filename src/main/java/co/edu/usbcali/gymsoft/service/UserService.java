package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;

import java.util.List;

public interface UserService {

    public List<UserDTO> findAllUsers() throws Exception;

    public UserDTO findUserById(Integer userId) throws Exception;

    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception;

}
