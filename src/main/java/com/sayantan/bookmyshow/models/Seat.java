package com.sayantan.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
    private int rowVal, colVal;
//    @OneToOne
//    private Coordinate topLeft;
//    private Coordinate bottomRight;
}
