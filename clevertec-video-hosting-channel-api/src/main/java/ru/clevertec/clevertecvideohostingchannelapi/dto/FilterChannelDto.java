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
public class FilterChannelDto {

    private String name;
    private ChannelLanguage language;
    private ChannelCategory category;
}
