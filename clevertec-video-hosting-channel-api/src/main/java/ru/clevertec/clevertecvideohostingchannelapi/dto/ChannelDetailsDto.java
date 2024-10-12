package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelCategory;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelLanguage;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChannelDetailsDto {

    private String name;
    private Integer subscriberCount;
    private ChannelLanguage language;
    private byte[] avatar;
    private ChannelCategory category;
    private String description;
    private Long userId;
    private LocalDate creationDate;
}
