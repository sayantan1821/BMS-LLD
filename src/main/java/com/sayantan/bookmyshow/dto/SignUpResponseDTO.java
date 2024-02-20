package com.sayantan.bookmyshow.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDTO {
    private ResponseStatus status;
    private long userId;
}
