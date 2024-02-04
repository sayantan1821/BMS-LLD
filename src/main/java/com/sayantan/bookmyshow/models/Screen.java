package com.sayantan.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Screen extends BaseModel{
    private List<Seat> seats;
    private String name;
    private List<Feature> features;
}
