package ru.clevertec.clevertecvideohostingchannelapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clevertec.clevertecvideohostingchannelapi.dto.CreateUserDto;
import ru.clevertec.clevertecvideohostingchannelapi.dto.UserDto;
import ru.clevertec.clevertecvideohostingchannelapi.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "channelDto", source = "user.subscriptions")
    UserDto toDto(User user);

    User toEntity(CreateUserDto createUserDto);
}