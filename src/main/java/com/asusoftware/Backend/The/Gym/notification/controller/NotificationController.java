package com.asusoftware.Backend.The.Gym.notification.controller;

import com.asusoftware.Backend.The.Gym.notification.model.NotificationDto;
import com.asusoftware.Backend.The.Gym.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @PutMapping(path = "/updateAll")
    public void update() {
        notificationService.updateAllNotifications();
    }

    @PutMapping(path = "/update/{id}")
    public void update(@PathVariable(name = "id") UUID id) {
        notificationService.updateNotification(id);
    }

    @GetMapping(path = "/findAll")
    public List<NotificationDto> findAll() {
       return notificationService.findAllNotifications();
    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable(name = "id") UUID id) {
        notificationService.deleteById(id);
    }


    @DeleteMapping(path = "/deleteAll")
    public void deleteAll() {
        notificationService.deleteAll();
    }
}
