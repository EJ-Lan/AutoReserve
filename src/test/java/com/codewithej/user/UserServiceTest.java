package com.codewithej.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UserServiceTest {

    private UserDao userDao;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userDao = new DummyUserDao(); // Use a dummy implementation of UserDao for testing
        userService = new UserService(userDao);
    }

    @Test
    void getUserById_WhenUserDoesNotExist_ShouldReturnNull() {
        List<User> users = createDummyUserList();
        UUID nonExistingUserId = UUID.randomUUID();

        User actualUser = userService.getUserById(nonExistingUserId);

        assertNull(actualUser);
    }

    private static List<User> createDummyUserList() {
        List<User> users = new ArrayList<>();
        users.add(new User(UUID.randomUUID(), "John Doe"));
        users.add(new User(UUID.randomUUID(), "Jane Smith"));
        return users;
    }

    // Dummy implementation of UserDao for testing purposes
    private static class DummyUserDao implements UserDao {
        private final List<User> users;

        public DummyUserDao() {
            users = createDummyUserList();
        }

        @Override
        public List<User> getUsers() {
            return users;
        }
    }
}
