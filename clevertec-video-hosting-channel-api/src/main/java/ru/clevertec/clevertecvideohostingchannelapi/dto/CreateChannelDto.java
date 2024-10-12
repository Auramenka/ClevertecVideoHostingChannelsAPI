package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelCategory;
import ru.clevertec.clevertecvideohostingchannelapi.model.ChannelLanguage;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateChannelDto {

    private String name;
    private String description;
    private Long userId;
    private ChannelLanguage language;
    private byte[] avatar;
    private ChannelCategory category;
}
