package com.sayantan.bookmyshow.services;

import com.sayantan.bookmyshow.models.Show;
import com.sayantan.bookmyshow.models.ShowSeat;
import com.sayantan.bookmyshow.models.ShowSeatType;
import com.sayantan.bookmyshow.repositories.ShowSeatTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private final ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository) {
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public double caculatePrice(List<ShowSeat> showSeats, Show show) {
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow(show);
        double amount = 0;
        for(ShowSeat showSeat: showSeats) {
            for(ShowSeatType showSeatType: showSeatTypes) {
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType()))
                    amount = amount + showSeatType.getPrice();
            }
        }
        return amount;
    }
}
