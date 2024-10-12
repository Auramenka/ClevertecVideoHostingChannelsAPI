package ru.clevertec.clevertecvideohostingchannelapi.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.clevertec.clevertecvideohostingchannelapi.builder.IFilterChannelPredicateBuilder;
import ru.clevertec.clevertecvideohostingchannelapi.dto.*;
import ru.clevertec.clevertecvideohostingchannelapi.exception.AvatarException;
import ru.clevertec.clevertecvideohostingchannelapi.exception.NotExistsException;
import ru.clevertec.clevertecvideohostingchannelapi.mappers.ChannelMapper;
import ru.clevertec.clevertecvideohostingchannelapi.model.Channel;
import ru.clevertec.clevertecvideohostingchannelapi.repository.ChannelRepository;
import ru.clevertec.clevertecvideohostingchannelapi.repository.FilterChannelRepository;
import ru.clevertec.clevertecvideohostingchannelapi.service.ChannelService;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository channelRepository;
    private final ChannelMapper channelMapper;
    private final FilterChannelRepository filterChannelRepository;
    private final List<IFilterChannelPredicateBuilder> list;

    @Override
    public ChannelDto saveChannel(CreateChannelDto createChannelDto, MultipartFile avatar) {
        if (createChannelDto == null) {
            throw new NotExistsException("CreateChannelDto is empty");
        }

        Optional<MultipartFile> optionalAvatar = Optional.ofNullable(avatar);
        setAvatar(optionalAvatar, createChannelDto::setAvatar);

        return channelMapper.toDto(channelRepository.save(channelMapper.toEntity(createChannelDto)));
    }

    @Override
    public ChannelDto updateChannel(UpdateChannelDto updateChannelDto, MultipartFile avatar) {
        if (updateChannelDto == null) {
            throw new NotExistsException("UpdateChannelDto is empty");
        }

        Channel channelFromDB = channelRepository.findById(updateChannelDto.getId()).orElseThrow(() -> new NotExistsException("Channel doesn't exist"));;
        channelFromDB.setName(updateChannelDto.getName());
        channelFromDB.setDescription(updateChannelDto.getDescription());
        channelFromDB.setLanguage(updateChannelDto.getLanguage());

        Optional<MultipartFile> optionalAvatar = Optional.ofNullable(avatar);
        setAvatar(optionalAvatar, channelFromDB::setAvatar);

        channelFromDB.setCategory(updateChannelDto.getCategory());
        return channelMapper.toDto(channelRepository.save(channelFromDB));
    }

    @Override
    public ChannelDetailsDto getDetailedInformationAboutChannel(Long channelId) {
        return channelRepository.findById(channelId).map(channelMapper::toDetailedChannelDto)
                         .orElseThrow(() -> new NotExistsException("Channel doesn't exist"));
    }

    @Override
    public ChannelPageDto getAllChannelsWithPaginationAndFiltering(FilterChannelDto filterChannelDto, Integer page, Integer size) {
        if (filterChannelDto == null) {
            throw new NotExistsException("FilterChannelDto is empty");
        }

        Specification<Channel> specificationByParameter = getSpecificationByParameters(filterChannelDto);
        Page<Channel> channelPage = filterChannelRepository.findAll(specificationByParameter, PageRequest.of(page, size));
        List<ChannelSummaryDto> channels = channelPage.getContent().stream().map(channelMapper::toSummaryChannelDto).collect(Collectors.toList());
        return new ChannelPageDto(channels, channelPage.getTotalElements(), channelPage.getTotalPages());
    }

    private Specification<Channel> getSpecificationByParameters(FilterChannelDto filterChannelDto) {
        return (root, query, criteriaBuilder) -> list.stream()
                .map(iFilterChannelPredicateBuilder ->
                        iFilterChannelPredicateBuilder.build(root, criteriaBuilder, filterChannelDto))
                .filter(Objects::nonNull)
                .reduce(criteriaBuilder::and).orElse(null);
    }

    private void setAvatar(Optional<MultipartFile> optionalAvatar, Consumer<byte[]> setAvatarFunction) {
        optionalAvatar.ifPresent(a -> {
            try {
                setAvatarFunction.accept(a.getBytes());
            } catch (IOException e) {
                throw new AvatarException("Error while setting avatar");
            }
        });
    }
}
