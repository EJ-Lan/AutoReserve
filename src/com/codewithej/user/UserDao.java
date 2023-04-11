package com.codewithej.user;

import java.io.FileNotFoundException;

public interface UserDao {
    User[] getUsers() throws FileNotFoundException;
}
