package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelCategory;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelLanguage;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDto {

    private Long id;
    private String name;
    private String description;
    private Long userId;
    private LocalDate creationDate;
    private ChannelLanguage language;
    private byte[] avatar;
    private ChannelCategory category;
    private List<UserDto> userDto;
}
