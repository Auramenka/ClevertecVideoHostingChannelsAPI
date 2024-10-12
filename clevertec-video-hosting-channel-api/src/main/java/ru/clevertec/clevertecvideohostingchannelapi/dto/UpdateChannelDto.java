package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelCategory;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelLanguage;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateChannelDto {

    private Long id;
    private String name;
    private String description;
    private ChannelLanguage language;
    private byte[] avatar;
    private ChannelCategory category;
}
