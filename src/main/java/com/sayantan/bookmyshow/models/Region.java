package com.sayantan.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Region extends BaseModel{
    private List<Theater> theaters;
    private String name;
    private String state;
}
