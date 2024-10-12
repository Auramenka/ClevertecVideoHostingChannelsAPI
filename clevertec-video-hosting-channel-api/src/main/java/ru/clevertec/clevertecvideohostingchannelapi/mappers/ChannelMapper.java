package ru.clevertec.clevertecvideohostingchannelapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.clevertec.clevertecvideohostingchannelapi.dto.*;
import ru.clevertec.clevertecvideohostingchannelapi.model.Channel;

@Mapper(componentModel = "spring")
public interface ChannelMapper {

    @Mapping(target = "userDto", source = "channel.subscribers")
    @Mapping(target = "userId", source = "author.id")
    ChannelDto toDto(Channel channel);

    @Mapping(target = "author.id", source = "createChannelDto.userId")
    Channel toEntity(CreateChannelDto createChannelDto);

    @Mapping(target = "userId", source = "author.id")
    @Mapping(target = "subscriberCount", expression = "java(channel.getSubscribers().size())")
    ChannelDetailsDto toDetailedChannelDto(Channel channel);

    @Mapping(target = "subscriberCount", expression = "java(channel.getSubscribers().size())")
    ChannelSummaryDto toSummaryChannelDto(Channel channel);
}