package com.sayantan.bookmyshow.controllers;

import com.sayantan.bookmyshow.dto.BookMovieRequestDTO;
import com.sayantan.bookmyshow.dto.BookMovieResponseDTO;
import com.sayantan.bookmyshow.dto.ResponseStatus;
import com.sayantan.bookmyshow.models.Booking;
import com.sayantan.bookmyshow.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private final BookingService bookingService;
    @Autowired
    BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookMovieResponseDTO bookMovie(BookMovieRequestDTO bookMovieRequestDTO) {
        BookMovieResponseDTO response = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookMovie(bookMovieRequestDTO.getUserId(),
                    bookMovieRequestDTO.getShowSeatIds(),
                    bookMovieRequestDTO.getShowId());
            response.setBookingId(booking.getId());
            response.setAmount(booking.getAmount());
            response.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
          response.setResponseStatus(ResponseStatus.FAILURE);
        }
        return response;
    }
}
