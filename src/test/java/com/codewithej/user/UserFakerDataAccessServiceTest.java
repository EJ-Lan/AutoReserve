package com.codewithej.user;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFakerDataAccessServiceTest {

    @Test
    void createsTwentyUsers() {
        UserFakerDataAccessService underTest = new UserFakerDataAccessService();
        List<User> testUser = underTest.getUsers();
        var listSize = testUser.size();
        var result = 20;
        assertEquals(result, listSize);
    }
}
