package com.asusoftware.Backend.The.Gym.user.services;

import com.asusoftware.Backend.The.Gym.user.model.CreateUserDto;
import com.asusoftware.Backend.The.Gym.user.model.User;
import com.asusoftware.Backend.The.Gym.user.model.UserDto;
import com.asusoftware.Backend.The.Gym.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void create(CreateUserDto createUserDto) {
        User user = new User();
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setBirthday(createUserDto.getBirthday());
        user.setPhoneNumber(createUserDto.getPhoneNumber());
        user.setSubscription(LocalDateTime.now(ZoneOffset.UTC));
        user.setProfileImageId(UUID.randomUUID());
        user.setNumberOfMonthsPayed(createUserDto.getNumberOfMonthsPayed());
        userRepository.save(user);
    }

    public void edit(UserDto userDto, Boolean isNewSubscription) {

    }

    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> findAllEntities() {
        return userRepository.findAll();
    }

    public void remove(List<UUID> userIds) {
        userRepository.deleteAllById(userIds);
    }

    private User toEntity(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setBirthday(userDto.getBirthday());
        user.setPhoneNumber(userDto.getPhoneNumber());
        user.setSubscription(LocalDateTime.now(ZoneOffset.UTC));
        user.setProfileImageId(userDto.getProfileImageId());
        user.setNumberOfMonthsPayed(userDto.getNumberOfMonthsPayed());
        return user;
    }

    private UserDto toDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setBirthday(user.getBirthday());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setSubscription(user.getSubscription());
        userDto.setProfileImageId(user.getProfileImageId());
        userDto.setNumberOfMonthsPayed(user.getNumberOfMonthsPayed());
        return userDto;
    }
}
