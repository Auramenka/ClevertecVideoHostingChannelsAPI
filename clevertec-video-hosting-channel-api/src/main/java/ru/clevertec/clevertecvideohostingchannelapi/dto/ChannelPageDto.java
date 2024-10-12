package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelPageDto {

    private List<ChannelSummaryDto> channels;
    private Long totalElements;
    private Integer totalPages;
}
