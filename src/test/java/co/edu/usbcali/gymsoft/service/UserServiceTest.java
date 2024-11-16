package co.edu.usbcali.gymsoft.service;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.repository.UserRepository;
import co.edu.usbcali.gymsoft.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    User mockUser = new User();
    List<User> mockUsers = new ArrayList<>();

    private void setMockUser(){
        mockUser = User.builder()
                .userId(1)
                .username("jesus123")
                .password("jesus123")
                .role("nose")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();
    }

    private void setMockUsers(){
        User user1 = User.builder()
                .userId(1)
                .username("jesus123")
                .password("jesus123")
                .role("nose")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        User user2 = User.builder()
                .userId(3)
                .username("jose123")
                .password("jose123")
                .role("nose")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        User user3 = User.builder()
                .userId(4)
                .username("luis123")
                .password("luis123")
                .role("nose")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        mockUsers.add(user1);
        mockUsers.add(user2);
        mockUsers.add(user3);
    }

    @BeforeEach
    void setUp(){
        this.setMockUser();
        this.setMockUsers();
    }

    @Test
    void testFindAllUsers() throws Exception {
        //Arrange
        this.setMockUsers();
        when(userRepository.findAll()).thenReturn(mockUsers);

        //Act
        List<UserDTO> result = userService.findAllUsers();

        //Assert
        assertNotNull(result);
        verify(userRepository, times(1)).findAll();
        assertEquals(mockUsers.size(), result.size());
    }

    @Test
    void testFindUserById() throws Exception {
        //Arrange
        this.setMockUser();
        when(userRepository.findById(mockUser.getUserId())).thenReturn(Optional.ofNullable(mockUser));

        //Act
        UserDTO result = userService.findUserById(mockUser.getUserId());

        //Assert
        assertNotNull(result);
        verify(userRepository, times(1)).findById(mockUser.getUserId());
        assertEquals(mockUser.getUserId(), result.getUserId());
        assertEquals(mockUser.getUsername(), result.getUsername());
        assertEquals(mockUser.getPassword(), result.getPassword());
        assertEquals(mockUser.getRole(), result.getRole());
        assertEquals(mockUser.getEnabled(), result.getEnabled());
    }

}
