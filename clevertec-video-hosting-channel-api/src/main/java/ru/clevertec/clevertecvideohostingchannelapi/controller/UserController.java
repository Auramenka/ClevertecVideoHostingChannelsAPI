package ru.clevertec.clevertecvideohostingchannelapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.clevertec.clevertecvideohostingchannelapi.dto.ChannelTitleDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.CreateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UpdateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UserDto;
import ru.clevertec.clevertecvideohostingchannelapi.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return new ResponseEntity<>(userService.saveUser(createUserDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<UserDto> updateUser(@RequestBody UpdateUserDto updateUserDto) {
        return new ResponseEntity<>(userService.updateUser(updateUserDto), HttpStatus.OK);
    }

    @PostMapping("/{userId}/{channelId}/subscription")
    public ResponseEntity<String> subscribeToChannel(@PathVariable("userId") Long userId,
                                                     @PathVariable("channelId") Long channelId) {
        userService.subscribeToChannel(userId, channelId);
        return new ResponseEntity<>("Subscribed to channel", HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/{channelId}/unsubscription")
    public ResponseEntity<String> unsubscribeFromChannel(@PathVariable("userId") Long userId,
                                                         @PathVariable("channelId") Long channelId) {
        userService.unsubscribeFromChannel(userId, channelId);
        return new ResponseEntity<>("Unsubscribed from channel", HttpStatus.OK);
    }

    @GetMapping("/{id}/subscriptions")
    public ResponseEntity<List<ChannelTitleDto>> getAllUserSubscriptions(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getAllUserSubscriptions(id), HttpStatus.OK);
    }
}
