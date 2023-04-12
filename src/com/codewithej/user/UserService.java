package com.codewithej.user;

public class UserService {

    private final UserArrayDataAccessService userArrayDataAccessService;

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;
    }

    public User[] getUsers() {
        return userArrayDataAccessService.getUsers();
    }
}

