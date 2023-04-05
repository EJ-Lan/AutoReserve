package com.codewithej;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        displayMenu();
        System.out.println();

        int input = Integer.valueOf(scanner.nextLine());
        cliAction(input);

    }

    private static void cliAction(int input) {
        while (input != 7) {
            switch (input) {
                case 1:
                    // Book Car
                    break;
                case 2:
                    // View All User Booked Cars
                    break;
                case 3:
                    // View All Bookings
                    break;
                case 4:
                    // View Available Cars
                    break;
                case 5:
                    // View Available Electric Cars
                    break;
                case 6:
                    // View all users
                    break;
                case 7:
                    // Exit
                    break;
                default:
                    System.out.println(input + " not a valid option");
            }

            if (input != 7) {
                System.out.println();
                displayMenu();
                System.out.println();
            }

            Scanner scanner = new Scanner(System.in);
            input = Integer.valueOf(scanner.nextLine());
        }
    }

    private static void displayMenu() {
        System.out.println("1 - Book Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View All Users");
        System.out.println("7 - Exit");
    }
}