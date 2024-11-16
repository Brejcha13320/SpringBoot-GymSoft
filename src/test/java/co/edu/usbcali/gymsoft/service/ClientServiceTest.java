package co.edu.usbcali.gymsoft.service;

import co.edu.usbcali.gymsoft.domain.Client;
import co.edu.usbcali.gymsoft.domain.User;
import co.edu.usbcali.gymsoft.dto.ClientDTO;
import co.edu.usbcali.gymsoft.dto.UserDTO;
import co.edu.usbcali.gymsoft.repository.ClientRepository;
import co.edu.usbcali.gymsoft.service.impl.ClientServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    Client mockClient = new Client();
    List<Client> mockClients = new ArrayList<>();

    private void setMockClient(){
        mockClient = Client.builder()
                .clientId(1)
                .firstName("jesus")
                .lastName("mejia")
                .address("calle 17")
                .email("jesus@gmail.com")
                .phone("3140000000")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();
    }

    private void setMockClients(){
        Client client1 = Client.builder()
                .clientId(1)
                .firstName("jesus")
                .lastName("mejia")
                .address("calle 17")
                .email("jesus@gmail.com")
                .phone("3140000000")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        Client client2 = Client.builder()
                .clientId(2)
                .firstName("david")
                .lastName("vergara")
                .address("calle 17")
                .email("david@gmail.com")
                .phone("3150000000")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        Client client3 = Client.builder()
                .clientId(1)
                .firstName("cristian")
                .lastName("fajardo")
                .address("calle 33")
                .email("cristian@gmail.com")
                .phone("3160000000")
                .enabled(true)
                .createdAt(null)
                .updatedAt(null)
                .build();

        mockClients.add(client1);
        mockClients.add(client2);
        mockClients.add(client3);
    }

    @BeforeEach
    void setUp(){
        this.setMockClient();
        this.setMockClients();
    }

    @Test
    void testFindAllClients() throws Exception {
        //Arrange
        this.setMockClients();
        when(clientRepository.findAll()).thenReturn(mockClients);

        //Act
        List<ClientDTO> result = clientService.getAllClients();

        //Assert
        assertNotNull(result);
        verify(clientRepository, times(1)).findAll();
        assertEquals(mockClients.size(), result.size());
    }

    @Test
    void testFindClientById() throws Exception {
        //Arrange
        this.setMockClient();
        when(clientRepository.findById(mockClient.getClientId())).thenReturn(Optional.ofNullable(mockClient));

        //Act
        ClientDTO result = clientService.getClientById(mockClient.getClientId());

        //Assert
        assertNotNull(result);
        verify(clientRepository, times(1)).findById(mockClient.getClientId());
        assertEquals(mockClient.getClientId(), result.getClientId());
        assertEquals(mockClient.getFirstName(), result.getFirstName());
        assertEquals(mockClient.getLastName(), result.getLastName());
        assertEquals(mockClient.getAddress(), result.getAddress());
        assertEquals(mockClient.getEmail(), result.getEmail());
        assertEquals(mockClient.getPhone(), result.getPhone());
        assertEquals(mockClient.getEnabled(), result.getEnabled());
    }

}
