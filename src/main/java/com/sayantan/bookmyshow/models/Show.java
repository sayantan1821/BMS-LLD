package com.sayantan.bookmyshow.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Show extends BaseModel {
    private Movie movie;
    private Screen screen;
    private Date startTime, endTime;
}
