package com.asusoftware.Backend.The.Gym.user.controller;

import com.asusoftware.Backend.The.Gym.user.model.CreateUserDto;
import com.asusoftware.Backend.The.Gym.user.model.UserDto;
import com.asusoftware.Backend.The.Gym.user.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping(path = "/create")
    public void create(@RequestBody CreateUserDto createUserDto) {
        userService.create(createUserDto);
    }

    @PutMapping(path = "/edit")
    public void remove(@RequestBody UserDto userDto, @RequestParam(name = "isNewSubscription") Optional<Boolean> isNewSubscription) {
        System.out.println(isNewSubscription);
        userService.edit(userDto, isNewSubscription);
    }

    @GetMapping(path = "/findAll")
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @PutMapping(path = "/remove")
    public void remove(@RequestBody List<UUID> userIds) {
        userService.remove(userIds);
    }
}
