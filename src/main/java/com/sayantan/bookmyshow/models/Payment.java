package com.sayantan.bookmyshow.models;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class Payment extends BaseModel{
    private Booking booking;
    private String txnId;
    private PaymentStatus paymentStatus;
    private PaymentProvider paymentProvider;
}
