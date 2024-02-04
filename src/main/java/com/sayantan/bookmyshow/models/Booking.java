package com.sayantan.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private User user;
    private Show show;
    private List<Seat> seats;
    private double cost;
    private BookingStatus bookingStatus;
}
