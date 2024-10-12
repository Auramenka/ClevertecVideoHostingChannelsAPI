package ru.clevertec.clevertecvideohostingchannelapi.service;

import ru.clevertec.clevertecvideohostingchannelapi.dto.ChannelTitleDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.CreateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UpdateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(CreateUserDto createUserDto);
    UserDto updateUser(UpdateUserDto updateUserDto);
    void subscribeToChannel(Long userId, Long channelId);
    void unsubscribeFromChannel(Long userId, Long channelId);
    List<ChannelTitleDto> getAllUserSubscriptions(Long id);
}
