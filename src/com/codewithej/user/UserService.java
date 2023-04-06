package com.codewithej.user;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        this.userDAO = new UserDAO();
    }

    public User[] getUsers() {
        return userDAO.getUsers();
    }
}

