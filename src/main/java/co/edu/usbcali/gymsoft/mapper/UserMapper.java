package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDto;

public class UserMapper {

    public UserDto domainToDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .enabled(user.getEnabled())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public User dtoToDomain(UserDto userDto) {
        return User.builder()
                .userId(userDto.getUserId())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .role(userDto.getRole())
                .enabled(userDto.getEnabled())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .build();
    }

}
