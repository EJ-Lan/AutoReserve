package com.codewithej.user;

public class UserService {

    private UserArrayDataAccessService userDAO;

    public UserService() {
        this.userDAO = new UserArrayDataAccessService();
    }

    public User[] getUsers() {
        return userDAO.getUsers();
    }
}

