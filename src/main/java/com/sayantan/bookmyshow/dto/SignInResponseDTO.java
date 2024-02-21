package com.sayantan.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponseDTO {
    private ResponseStatus status;
    private long userId;
}
