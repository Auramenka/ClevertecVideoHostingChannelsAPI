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
public class ChannelSummaryDto {

    private String name;
    private int subscriberCount;
    private ChannelLanguage language;
    private byte[] avatar;
    private ChannelCategory category;
}
