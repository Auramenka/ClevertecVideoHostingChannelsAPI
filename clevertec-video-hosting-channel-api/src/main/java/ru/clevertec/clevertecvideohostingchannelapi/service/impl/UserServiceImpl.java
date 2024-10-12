package ru.clevertec.clevertecvideohostingchannelapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.clevertecvideohostingchannelapi.dto.ChannelTitleDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.CreateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UpdateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UserDto;
import ru.clevertec.clevertecvideohostingchannelapi.exception.NotExistsException;
import ru.clevertec.clevertecvideohostingchannelapi.mappers.UserMapper;
import ru.clevertec.clevertecvideohostingchannelapi.model.Channel;
import ru.clevertec.clevertecvideohostingchannelapi.model.User;
import ru.clevertec.clevertecvideohostingchannelapi.repository.ChannelRepository;
import ru.clevertec.clevertecvideohostingchannelapi.repository.UserRepository;
import ru.clevertec.clevertecvideohostingchannelapi.service.UserService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto saveUser(CreateUserDto createUserDto) {
        if (createUserDto == null) {
            throw new NotExistsException("CreateUserDto is empty");
        }
        return userMapper.toDto(userRepository.save(userMapper.toEntity(createUserDto)));
    }

    @Override
    public UserDto updateUser(UpdateUserDto updateUserDto) {
        if (updateUserDto == null) {
            throw new NotExistsException("CreateUserDto is empty");
        }
        User userFromDB = getUserFromDB(updateUserDto.getId());
        userFromDB.setNickname(updateUserDto.getNickname());
        userFromDB.setName(updateUserDto.getName());
        userFromDB.setEmail(updateUserDto.getEmail());
        return userMapper.toDto(userRepository.save(userFromDB));
    }

    @Override
    public void subscribeToChannel(Long userId, Long channelId) {
        User userFromDB = getUserFromDB(userId);
        Channel channelFromDB = getChannelFromDB(channelId);

        userFromDB.getSubscriptions().add(channelFromDB);
        userRepository.save(userFromDB);
    }

    @Override
    public void unsubscribeFromChannel(Long userId, Long channelId) {
        User userFromDB = getUserFromDB(userId);
        Channel channelFromDB = getChannelFromDB(channelId);

        userFromDB.getSubscriptions().remove(channelFromDB);
        userRepository.save(userFromDB);
    }

    @Override
    public List<ChannelTitleDto> getAllUserSubscriptions(Long id) {
        return userRepository.findById(id)
                  .map(user -> user.getSubscriptions()
                  .stream().map(channel -> new ChannelTitleDto(channel.getId(), channel.getName()))
                  .collect(Collectors.toList())).orElseGet(Collections::emptyList);
    }

    private User getUserFromDB(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotExistsException("User doesn't exist"));
    }

    private Channel getChannelFromDB(Long id) {
        return channelRepository.findById(id).orElseThrow(() -> new NotExistsException("Channel doesn't exist"));
    }
}
