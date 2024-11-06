package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;

public interface UserService {

    public UserDTO createUser(CreateUserRequest createUserRequest) throws Exception;



}
