package ru.clevertec.clevertecvideohostingchannelapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.clevertec.clevertecvideohostingchannelapi.dto.*;
import ru.clevertec.clevertecvideohostingchannelapi.service.ChannelService;

@RestController
@RequestMapping("/api/channels")
@RequiredArgsConstructor
public class ChannelController {

    private final ChannelService channelService;

    @PostMapping
    public ResponseEntity<ChannelDto> createChannel(@RequestPart("channel") CreateChannelDto createChannelDto,
                                                    @RequestPart("file") MultipartFile avatar) {
        return new ResponseEntity<>(channelService.saveChannel(createChannelDto, avatar), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ChannelDto> updateChannel(@RequestPart("channel") UpdateChannelDto updateChannelDto,
                                                    @RequestPart("file") MultipartFile avatar) {
        return new ResponseEntity<>(channelService.updateChannel(updateChannelDto, avatar), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ChannelPageDto> getAllFilterChannels(
            @RequestBody FilterChannelDto filterChannelDto,
            @RequestParam(defaultValue = "0", value = "page") Integer page,
            @RequestParam(defaultValue = "10", value = "size") Integer size
    ) {
        return new ResponseEntity<>(channelService.getAllChannelsWithPaginationAndFiltering(filterChannelDto, page, size), HttpStatus.OK);
    }

    @GetMapping("/{channelId}")
    public ResponseEntity<ChannelDetailsDto> getDetailedInformationAboutChannel(@PathVariable("channelId") Long channelId) {
        return new ResponseEntity<>(channelService.getDetailedInformationAboutChannel(channelId), HttpStatus.OK);
    }
}
