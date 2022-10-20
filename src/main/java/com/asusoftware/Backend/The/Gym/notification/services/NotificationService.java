package com.asusoftware.Backend.The.Gym.notification.services;

import com.asusoftware.Backend.The.Gym.notification.model.Notification;
import com.asusoftware.Backend.The.Gym.notification.model.NotificationDto;
import com.asusoftware.Backend.The.Gym.notification.repository.NotificationRepository;
import com.asusoftware.Backend.The.Gym.user.model.User;
import com.asusoftware.Backend.The.Gym.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final UserService userService;


    @PostConstruct // Execute that function when the application starts
    //           second minute hour day month year
    @Scheduled(cron = "10 * * * * *") // Execute this function every time that in set inside ()
    public void verifyUserExpiredSubscription() {
        // find the users that subscription end tommorow
        LocalDate localDate = LocalDate.now();
        userService.findAllEntities().forEach(user -> {
            LocalDateTime date = user.getSubscription();
            date = date.plusMonths(user.getNumberOfMonthsPayed());
            if(date.getMonthValue() == localDate.getMonthValue() &&
                    date.getYear() == localDate.getYear() &&
                    date.getDayOfMonth() - 1 == localDate.getDayOfMonth()) {
                createNotification(user);
            }
        });
    }

    private void createNotification(User user) {
        Notification notification = new Notification();
        notification.setTitle(user.getFirstName() + ' ' + user.getLastName());
        notification.setDescription("expira abonamentul maine");
        notification.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        notification.setNew(true);
        notification.setUserId(user.getId());
        notificationRepository.save(notification);
    }

    public List<NotificationDto> findAllNotifications() {
        return notificationRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void updateAllNotifications() {
        // TODO: da rivedere
       List<Notification> notifications = notificationRepository.findAll().stream().peek(notification -> notification.setNew(false)).toList();
       notificationRepository.saveAll(notifications);
    }

    public void updateNotification(UUID notificationId) {
        // TODO: da rivedere
        Notification notification = notificationRepository.findById(notificationId).orElse(null);
        if(notification != null) {
            notification.setNew(false);
            notificationRepository.save(notification);
        }
    }

    public void deleteById(UUID notificationId) {
        notificationRepository.deleteById(notificationId);
    }

    public void deleteAll() {
        notificationRepository.deleteAll();
    }

    private NotificationDto toDto(Notification notification) {
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setId(notification.getId());
        notificationDto.setTitle(notification.getTitle());
        notificationDto.setDescription(notification.getDescription());
        notificationDto.setNew(notification.isNew());
        notificationDto.setUserId(notification.getUserId());
        notificationDto.setCreatedAt(notification.getCreatedAt());
        return notificationDto;
    }
}
