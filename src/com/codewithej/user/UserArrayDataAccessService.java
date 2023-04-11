package com.codewithej.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayDataAccessService implements UserDao {

    @Override
    public User[] getUsers() {
        User[] users = new User[100];

        String path = "src/com/codewithej/users.csv";

        File file;
        try {
            file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new IllegalStateException(e);
        }
        Scanner scanner;
        try {
            scanner = new Scanner(file);
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                UUID id = UUID.fromString(fields[0]);
                String name = fields[1];
                users[i++] = new User(name, id); // add the user to the array
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}

