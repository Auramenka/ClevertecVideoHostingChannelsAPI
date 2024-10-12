package ru.clevertec.clevertecvideohostingchannelapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private String message;
    private String description;
}
