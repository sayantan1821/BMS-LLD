package com.sayantan.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    private Show show;
    private Seat seat;
    private SeatStatus seatStatus;
    private User user;
}
