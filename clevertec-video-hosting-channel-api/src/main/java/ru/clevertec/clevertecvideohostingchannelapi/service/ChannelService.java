package ru.clevertec.clevertecvideohostingchannelapi.service;

import org.springframework.web.multipart.MultipartFile;
import ru.clevertec.clevertecvideohostingchannelapi.dto.*;

public interface ChannelService {

    ChannelDto saveChannel(CreateChannelDto createChannelDto, MultipartFile avatar);
    ChannelDto updateChannel(UpdateChannelDto updateChannelDto, MultipartFile avatar);
    ChannelDetailsDto getDetailedInformationAboutChannel(Long channelId);
    ChannelPageDto getAllChannelsWithPaginationAndFiltering(FilterChannelDto filterChannelDto, Integer page, Integer size);
}