package com.sayantan.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Booking extends BaseModel{
    private User user;
    private Show show;
    private List<ShowSeat> showSeats;
    private double amount;
    private BookingStatus bookingStatus;
    private Date bookedAt;
    private List<Payment> payments;
}
