package com.project.distributed_online_chess;
import com.project.distributed_online_chess.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerTestJwt {

    @Mock
    private Jwt jwt;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetCurrentUserId_ValidJwt() {

        // Arrange
        when(authentication.getPrincipal()).thenReturn(jwt);
        when(jwt.getSubject()).thenReturn("12345");

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        String userId = userService.getCurrentUserId();

        // Assert
        assertNotNull(userId);
        assertEquals("12345", userId);
    }

    @Test
    void testGetCurrentUserId_InvalidJwt() {

        // Arrange
        when(authentication.getPrincipal()).thenReturn(jwt);
        when(jwt.getSubject()).thenReturn(null);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Act
        String userId = userService.getCurrentUserId();

        // Assert
        assertNull(userId);
    }

    @Test
    void testGetCurrentUserId_NoAuthentication() {

        // Arrange
        SecurityContextHolder.getContext().setAuthentication(null);

        // Act
        String actualUserId = userService.getCurrentUserId();

        // Assert
        assertNull(actualUserId);
    }
}
