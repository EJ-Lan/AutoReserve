# AutoReserve

AutoReserve is a CLI Project using Java where I make a Backend Application for a Car Booking System

The AutoReserve CLI comes with 6 features:
1️⃣ - Book Car
2️⃣ - View All User Booked Cars
3️⃣ - View All Bookings
4️⃣ - View Available Cars
5️⃣ - View Available Electric Cars
6️⃣ - View all users
7️⃣ - Exit

This project is for me to practice N-tier architecture, Interfaces, Dependency Injection, Lists, Streams, Maven, Tests, and Spring Boot

## N-Tier Architecture
* Created POJO (Plain Old Java Object) classes such as `User.java`, `Car.java`, `CarBooking.java`
* Added business logic in service classes such as `UserService.java`, `CarService.java`, `CarBookingService.java`
* Added DAO (Data Access Object) classes `UserDAO.java`, `CarDAO.java`, `CarBookingDAO.java`
* Organized code into packages `user`, `car`, `booking`, `com.codewithej`

## OOP (Object Oriented Programming)
* Implemented OOP concept interfaces in `UserArrayDataAccessService`

## Dependency Injection
* Implemented dependency injection throughout the codebase

## Lists
* Switched all arrays in program into array lists

## Streams
* Shortened methods in the main class by using streams

## Maven
* Converted the project into a Maven project
* Implemented `java-faker` Maven repository
* Created new `UserFakerDataAccessService` to use `java-faker` dependency

## Tests
* Added JUNIT Jupiter as dependency
* Wrote tests for `car` and `user` service classes

# Spring Boot
TO BE CONTINUED
