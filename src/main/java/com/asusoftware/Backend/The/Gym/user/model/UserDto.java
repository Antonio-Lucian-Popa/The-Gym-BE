package com.asusoftware.Backend.The.Gym.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class UserDto {

    private UUID id;
    private UUID profileImageId; // il generam automat in momentul inregistrarii, dupa care la poza ii bagam acel id
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private LocalDateTime subscription;
    private int numberOfMonthsPayed;

}
