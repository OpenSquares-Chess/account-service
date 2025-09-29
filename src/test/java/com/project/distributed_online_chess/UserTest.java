package com.project.distributed_online_chess;
import com.project.distributed_online_chess.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("12345", "username", "pic.jpg", "subId12345");
    }

    @Test
    public void testConstructorAndGetters() {

        // Arrange
        // Done above


        // Act
        String id = user.getId();
        String username = user.getUsername();
        String profileImage = user.getProfileImage();
        String subId = user.getSubId();

        // Assert
        assertEquals("12345", id);
        assertEquals("username", username);
        assertEquals("pic.jpg", profileImage);
        assertEquals("subId12345", subId);
    }

    @Test
    public void testSetters() {

        // Arrange
        user.setId("12345");
        user.setUsername("username");
        user.setProfileImage("pic.jpg");
        user.setSubId("subId12345");

        // Act
        user.setId("12345");
        user.setUsername("username");
        user.setProfileImage("pic.jpg");
        user.setSubId("subId12345");

        // Assert
        assertEquals("12345", user.getId());
        assertEquals("username", user.getUsername());
        assertEquals("pic.jpg", user.getProfileImage());
        assertEquals("subId12345", user.getSubId());
    }

    @Test
    public void testSetId() {

        // Arrange
        String newId = "12345";

        // Act
        user.setId(newId);

        // Assert
        assertEquals(newId, user.getId());
    }

    @Test
    public void testSetUsername() {

        // Arrange
        String newUsername = "username";

        // Act
        user.setUsername(newUsername);

        // Assert
        assertEquals(newUsername, user.getUsername());
    }

    @Test
    public void testSetProfileImage() {

        // Arrange
        String newProfileImage = "pic.jpg";

        // Act
        user.setProfileImage(newProfileImage);

        // Assert
        assertEquals(newProfileImage, user.getProfileImage());
    }

    @Test
    public void testSetSubId() {

        // Arrange
        String newSubId = "12345";

        // Act
        user.setSubId(newSubId);

        // Assert
        assertEquals(newSubId, user.getSubId());
    }
}