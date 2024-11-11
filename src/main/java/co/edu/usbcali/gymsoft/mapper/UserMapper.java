package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.dto.request.CreateUserRequest;
import co.edu.usbcali.gymsoft.dto.request.UpdateUserRequest;
import co.edu.usbcali.gymsoft.utils.Constants;

import java.util.List;

public class UserMapper {

    public static UserDTO domainToDto(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .enabled(user.getEnabled())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public static User dtoToDomain(UserDTO userDTO){
        return User.builder()
                .userId(userDTO.getUserId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .role(userDTO.getRole())
                .enabled(userDTO.getEnabled())
                .createdAt(userDTO.getCreatedAt())
                .updatedAt(userDTO.getUpdatedAt())
                .build();
    }

    public static List<UserDTO> domainToDtoList(List<User> users){
        return users.stream().map(UserMapper::domainToDto).toList();
    }

    public static List<User> dtoToDomainList(List<UserDTO> usersDTO){
        return usersDTO.stream().map(UserMapper::dtoToDomain).toList();
    }

    public static User createUserRequestToDomain(CreateUserRequest createUserRequest){
        return User.builder()
                .username(createUserRequest.getUsername())
                .password(createUserRequest.getPassword())
                .role(createUserRequest.getRole())
                .enabled(Constants.ENABLE_ACTIVE)
                .build();
    }

    public static User updateUserRequestToDomain(User user, UpdateUserRequest updateUserRequest){
        user.setUsername(updateUserRequest.getUsername());
        user.setPassword(updateUserRequest.getPassword());
        user.setRole(updateUserRequest.getRole());
        return user;
    }

}
