package com.sayantan.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    private String nmae;
    private Genre genre;
    private double duration;
    private List<String> languages;
    private List<String> actors;
    private List<Feature> features;
}
