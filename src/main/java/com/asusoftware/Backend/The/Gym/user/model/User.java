package com.asusoftware.Backend.The.Gym.user.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "profile_image_id", nullable = false)
    private UUID profileImageId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "birthday", nullable = true)
    private LocalDate birthday;

    @Email
    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    // Asta e pentru a seta abonamentul la user
    @Column(name = "subscription", nullable = false)
    private LocalDateTime subscription;

    @Column(name = "number_of_months_payed", nullable = false)
    private int numberOfMonthsPayed;
}
