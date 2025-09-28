package com.project.distributed_online_chess;
import com.project.distributed_online_chess.controller.UserController;
import com.project.distributed_online_chess.dao.UserRepository;
import com.project.distributed_online_chess.dto.UserCreateRequest;
import com.project.distributed_online_chess.dto.UserResponse;
import com.project.distributed_online_chess.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@WebMvcTest(UserController.class)
@Import(MongoTestConfig.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateUser_Success() {

        // Arrange
        UserCreateRequest req = new UserCreateRequest("UserOne", "12345", "pic.jpg");

        when(userRepository.existsBySubId("12345")).thenReturn(false);
        when(userRepository.save(any(User.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        UserResponse response = userController.create(req);

        // Assert
        assertNotNull(response);
        assertEquals("UserOne", response.username());
        assertEquals("12345", response.subId());
        assertEquals("pic.jpg", response.profileImage());
        verify(userRepository).save(any(User.class));

    }

    @Test
    public void testCreateUser_NullRequest_ThrowsBadRequest() {
        // Act & Assert
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> {
            userController.create(null);
        });

        assertEquals(400, ex.getStatusCode().value());
    }

    @Test
    public void testCreateUser_AlreadyExists_ThrowsConflict() {
        // Arrange
        UserCreateRequest req = new UserCreateRequest("UserOne", "12345", "pic.jpg");
        when(userRepository.existsBySubId("UserOne")).thenReturn(true);

        // Act & Assert
        ResponseStatusException ex = assertThrows(ResponseStatusException.class, () -> {
            userController.create(req);
        });

        assertEquals(409, ex.getStatusCode().value());
        assertEquals("Account already exists.", ex.getReason());
    }

}
