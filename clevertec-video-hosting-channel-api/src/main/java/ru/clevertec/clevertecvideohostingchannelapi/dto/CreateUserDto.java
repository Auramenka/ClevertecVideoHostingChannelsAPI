package ru.clevertec.clevertecvideohostingchannelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateUserDto {

    private String nickname;
    private String name;
    private String email;
}
