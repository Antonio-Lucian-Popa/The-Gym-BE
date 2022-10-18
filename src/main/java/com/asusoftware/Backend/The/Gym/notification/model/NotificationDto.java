package com.asusoftware.Backend.The.Gym.notification.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class NotificationDto {

    private UUID id;
    private String title;
    private String description;
    private boolean isNew;
    private LocalDateTime createdAt;
    private UUID userId;
}
