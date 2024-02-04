package com.sayantan.bookmyshow.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seat extends BaseModel{
    private SeatType seatType;
    private Coordinate topLeft, bottomRight;
}
