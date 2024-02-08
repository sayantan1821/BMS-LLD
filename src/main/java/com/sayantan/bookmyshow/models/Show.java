package com.sayantan.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Show extends BaseModel {
    private Movie movie;
    private Screen screen;
    private Date startTime, endTime;
    List<Feature> features;
}
