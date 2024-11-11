package co.edu.usbcali.gymsoft.mapper;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDto;

import java.util.List;

public class UserMapper {

    public static UserDto domainToDto(User user) {
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

    public static User dtoToDomain(UserDto userDto) {
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

    public static List<UserDto> domainToDtoList(List<User> users) {
        return users.stream().map(UserMapper::domainToDto).toList();
    }

    public static List<User> dtoToDomainList(List<UserDto> usersDto) {
        return usersDto.stream().map(UserMapper::dtoToDomain).toList();
    }

}
