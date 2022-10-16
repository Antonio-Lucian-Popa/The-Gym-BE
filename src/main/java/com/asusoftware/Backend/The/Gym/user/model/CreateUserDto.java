package com.asusoftware.Backend.The.Gym.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserDto {

    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String email;
    private String phoneNumber;
    private LocalDate subscription;
    private int numberOfMonthsPayed;
}
